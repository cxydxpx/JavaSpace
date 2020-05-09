package com.fc.nettydemo;

import java.nio.Buffer;
import java.nio.ByteBuffer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

/**
 * netty服务端
 * NioEventLoopGroup是一个处理I/O操作的多线程事件循环。
 * Netty为不同类型的传输提供了各种EventLoopGroup实现。
 * 我们在这个例子中实现了一个服务器端应用程序，
 * 因此将使用两个NioEventLoopGroup。第一个通常被称为“boss”，接受传入的连接。第二个通常称为“worker”，
 * 在boss接受连接并将接受的连接注册到worker之后，处理接受连接的流量。使用多少线程以及如何将它们映射到创建的通道取决于EventLoopGroup实现，
 * 甚至可以通过构造函数进行配置。
 * <p>
 * ServerBootstrap是一个设置服务器的助手类。您可以直接使用通道设置服务器。但是，请注意这是一个冗长的过程，在大多数情况下您不需要这样做。
 * 在这里，我们指定使用NioServerSocketChannel类，该类用于实例化一个新通道以接受传入连接。
 * <p>
 * 这里指定的处理程序总是由新接受的通道计算。ChannelInitializer是用于帮助用户配置新通道的特殊处理程序。
 * 您很可能希望通过添加一些处理程序(如DiscardServerHandler)来实现您的网络应用程序，来配置新通道的ChannelPipeline。
 * 随着应用程序变得复杂，您可能会向管道中添加更多的处理程序，并最终将这个匿名类提取到顶级类中。
 * <p>
 * 您还可以设置特定于通道实现的参数。我们正在编写TCP/IP服务器，因此我们可以设置套接字选项，如tcpNoDelay和keepAlive。
 * 请参阅ChannelOption的apidocs和特定的ChannelConfig实现，以获得受支持的ChannelOptions的概述。
 * <p>
 * 你注意到option()和childOption()了吗?option()用于接收传入连接的NioServerSocketChannel。
 * childOption()用于父服务器通道接受的通道，在本例中是NioServerSocketChannel。
 * 我们现在准备好出发了。剩下的就是绑定到端口并启动服务器。在这里，我们绑定到机器中所有NICs(网络接口卡)的端口8080。
 * 现在，您可以任意次数地调用bind()方法(使用不同的绑定地址)。
 * <p>
 * telnet 可以测试服务器是否工作
 * telnet localhost 8080
 */
public class NettyServer {

    Buffer jd;
    ByteBuffer bbf;

    public static void main(String[] args) throws Exception {
        new NettyServer().run(8080);
    }

    public void run(int port) throws Exception {
        /**
         * NioEventLoopGroup是一个处理I/O操作的多线程事件循环。
         * Netty为不同类型的传输提供了各种EventLoopGroup实现。
         * 我们在这个例子中实现了一个服务器端应用程序，
         * 因此将使用两个NioEventLoopGroup。
         * 第一个通常被称为“boss”，接受传入的连接。第二个通常称为“worker”，
         * 在boss接受连接并将接受的连接注册到worker之后，处理接受连接的流量。
         * 使用多少线程以及如何将它们映射到创建的通道取决于EventLoopGroup实现，
         * 甚至可以通过构造函数进行配置。
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        System.out.println("准备运行端口：" + port);
        /*
         * ServerBootstrap是一个设置服务器的助手类。
         * 您可以直接使用通道设置服务器。但是，请注意这是一个冗长的过程，在大多数情况下您不需要这样做。
         * 在这里，我们指定使用NioServerSocketChannel类，该类用于实例化一个新通道以接受传入连接。
         */
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap = serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                /*
                 *  这里指定的处理程序总是由新接受的通道计算。
                 *  ChannelInitializer是用于帮助用户配置新通道的特殊处理程序。
                 *
                 */
                .childHandler(new ChildChannelHandler());


    }

}

//ChannelInitializer是用于帮助用户配置新通道的特殊处理程序
class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    //请求到达后调用
    protected void initChannel(SocketChannel socketChannel) throws Exception {
//        ByteBuf byteBuf= Unpooled.copiedBuffer("$".getBytes());
//        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,byteBuf));
        socketChannel.pipeline().addLast(new StringDecoder());//进行字符串的编解码设置
        socketChannel.pipeline().addLast(new StringEncoder());
        socketChannel.pipeline().addLast(new ReadTimeoutHandler(60));//设置超时时间
        /**
         *  您很可能希望通过添加一些处理程序(如DiscardServerHandler)来实现您的网络应用程序，来配置新通道的ChannelPipeline。
         */
        socketChannel.pipeline().addLast(new DiscardServerHandler());
    }
}

/**
 * 服务器类型设置
 **/
class DiscardServerHandler extends ChannelHandlerAdapter {
    //只要接收到数据，就会调用channelRead()方法
//    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        try {
            //ByteBuf是一个引用计数的对象，必须通过release()方法显式地释放它
            ByteBuf in = (ByteBuf) msg;
            System.out.println("传输内容是");
            System.out.println(in.toString(CharsetUtil.UTF_8));
            //返回信息
            ByteBuf resp = Unpooled.copiedBuffer("收到信息$".getBytes());
            ctx.writeAndFlush(resp);
        } finally {
            System.out.println(msg);
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 出现异常就关闭
        cause.printStackTrace();
        ctx.close();
    }

}

