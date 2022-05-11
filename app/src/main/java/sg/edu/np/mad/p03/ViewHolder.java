package sg.edu.np.mad.p03;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView user;
    TextView desc;
    ImageView img;
    ImageView profPic;
    public ViewHolder(View itemView) {
        super(itemView);
        user = itemView.findViewById(R.id.username);
        desc = itemView.findViewById(R.id.description);
        img = itemView.findViewById(R.id.ProfilePic);
        profPic = itemView.findViewById(R.id.bigProfilePic);
    }
}


