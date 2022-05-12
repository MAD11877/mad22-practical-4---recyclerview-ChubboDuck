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
        Button followBtn = findViewById(R.id.button6);   //linked to the follow button
        if (!userInfo.Followed){    //if followed, then go to else and set text to unfollow, vice versa
            followBtn.setText("Unfollow");
            Toast.makeText(getBaseContext(),"Followed" +"",Toast.LENGTH_LONG).show();
        }
        else {
            followBtn.setText("Follow"); //Follow
            Toast.makeText(getBaseContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
        }
        ListActivity.userList.get(0).Followed = userInfo.Followed;
    }
}