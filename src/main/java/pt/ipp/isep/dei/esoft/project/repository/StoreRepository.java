package pt.ipp.isep.dei.esoft.project.repository;

import java.util.ArrayList;
import java.util.List;


/**
 * A static list of stores.
 */
public class StoreRepository {
    private static List<String> store=new ArrayList<String>(){{
        add("1. store1");
        add("2. store2");
        add("3. store3");
        add("4. store5");
        add("5. store5");
    }
    };

    /**
     * Retrieves the list of stores and prints them to the console.
     */
    public static void getStores(){
        for (String item : store){
            System.out.println(item);
        }
    }
}

