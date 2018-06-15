package com.passionatedeveloper.multiplemessenger;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView ivBackground;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> backdropPath = getPaths();
        String posterPath = "https://cdn.pixabay.com/photo/%s";
        String path = getPath(posterPath, backdropPath);
        Log.d("DEBUG",path);
        ivBackground = (ImageView) findViewById(R.id.ivBackground);
        button = (Button) findViewById(R.id.buttonSend);
        Picasso.get().load(path).into(ivBackground);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Enter your message...");
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.dialog_main_send,null,false);
                builder.setPositiveButton("SEND", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
            }
        });
    }

    private String getPath(String posterPath, ArrayList<String> backdropPath) {
        int position = ((int) (Math.random() * (backdropPath.size() + 1000)) % backdropPath.size());
        String path = String.format(posterPath, backdropPath.get(position));
        return path;
    }

    private ArrayList<String> getPaths() {
        ArrayList<String> list = new ArrayList<>();
        list.add("2016/06/26/22/36/background-1481487_1280.jpg");
        list.add("2014/09/24/16/28/bricks-459299_1280.jpg");
        list.add("2013/07/25/13/01/stones-167089_1280.jpg");
        list.add("2015/12/13/02/07/pebbles-1090536_1280.jpg");
        list.add("2015/12/26/05/53/wood-1108307_1280.jpg");
        return list;
    }
}
