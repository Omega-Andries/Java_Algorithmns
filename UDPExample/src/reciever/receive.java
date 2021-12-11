package reciever;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class receive {

	public static void main(String[] args) {
		String msg = "";
		try {
			DatagramSocket recieveSocket = new DatagramSocket(9876);
			byte[] recieveData = new byte[1024];
			
			DatagramPacket receiveP = new DatagramPacket(recieveData, recieveData.length);
			
			recieveSocket.receive(receiveP);
			
			msg = new String(receiveP.getData());
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(msg);

	}

}
