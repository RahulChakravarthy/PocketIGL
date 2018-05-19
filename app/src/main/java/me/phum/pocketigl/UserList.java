package me.phum.pocketigl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import java.util.*;

import me.phum.pocketigl.R;

public class UserList extends FrameLayout {
    RecyclerView playerList;
    public UserList(@NonNull Context context) {
        super(context);
        inflate(context, R.layout.user_picker_view, this);
        playerList = findViewById(R.id.player_list);
    }

    public static void DisplayUsrList(String[] Users){

    }

}
