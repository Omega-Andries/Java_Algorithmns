package sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class send {

	public static void main(String[] args) {
		String toSend = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Send: ");toSend = sc.nextLine();
		try {
			DatagramSocket sendSocket = new DatagramSocket();
			byte[] sendP = toSend.getBytes();
			InetAddress iP = InetAddress.getByName("localhost");
			DatagramPacket sendPacket = new DatagramPacket(sendP, sendP.length, iP, 9876);
			
			sendSocket.send(sendPacket);
			sendSocket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

}
