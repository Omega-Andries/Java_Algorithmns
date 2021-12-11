package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;






public class The_Server {
	private static  ServerSocket serverS;
	private static int portNumber = 8081;
	public static void main(String[] args) {
		
	}
	
	private static void run() {
		Socket client = null;
		try {
			client = serverS.accept();
			
			BufferedReader bR = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter pW = new PrintWriter(client.getOutputStream(), true);
			
			int numMSGs = 0;
			String msg = bR.readLine();
			
			while(!msg.equals("CLOSE")) {
				System.out.println("AHA");
				System.out.println("Message Received!!!");
				numMSGs++;
				System.out.println(msg);
				System.out.println(numMSGs+" received");
				pW.println(
						""
						);
				msg = bR.readLine();
			}
		}catch(IOException io) {
			System.err.println("Something went wrong!!!");
			
		}finally {
			if(client !=null) {
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
