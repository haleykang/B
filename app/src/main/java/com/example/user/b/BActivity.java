package com.example.user.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.a.SampleData;

public class BActivity extends Activity {

    private static final String TAG = "**BActivity**";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_layout);

        TextView receivedStr3 = (TextView)findViewById(R.id.intent_received_data3);

        Log.v(TAG, "onCreate() 시작");


        Intent intent = getIntent();
        // String name = intent.getStringExtra("NAME");

        Log.v(TAG, "intent 객체 생성");
        SampleData sampleData = (SampleData)intent.getParcelableExtra("SAMPLE_DATA");

        Log.v(TAG, "SampleData 받아오기");

        if (sampleData == null) {
            shortToast("Sample Data null!");
            Log.v(TAG, "Sample Data null!!");

            return;

        }

        Bundle bundle = intent.getBundleExtra("BUNDLE_DATA");

        if (bundle == null) {

            shortToast("Bundle Data null!");

            return;
        }

        receivedStr3.setText("Bundle String : " + bundle.getString("STR_DATA") + "\n" +
                "Bundle Int : " + bundle.getInt("INT_DATA"));

        Parcel parcel = Parcel.obtain();

        parcel.writeInt(10);
        parcel.writeString("The animals were left to starve to death.");

        TextView receivedStr2 = (TextView)findViewById(R.id.intent_received_data2);
        parcel.setDataPosition(0);
        receivedStr2.setText("Parcel Data : " + parcel.readInt() + "\n" + parcel.readString());


        TextView receivedStr = (TextView)findViewById(R.id.intent_received_data);
        receivedStr.setText("Sample Data : " + sampleData.getIntData() +
                "\n" + sampleData.getStrData());


       /* Uri imageUri = intent.getData();
        TextView reveivedStr4 = (TextView)findViewById(R.id.intent_received_data4);
        StringBuilder temp = new StringBuilder();

        temp.append("Schema : " + imageUri.getScheme() + "\n");
        temp.append("Host : " + imageUri.getHost() + "\n");
        temp.append("Port : " + imageUri.getPort() + "\n");
        temp.append("Path : " + imageUri.getPath() + "\n");
        temp.append("Query : " + imageUri.getQuery() + "\n");
        temp.append("Fragment : " + imageUri.getFragment() + "\n");
        temp.append("Authority : " + imageUri.getAuthority() + "\n");
        temp.append("Last Path Segment : " + imageUri.getLastPathSegment() + "\n");

        reveivedStr4.setText(temp);*/

        Log.v(TAG, "텍스트 세팅");
    }


    private void shortToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
