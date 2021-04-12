import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CPDServer {
  public static String IP = "127.0.0.1";
  public static int PORT = 7777;
  private ServerSocket cpdServer;

  public void start() throws IOException {
    cpdServer = new ServerSocket(PORT);

    while (true) {
      Socket receiver = cpdServer.accept();
      new CPDServerClientsHandler(receiver).start();
    }

  }

  public void stop() throws IOException {
    cpdServer.close();
  }

  public static void main(String[] args) throws IOException {
    CPDServer server = new CPDServer();
    server.start();
  }


}
