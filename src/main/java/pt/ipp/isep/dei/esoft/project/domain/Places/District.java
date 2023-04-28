package pt.ipp.isep.dei.esoft.project.domain.Places;

public class District extends State {

    private String district;
    private static final String DISTRICT_NAME_POR_OMISSAO = "whithout coutry name";

    public District(String name, String date, String designation, float area, float distanceCityCenter, float price, String typeOfProperty, String district) {
        super(name, date, designation, area, distanceCityCenter, price, typeOfProperty);
        this.district = district;
    }

    public District() {
        super();
        this.district = DISTRICT_NAME_POR_OMISSAO;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return (super.toString() +
                "\nDistrict:\n" +
                "district - " + district + ";\n");
    }

}
