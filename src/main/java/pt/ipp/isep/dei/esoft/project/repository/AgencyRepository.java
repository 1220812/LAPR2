package pt.ipp.isep.dei.esoft.project.repository;

import java.util.ArrayList;
import java.util.List;

public class AgencyRepository {
    private static List<String> agency=new ArrayList<String>(){{
        add("1. agency1");
        add("2. agency2");
        add("3. agency3");
        add("4. agency4");
        add("5. agency5");

    }
    };

    public static void getAgencies(){
        for (String item : agency){
            System.out.println(item);
        }
    }

    public static List<String> getAgency() {
        return agency;
    }
}
