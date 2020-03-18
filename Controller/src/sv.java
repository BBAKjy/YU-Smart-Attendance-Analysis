import java.io.BufferedReader;
import java.util.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class sv {
	public static void main(String args[]) {
		
		String ipaddr;
		String data;
		
		Scanner a = new Scanner(System.in);
		
		System.out.printf("아이피 주소 입력 (디폴트 값 쓰려면 그냥 엔터) : "); // 165.229.125.198;
		ipaddr=a.nextLine();
		if(ipaddr.equals("")) {
			ipaddr="165.229.125.198";
		}
		
		System.out.printf("데이터값 입력 : ");
		data=a.nextLine();
		
		try {
			Socket socket = new Socket(ipaddr,7777); // 내 폰 아이디랑 포트
			OutputStream output = socket.getOutputStream();
			OutputStreamWriter outputwriter = new OutputStreamWriter(output);
			BufferedWriter buffer = new BufferedWriter(outputwriter);
			
			buffer.write(data); // 보낼 데이터값
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
