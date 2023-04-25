package pt.ipp.isep.dei.esoft.project.repository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class roleRepository {
    private final List Role = new ArrayList<>(Arrays.asList("Agent","Store Manager","Network Manager"));

    public List getRole() {
        return Role;
    }
}

