package pt.ipp.isep.dei.esoft.project.domain;

public class RequestType {
    private String name;
    public RequestType (String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
