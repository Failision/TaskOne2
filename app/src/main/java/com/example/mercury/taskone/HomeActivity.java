package com.example.mercury.taskone;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class HomeActivity extends ActionBarActivity {

    String middle;
    ArrayList<HomeItems> items;
    ListView listView;
    Button bgButton;
    TextView text;
    int num_position = 0;
    boolean dialogFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        items = new ArrayList<HomeItems>();
        listView = (ListView) findViewById(R.id.listView);
        middle = getResources().getString(R.string.base_text);

        for (int i = 1; i < 101; i++) {
            String str = "N" + i;
            HomeItems item = new HomeItems(R.drawable.circle, middle, str);
            items.add(item);
        }
        ColorfulAdapter nA = new ColorfulAdapter(this, items);
        listView.setAdapter(nA);

        if (savedInstanceState != null) {
            num_position = savedInstanceState.getInt("num_position", 0);
            dialogFlag = savedInstanceState.getBoolean("dialog_flag");
            if(dialogFlag == true) {
                callDilaog(num_position);
            }

        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //     @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("list", "itemClick: position = " + position + ", id = " + id);
                num_position = position + 1;
                dialogFlag = true;
                callDilaog(num_position);
            }
        });
    }

    void callDilaog(int position) {
        final Dialog dialog = new Dialog(HomeActivity.this);
        dialog.setTitle(R.string.title_activity_home_screen);
        dialog.setContentView(R.layout.dialog_pressed_information);
        bgButton = (Button) dialog.findViewById(R.id.button_exit);
        text = (TextView) dialog.findViewById(R.id.pressed_number_text);

        text.setText(getResources().getString(R.string.clicked_message) + " " + position);
        bgButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
            dialog.cancel();
            dialogFlag = false;
                                        }
                                    }
        );
        dialog.show();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("num_position", num_position);
        outState.putBoolean("dialog_flag", dialogFlag);
    }

}
