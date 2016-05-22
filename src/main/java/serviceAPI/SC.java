package serviceAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by phujcn on 22/05/2016.
 */
public class SC{


    private ArrayList<String> renderStatus(String input){
        Matcher m = Pattern.compile("SERVICE_NAME:(?:(?!SERVICE_NAME).)*").matcher(input);
        ArrayList<String> output = new ArrayList<String>();
        while (m.find()) {
            output.add(m.group(0));
        }
        return output;
    }


    public ArrayList<String> getStatus() {
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

        output=renderStatus(output.toString());
        return output;
    }
}
