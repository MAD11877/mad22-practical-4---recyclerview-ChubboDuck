package sg.edu.np.mad.p03;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder>{
    ArrayList<User> data;
    public RecyclerViewAdapter (ArrayList<User> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recyclerview_row,
                null,
                false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User s = data.get(position);
        holder.user.setText(s.Name);
        holder.desc.setText("Description: " + s.Description);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                builder.setTitle("Profile");
                builder.setMessage(s.Name);
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent mainAct = new Intent(view.getContext(), MainActivity.class);
                        /*Bundle userInfo = new Bundle();
                        userInfo.putString("Name",s.Name);
                        userInfo.putString("Desc",s.Description);
                        userInfo.putInt("ID",s.Id);
                        userInfo.putBoolean("FollowStatus",s.Followed);
                         */

                        mainAct.putExtra("userObject", (Serializable) s);
                        view.getContext().startActivity(mainAct);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                    }
                });
                builder.show();
            }
        });
        if (s.Name.endsWith("7")){
            holder.profPic.setVisibility(View.VISIBLE);
        }
        else{
            holder.profPic.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
