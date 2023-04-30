package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.DistrictRepository;

public class District {
    private String name;

    public District(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName (String name){
        this.name=name;
    }
}
