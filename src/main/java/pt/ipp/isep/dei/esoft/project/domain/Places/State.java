package pt.ipp.isep.dei.esoft.project.domain.Places;

import pt.ipp.isep.dei.esoft.project.domain.Property;
import java.util.Objects;

public class State extends Property {

    private String stateName;
    private int stateID;
    private final String STATE_NAME_POR_OMISSAO = "without state name";
    private final int STATE_ID_POR_OMISSAO = 0;

    public State(String name, String date, String designation, float area, float distanceCityCenter, float price, String typeOfProperty) {
        super(designation, area, distanceCityCenter, price, typeOfProperty, date);
        this.stateName = name;
    }

    public State() {
        super();
        this.stateName = STATE_NAME_POR_OMISSAO;
        this.stateID = STATE_ID_POR_OMISSAO;
    }

    public int getStateID() {
        return stateID;
    }

    public String getStatename() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public int hashCode() {
        return Objects.hash(stateName);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        State other = (State) obj;
        if (stateName == null) {
            if (other.stateName != null)
                return false;
        } else if (!stateName.equals(other.stateName))
            return false;
        return true;
    }

    public String toString() {
        return (super.toString() +
                "\nState:\n" +
                "name - " + stateName + ";\n");
    }

}
