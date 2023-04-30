package pt.ipp.isep.dei.esoft.project.repository;

import java.util.ArrayList;
import java.util.List;


/**
 * A static list of agency names.
 */
public class AgencyRepository {
    private static List<String> agency=new ArrayList<String>(){{
        add("1. agency1");
        add("2. agency2");
        add("3. agency3");
        add("4. agency4");
        add("5. agency5");

    }
    };
    /**
     * Retrieves the list of agencies and prints them to the console.
     */
    public static void getAgencies(){
        for (String item : agency){
            System.out.println(item);
        }
    }
}
