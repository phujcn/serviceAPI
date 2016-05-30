package serviceAPI;


import java.util.ArrayList;

/**
 * Created by phujcn on 22/05/2016.
 */



public class Status {
    private final long id;
    private final ArrayList<Service> status;

    public Status(long id,ArrayList<Service> status) {
        this.id = id;
        this.status=status;
    }

    public ArrayList<Service> getStatus() {
        return status;
    }
    public long getId(){
        return id;
    }
}
