package serviceAPI;

/**
 * Created by phujcn on 30/05/2016.
 */

public class Service {
    private final String name;
    private final String state;
    private final String exitCode;

    /*
    * A serializable class for storing service information
    *
    * @param name Name of the windows service
    * @param state state of the windows service
    * @param exitCode exit code of the windows service if stopped
    */
    public Service(String name,String state,String exitCode){
        this.name=name;
        this.state=state;
        this.exitCode=exitCode;
    }

    public String getName(){
        return name;
    }

    public String getState(){
        return state;
    }

    public String getExitCode(){
        return exitCode;
    }
}
