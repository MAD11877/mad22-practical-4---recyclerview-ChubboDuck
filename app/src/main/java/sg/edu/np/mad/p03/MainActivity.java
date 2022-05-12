package sg.edu.np.mad.p03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Button message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivingEnd = getIntent();
        User userInfo = (User) receivingEnd.getSerializableExtra("userObject");

        TextView nameDisplay = findViewById(R.id.Title);
        nameDisplay.setText(userInfo.Name);

        TextView descDisplay = findViewById(R.id.description);
        descDisplay.setText(userInfo.Description);

        if (userInfo.Followed){
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
        User userInfo = (User) receivingEnd.getSerializableExtra("userObject");
        userInfo.Followed = !userInfo.Followed;
        Button followBtn = findViewById(R.id.button6);   //linked to the follow button
        followBtn.setText(userInfo.Followed ? "Unfollow" : "Follow");   //if followed, set text to unfollow, vice versa
        Toast.makeText(getApplicationContext(), userInfo.Followed ? "Followed" : "Unfollowed", Toast.LENGTH_LONG).show();   // same concept as the above but Toast msg
        ListActivity.userList.get(userInfo.Id - 1).Followed = userInfo.Followed;  //Set new value in the list
    }
}