package com.example.smartattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button button, button2, button3, button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button5 = (Button)findViewById(R.id.button5);

        final Runtime rt = Runtime.getRuntime();

        try{
            rt.exec("su");
        }catch(IOException e){
            e.printStackTrace();
        }

        Thread desktopServerThread = new Thread(new Network());
        desktopServerThread.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BluetoothAdapter mBA = BluetoothAdapter.getDefaultAdapter();

                if(mBA == null){
                    Toast.makeText(MainActivity.this, "응 안돼~", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "응 돼~", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BluetoothAdapter mBA1 = BluetoothAdapter.getDefaultAdapter();
                if(!mBA1.isEnabled()){
                    mBA1.enable();
                }else{
                    Toast.makeText(MainActivity.this, "벌써 켜놨음", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BluetoothAdapter mBA2 = BluetoothAdapter.getDefaultAdapter();
                if(mBA2.isEnabled()){
                    mBA2.disable();
                }else{
                    Toast.makeText(MainActivity.this, "벌써 꺼놨음", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BluetoothAdapter mBA3 = BluetoothAdapter.getDefaultAdapter();

                if(!mBA3.isEnabled()){
                    Toast.makeText(MainActivity.this, "블루투스 꺼져있음", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mBA3.getScanMode() == BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE){
                    Toast.makeText(MainActivity.this, "한번만 눌러야함", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 0);
                startActivity(intent);
            }
        });
    }
}
