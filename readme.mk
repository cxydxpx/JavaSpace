思考题
1：A线程正在执行一个对象中的同步方法，B线程是否可以同时执行同一个对象中的非同步方法？
2：同上，B线程是否可以同时执行同一个对象中的另一个同步方法？
3：线程抛出异常会释放锁吗？
4：volatile和synchronized区别？
5：写一个程序，证明AtomXXX类比synchronized更高效
6：AtomXXX类可以保证可见性吗？请写一个程序来证明
7：写一个程序证明AtomXXX类的多个方法并不构成原子性
8：写一个程序模拟死锁
9：写一个程序，在main线程中启动100个线程，100个线程完成后，主线程打印“完成”，使用join()和countdownlatch都可以完成，请比较异同。
10：一个高效的游戏服务器应该如何设计架构？