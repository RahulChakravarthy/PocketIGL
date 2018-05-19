package me.phum.pocketigl;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecycleViewAdapter";
    private ArrayList<String> UserNames = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> userNames, Context mContext) {
        UserNames = userNames;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Responsible for inflating view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder: called. ");
        holder.user.setText(UserNames.get(position));

        holder.user.setOnClickListener(new View.OnClickListener(){
            @Override


        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView user;
        RelativeLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.user);
            parentLayout =itemView.findViewById(R.id.parent_layout);
        }
    }
}
