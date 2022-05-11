package sg.edu.np.mad.p03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    User user = new User("MAD",
            "Lorem ipsum dolor sit amet, consectetur\n" +
            "adipiscing elit, sed do eiusmod tempor\n" +
            "incididunt ut labore et dolore magna aliqua", 1, false);
    Boolean followed = user.Followed;
    TextView text;
    Button message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        text = findViewById(R.id.Title);
        text.setText(user.Name);

        text = findViewById(R.id.description); // Description text
        text.setText(user.Description); // Set text to user class info

        if (followed) {        // if user has already followed, show unfollow text, else show default page
            text = findViewById(R.id.button6);
            text.setText("Unfollow");
        }*/

        Intent receivingEnd = getIntent();
        String username = receivingEnd.getStringExtra("Name");
        String userDesc = receivingEnd.getStringExtra("Desc");
        Integer userID = receivingEnd.getIntExtra("ID",0);
        Boolean userFollowStatus = receivingEnd.getBooleanExtra("FollowStatus",false);

        TextView nameDisplay = findViewById(R.id.Title);
        nameDisplay.setText(username);

        TextView descDisplay = findViewById(R.id.description);
        descDisplay.setText(userDesc);

        if (userFollowStatus){
            text = findViewById(R.id.button6);
            text.setText("Unfollow");
        }

        message = findViewById(R.id.message);   //place an event listener on the onclick button
        message.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent msgGrp = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(msgGrp);
            }
        });

    }

    public void Follow(View view){
        Intent receivingEnd = getIntent();
        Boolean userFollowStatus = receivingEnd.getBooleanExtra("FollowStatus",false);
        Integer userID = receivingEnd.getIntExtra("ID",0);
        Button followBtn = findViewById(R.id.button6);   //linked to the follow button
        userFollowStatus = !userFollowStatus;  //Alternates user.followed value: True and False

        if (userFollowStatus){
            followBtn.setText("Unfollow");
            Toast.makeText(getBaseContext(),"Followed",Toast.LENGTH_SHORT).show();
        }
        else {
            followBtn.setText("Follow");
            Toast.makeText(getBaseContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
        }

        Intent rvAdapt = new Intent(MainActivity.this, RecyclerViewAdapter.class);
        rvAdapt.putExtra("followChange",userID);
    }
}