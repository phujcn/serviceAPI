package serviceAPI;


/**
 * Created by phujcn on 22/05/2016.
 */



public class Status {
    private final long id;
    private final String status;

    public Status(long id,String status) {
        this.id = id;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }
    public long getId(){
        return id;
    }
}
