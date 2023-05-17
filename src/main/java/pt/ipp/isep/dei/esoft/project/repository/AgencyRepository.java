package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agency;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Agency repository.
 */
public class AgencyRepository {
    /**
     * List of agencies
     */
    private static List<String> agency = new ArrayList<>(){{
        add("1. agency1");
        add("2. agency2");
        add("3. agency3");
        add("4. agency4");
        add("5. agency5");
    }
    };
    private final List<Agency> agencyList = new ArrayList<>();

    public List<Agency> getAgencyList(){
        return List.copyOf(agencyList);
    }
    /**
     * Get agencies names
     */
    public static void getAgencies(){
        for (String item : agency){
            System.out.println(item);
        }
    }
    /**
     * List of branches of the agency
     */
    private static List<String> branch = new ArrayList<>(){{
        add("1. New York");
        add("2. San Francisco");
        add("3. Los Angeles");
        add("4. Las vegas");

    }
    };
    /**
     * Get branches of the agency
     */
    public static void getBranches(){
        for(String item : branch){
            System.out.println(item);
        }
    }

    /**
     * List of agents of the branch
     */
    private static List<String> agents = new ArrayList<>(){{
        add("1. John Teixeira");
        add("2. Abel Melbourne");
        add("3. Tyler Jackson");
    }
    };

    /**
     * Get agents of the branch
     */
    public static void getAgents() {
        for (String item : agents) {
            System.out.println(item);
        }
    }
}