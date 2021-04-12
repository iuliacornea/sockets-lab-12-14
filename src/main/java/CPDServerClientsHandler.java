import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CPDServerClientsHandler extends Thread {

  private Socket receiver;
  private BufferedReader in;
  private PrintWriter out;

  CPDServerClientsHandler(Socket receiver) {
    this.receiver = receiver;
  }

  @Override
  public void run () {
    try {
      in = new BufferedReader(new InputStreamReader(receiver.getInputStream()));
      out = new PrintWriter(receiver.getOutputStream(), true);

      String message;
      while ((message = in.readLine()) != null ) {
        if("disconnect".equals(message)) {
          out.println("you are disconnected");
          break;
        }
        out.println("received: " + message);
      }

      in.close();
      out.close();
      receiver.close();
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }
}
