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

import java.util.logging.Logger;

public class SC{
    private static final Logger LOGGER = Logger.getLogger(SC.class.getName());
    private static final Pattern pService = Pattern.compile("SERVICE_NAME\\:\\s+((?:(?!\\S+\\s*\\:).)*).*?STATE\\s*\\:\\s+((?:(?!\\S+\\s*\\:).)*).*?SERVICE_EXIT_CODE\\s*\\:\\s+((?:(?!\\S+\\s*\\:).)*).*",Pattern.MULTILINE|Pattern.DOTALL);

    private ArrayList<Service> renderStatus(String input){
        Matcher m = Pattern.compile("SERVICE_NAME:(?:(?!SERVICE_NAME).)*").matcher(input);
        ArrayList<Service> output = new ArrayList<Service>();
        String serviceText;

        Service service = null;
        Matcher mService = null;

        while (m.find()) {
            serviceText=m.group(0);
            mService= pService.matcher(serviceText);
            if (mService.matches()){
                service = new Service(mService.group(1),mService.group(2),mService.group(3));
                output.add(service);
                }
            else{
                LOGGER.info("Did not match: "+serviceText);
            }

        }
        return output;
    }


    public ArrayList<Service> getStatus() {
        Runtime rt = Runtime.getRuntime();
        String[] commands = {"sc", "query"};
        String s = null;
        ArrayList<String> output = new ArrayList();
        ArrayList<Service> services = new ArrayList<>();
        LOGGER.info("Running 'sc query' to get service status");
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

        services=renderStatus(output.toString());
        return services;
    }
}
