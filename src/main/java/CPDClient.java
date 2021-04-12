import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class CPDClient {
  private BufferedReader in;
  private PrintWriter out;
  Socket sender;

  public void connect() throws IOException {
    sender = new Socket(CPDServer.IP, CPDServer.PORT);

    in = new BufferedReader(new InputStreamReader(sender.getInputStream()));
    out = new PrintWriter(sender.getOutputStream(), true);
  }

  public String sendMessage(String message) throws IOException {
    out.println(message);
    return in.readLine();
  }

  public void disconnect() throws IOException {
    in.close();
    out.close();
    sender.close();
  }
}
