package telran.deadlock.tasks;

import telran.deadlock.model.Server;

public class User implements Runnable {
    String name;
    Server server1;
    Server server2;

    public User(String name, Server server1, Server server2) {
        this.name = name;
        this.server1 = server1;
        this.server2 = server2;
    }

    @Override
    public void run() {
        System.out.println("Connecting to " + server1.getIp());
        synchronized (server1) {
            server1.connect(server1.getIp(), server1.getSshPort());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Connecting to " + server2.getIp());
            synchronized (server2) {
                server2.connect(server2.getIp(), server2.getSshPort());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
        }


    }
}
