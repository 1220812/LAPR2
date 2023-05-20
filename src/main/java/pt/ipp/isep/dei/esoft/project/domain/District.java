package pt.ipp.isep.dei.esoft.project.domain;

public class District{
    /**
     * District name
     */
    private String name;

    /**
     * Creates a new instance of district with name
     * @param name district name
     */
    public District (String name){
        this.name = name;
    }

    /**
     * Method to show the name of the district
     * @return district name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to change the name of the district
     * @param name changed district name
     */
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                '}';
    }
}