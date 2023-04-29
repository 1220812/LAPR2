package pt.ipp.isep.dei.esoft.project.repository;

import java.util.ArrayList;
import java.util.List;

public class agencyRepository {
    private static List<String> agency=new ArrayList<String>(){{
        add("agency1");
        add("agency2");
        add("agency3");
        add("agency4");
        add("agency5");

    }
    };

    public static void getAgencies(){
        for (String item : agency){
            System.out.println(item);
        }
    }
}
