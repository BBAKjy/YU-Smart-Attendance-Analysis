package sdfsd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class FFF {
	public static void main(String args[]) {
		try {
			Socket socket = new Socket("165.229.134.237",8080); // 내 폰 아이디랑 포트
			OutputStream output = socket.getOutputStream();
			OutputStreamWriter outputwriter = new OutputStreamWriter(output);
			BufferedWriter buffer = new BufferedWriter(outputwriter);
			
			buffer.write("GODJY");
			buffer.newLine();
			buffer.flush();
			
			buffer.close();
			outputwriter.close();
			output.close();
			socket.close();
			
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("aa"); // 실행됬나보는거
	}
	
	
}
