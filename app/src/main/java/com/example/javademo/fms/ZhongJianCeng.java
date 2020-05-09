package com.example.javademo.fms;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

// 原始请求
interface Callback {
    void onSuccess(int flag, Object data);

    void onFail(int flag, String errorReason);
}

interface MqttClient {
    void doRequest(Object requestParam, int flag, Callback callback);
}

interface WrapCallback {
    void onSuccess(Object data);

    void onFail(String errorReason);
}

// 中间层
class WrapMqttClient {

    private final MqttClient realClient;
    private final AtomicInteger requestFlagAutoIncrement = new AtomicInteger(0);
    private final Map<Integer, WrapCallback> requestCallbacks = new ConcurrentHashMap<>();

    public WrapMqttClient(MqttClient realClient) {
        this.realClient = realClient;
    }

    public void doRequest(Object requestParam, WrapCallback callback) {
        int flag = requestFlagAutoIncrement.getAndIncrement();
        requestCallbacks.put(flag, callback);
        realClient.doRequest(
                requestParam,
                flag,
                new Callback() {
                    @Override
                    public void onSuccess(int flag, Object data) {
                        requestCallbacks.remove(flag).onSuccess(data);
                    }

                    @Override
                    public void onFail(int flag, String errorReason) {
                        requestCallbacks.remove(flag).onFail(errorReason);
                    }
                }
        );
    }
}

public class ZhongJianCeng {
    // 你
    public static void main(String[] args) {

        MqttClient mqttClient = null;
        WrapMqttClient wrapMqttClient = new WrapMqttClient(mqttClient);

        Object requestParam = null;
        wrapMqttClient.doRequest(requestParam, new WrapCallback() {
            @Override
            public void onSuccess(Object data) {

            }

            @Override
            public void onFail(String errorReason) {

            }
        });

    }

}
