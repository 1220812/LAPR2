package pt.ipp.isep.dei.esoft.project.domain;

public class AgentComission extends Agent {

    private float comission;


    private static final float COMISSION_POR_OMISSAO = 0;

    public AgentCommission(String designation, float area, float distanceCityCenter, float price, String typeOfProperty, String date, String agentName, String email, int passportCardNumber, int phoneNumeber, int vatNumber, float comission) {
        super(designation, area, distanceCityCenter, price, typeOfProperty, date, agentName,  email, passportCardNumber, phoneNumeber, vatNumber);
        this.comission = comission;
    }

    public AgentCommission() {
        super();
        comission = COMISSION_POR_OMISSAO;
    }

    public float getComission() {
        return comission;
    }

    public void setComission(float comission) {
        this.comission = comission;
    }

    @Override
    public String toString() {
        return "AgentCommission:\n" +
                "comission - " + comission + ";\n";
    }

}
