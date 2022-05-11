package sg.edu.np.mad.p03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MessageGroup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);

        Button btnFrag1;
        Button btnFrag2;
        FragmentFirst firstFragment = new FragmentFirst();
        FragmentSecond secondFragment = new FragmentSecond();

        btnFrag1 = findViewById(R.id.grp1);
        btnFrag2 = findViewById(R.id.grp2);
        btnFrag1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,firstFragment).commit();
            }
        });

        btnFrag2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,secondFragment).commit();
            }
        });

    }
}