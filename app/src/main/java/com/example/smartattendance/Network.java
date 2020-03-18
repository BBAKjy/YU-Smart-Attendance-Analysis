package com.example.smartattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Network extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
    }

    @Override
    public void run() {

        try {
            ServerSocket serverSocket = new ServerSocket(7777);
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    String temp;
                    temp = input.readLine();

                    if(temp.contains("GODJY")){
                        String p = "[En]FU7HgMy";
                        BluetoothAdapter mBA10 = BluetoothAdapter.getDefaultAdapter();
                        mBA10.enable();
                        Thread.sleep(3000);
                        mBA10.setName(p);
                        Thread.sleep(10000);
                        mBA10.disable();
                    }
                    else{
                        String q = temp;
                        BluetoothAdapter mBA11 = BluetoothAdapter.getDefaultAdapter();
                        mBA11.enable();
                        Thread.sleep(3000);
                        mBA11.setName(q);
                        Thread.sleep(10000);
                        mBA11.disable();
                    }
                } catch (Exception e) {
                    Toast.makeText(this, "오류 발생", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "오류 발생", Toast.LENGTH_SHORT).show();
        }
    }
}
