package telran.deadlock.controller;

import telran.deadlock.model.Server;
import telran.deadlock.tasks.User;

public class DeadLockAppl {
    public static void main(String[] args) throws InterruptedException {
        Server server1 = new Server("10.10.10.10", 22);
        Server server2 = new Server("20.20.20.20", 22);
        Server server3 = new Server("30.30.30.30", 22);

        User user1 = new User("User1", server1, server2);
        User user2 = new User("User2", server2, server3);
        User user3 = new User("User3", server3, server1);

        Thread thread1 = new Thread(user1);
        Thread thread2 = new Thread(user2);
        Thread thread3 = new Thread(user3);

        thread1.start();
        Thread.sleep(500);
        thread2.start();
        Thread.sleep(500);
        thread3.start();


    }
}
