package pt.ipp.isep.dei.esoft.project.domain;

public class Agent extends Property{
    private String agentName;
    private String email;
    private int passportCardNumber;
    private int phoneNumeber;
    private int vatNumber;

    private static final String AGENT_NAME_POR_OMISSAO = "without agent name";
    private static final String EMAIL_POR_OMISSAO = "without email";
    private static final int PASSPORT_CARD_NUMBER_POR_OMISSAO = 0;
    private static final int PHONE_NUMBER_NUMBER_POR_OMISSAO = 0;
    private static final int VAT_NUMBER_NUMBER_POR_OMISSAO = 0;


    public Agent(String designation, float area, float distanceCityCenter, float price, String typeOfProperty, String date, String agentName, String email, int passportCardNumber, int phoneNumeber, int vatNumber) {
        super(designation, area, distanceCityCenter, price, typeOfProperty, date);
        this.agentName = agentName;
        this.email = email;
        this.passportCardNumber = passportCardNumber;
        this.phoneNumeber = phoneNumeber;
        this.vatNumber = vatNumber;
    }

    public Agent() {
        super();
        agentName = AGENT_NAME_POR_OMISSAO;
        email = EMAIL_POR_OMISSAO;
        passportCardNumber = PASSPORT_CARD_NUMBER_POR_OMISSAO;
        phoneNumeber = PHONE_NUMBER_NUMBER_POR_OMISSAO;
        vatNumber = VAT_NUMBER_NUMBER_POR_OMISSAO;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getEmail() {
        return email;
    }

    public int getPassportCardNumber() {
        return passportCardNumber;
    }

    public int getPhoneNumeber() {
        return phoneNumeber;
    }

    public int getVatNumber() {
        return vatNumber;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassportCardNumber(int passportCardNumber) {
        this.passportCardNumber = passportCardNumber;
    }

    public void setPhoneNumeber(int phoneNumeber) {
        this.phoneNumeber = phoneNumeber;
    }

    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    }

    @Override
    public String toString() {
        return (super.toString() +
                "\nAgent:\n" +
                "agentName - " + agentName + ";\n" +
                "email - " + email + ";\n" +
                "passportCardNumber - " + passportCardNumber + ";\n" +
                "phoneNumeber - " + phoneNumeber + ";\n" +
                "vatNumber - " + vatNumber + ";\n");
    }

}
