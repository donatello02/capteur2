
import java.io.IOException;

import net.tinyos.message.*;
import net.tinyos.packet.*;
import net.tinyos.util.*;

public class MesureTempSerial implements MessageListener {

  private MoteIF moteIF;
  
  public MesureTempSerial(MoteIF moteIF) {
    this.moteIF = moteIF;
    this.moteIF.registerListener(new MesureTempMsg(), this);
  }

  public void sendPackets() {
    int counter = 0;
    MesureTempMsg payload = new MesureTempMsg();
    
    try {
      while (true) {
	System.out.println("Sending packet " + counter);
	payload.set_data(counter);
	moteIF.send(0, payload);
	counter++;
	try {Thread.sleep(1000);}
	catch (InterruptedException exception) {}
      }
    }
    catch (IOException exception) {
      System.err.println("Exception thrown when sending packets. Exiting.");
      System.err.println(exception);
    }
  }

  public void messageReceived(int to, Message message) {
    MesureTempMsg msg = (MesureTempMsg)message;
    System.out.println("Received  " + msg.get_data() + " "+ msg.get_src_id()+ " "+ msg.get_dest_id());
  }
  
  private static void usage() {
    System.err.println("usage: MesureTempSerial [-comm <source>]");
  }
  
  public static void main(String[] args) throws Exception {
    String source = null;
    if (args.length == 2) {
      if (!args[0].equals("-comm")) {
	usage();
	System.exit(1);
      }
      source = args[1];
    }
    else if (args.length != 0) {
      usage();
      System.exit(1);
    }
    
    PhoenixSource phoenix;
    
    if (source == null) {
      phoenix = BuildSource.makePhoenix(PrintStreamMessenger.err);
    }
    else {
      phoenix = BuildSource.makePhoenix(source, PrintStreamMessenger.err);
    }

    MoteIF mif = new MoteIF(phoenix);
    MesureTempSerial serial = new MesureTempSerial(mif);
    serial.sendPackets();
  }


}

