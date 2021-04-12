import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CPDTest {

//  @Test
//  public void sayHello_thenRespond() throws IOException {
//    CPDClient client = new CPDClient();
//    client.connect();
//    String response = client.sendMessage("hello server");
//
//    assertEquals("hello receiver", response);
//  }


  @Test
  public void sayHello_thenRespond() throws IOException {
    CPDClient client = new CPDClient();
    client.connect();
    String response1 = client.sendMessage("hello server");
    String response2 = client.sendMessage("just checking");
    String response3 = client.sendMessage("disconnect");
    client.disconnect();

    assertEquals("received: hello server", response1);
    assertEquals("received: just checking", response2);
    assertEquals("you are disconnected", response3);
  }

  @Test
  public void sayHello_thenRespond_again() throws IOException {
    CPDClient client = new CPDClient();
    client.connect();
    String response1 = client.sendMessage("hello server second time");
    String response2 = client.sendMessage("just checking second time");
    String response3 = client.sendMessage("disconnect");
    client.disconnect();

    assertEquals("received: hello server second time", response1);
    assertEquals("received: just checking second time", response2);
    assertEquals("you are disconnected", response3);
  }


//  @Test
//  public void sayNotHello_thenRespond() throws IOException {
//    CPDClient client = new CPDClient();
//    client.connect();
//    String response = client.sendMessage("server");
//
//    assertEquals("no nono no", response);
//  }

}
