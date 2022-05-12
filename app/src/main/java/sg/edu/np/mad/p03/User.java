package sg.edu.np.mad.p03;

import java.io.Serializable;

public class User implements Serializable {
    String Name;
    String Description;
    int Id;
    Boolean Followed;

    public User(String n, String d, int id, boolean f){
        Name = n;
        Description = d;
        Id = id;
        Followed = f;
    }
}