package serviceAPI;


import java.util.ArrayList;

/**
 * Created by phujcn on 22/05/2016.
 */



public class Status {
    private final long id;
    private final ArrayList<String> status;

    public Status(long id,ArrayList<String> status) {
        this.id = id;
        this.status=status;
    }

    public ArrayList<String> getStatus() {
        return status;
    }
    public long getId(){
        return id;
    }
}
