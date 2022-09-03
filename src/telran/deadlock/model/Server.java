package telran.deadlock.model;

public class Server {
    String ip;
    int sshPort;
    int connectionsOpen;


    public Server(String ip, int sshPort) {
        this.ip = ip;
        this.sshPort = sshPort;
    }

    public String getIp() {
        return ip;
    }

    public int getSshPort() {
        return sshPort;
    }


    public int getConnectionsOpen() {
        return connectionsOpen;
    }


    public void connect(String ip, int sshPort) {
        System.out.println("Connected to " + ip);

    }
}
