package sg.edu.np.mad.p03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> userList = new ArrayList<User>();
        for (int index = 0; index < 20; index++){
            Random randObj = new Random();      //reduce the number of times new Random has to be typed
            User randUser = new User("Name" + randObj.nextInt(2147483647),
                    randObj.nextInt(2147483647) + "",      //convert int to string
                    index + 2,
                    randObj.nextBoolean());
            userList.add(randUser);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(userList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                Intent mainAct = new Intent(ListActivity.this, MainActivity.class);
                int randInt = new Random().nextInt(2147483647);
                mainAct.putExtra("randKey", randInt);
                startActivity(mainAct);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
            }
        });

        ImageView img = findViewById(R.id.Android);
        img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                builder.show();
            }
        });
        */
    }

}