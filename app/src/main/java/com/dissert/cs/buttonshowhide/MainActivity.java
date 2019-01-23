package com.dissert.cs.buttonshowhide;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnOne, btnTwo;
    Button btnDisplayFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnDisplayFiles = findViewById(R.id.btnDisplayFiles);

        btnOne.setVisibility(View.VISIBLE);
        btnTwo.setVisibility(View.GONE);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnOne.setVisibility(View.GONE);
                btnTwo.setVisibility(View.VISIBLE);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTwo.setVisibility(View.GONE);
                btnOne.setVisibility(View.VISIBLE);
            }
        });

        btnDisplayFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/DownloadApp";
                Log.d("Files", "Path: " + path);
                File directory = new File(path);
                Log.d("Files", "Directory: " + directory);

                if(!directory.exists()) {
                    Log.d("Files", "No such directory!");
                } else {

                    // Create ArrayList
                    ArrayList<String> fileNames = new ArrayList<>();
                    ArrayList<String> filePaths = new ArrayList<>();

                    File[] files = directory.listFiles();
//                    Log.d("Files", "Files: " + files);
                    Log.d("Files", "Size: "+ files.length);
                    for (int i = 0; i < files.length; i++) {
                        Log.d("Files", "FileName:" + files[i].getName());
                        fileNames.add(files[i].getName());
                        filePaths.add(files[i].getAbsolutePath());

                        //String[] foods = {"Bacon", "Tuna", "Ham", "Potato", "MeatBall"};
                        ListAdapter listAdapter = new CustomAdapter(MainActivity.this, filePaths);
                        ListView listView = findViewById(R.id.myListView);
                        listView.setAdapter(listAdapter);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String videoPath = String.valueOf(parent.getItemAtPosition(position));
                                Toast.makeText(MainActivity.this, videoPath, Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(MainActivity.this, Display.class);
                                intent.putExtra("videoPath", videoPath);
                                startActivity(intent);
                            }
                        });
                    }
                }

            }
        });
    }
}
