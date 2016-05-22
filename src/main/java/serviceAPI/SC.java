package serviceAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by phujcn on 22/05/2016.
 */
public class SC{

    public String getStatus() {
        Runtime rt = Runtime.getRuntime();
        String[] commands = {"sc", "query"};
        String s = null;
        ArrayList<String> output = new ArrayList();

        try {
            Process proc = rt.exec(commands);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            BufferedReader stdErrror = new BufferedReader(new InputStreamReader(proc.getErrorStream()));


            while ((s = stdInput.readLine()) != null) {
                output.add(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return output.toString();
    }
}
