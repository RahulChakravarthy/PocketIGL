package me.phum.pocketigl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        TouchImageView mainMap = (TouchImageView) findViewById(R.id.mainMapImg);
        mainMap.setImageResource(R.drawable.de_mirage);
    }
}
