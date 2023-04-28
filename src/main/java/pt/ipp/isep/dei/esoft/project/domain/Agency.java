package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

public class Agency {
    private String location;
    private String designation;
    List<Request> requests = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
}
