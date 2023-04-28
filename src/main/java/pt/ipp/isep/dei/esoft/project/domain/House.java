package pt.ipp.isep.dei.esoft.project.domain;

public class House {

    /**
     * Existence of basement.
     */
    private String basement;

    /**
     * Existence of inhabitable loft.
     */
    private String inhabitableLoft;

    /**
     * Existence of sun exposure.
     */
    private String sunExposure;

    /**
     * Constructs a house instance receiving the existence of basement, inhabitable loft and sun exposure.
     *
     * @param basement   existence of basement
     * @param inhabitableLoft existence of inhabitable loft
     * @param sunExposure     existence of sun exposure
     */
    public House(String basement, String inhabitableLoft, String sunExposure) {
        this.basement = basement;
        this.inhabitableLoft = inhabitableLoft;
        this.sunExposure = sunExposure;
    }

    /**
     * Returns the existence of basement.
     *
     * @return existence of basement
     */
    public String getBasement() {
        return basement;
    }

    /**
     * Returns the existence of inhabitable loft.
     *
     * @return existence of inhabitable
     */
    public String getInhabitableLoft() {
        return inhabitableLoft;
    }

    /**
     * Returns the existence of sun exposure.
     *
     * @return existence of sun exposure
     */
    public String getSunExposure() {
        return sunExposure;
    }

    /**
     * Modifies the existence of basement.
     *
     * @param basement existence of basement
     */
    public void setExistBasement(String basement) {
        this.basement = basement;
    }

    /**
     * Modifies the existence of inhabitable loft.
     *
     * @param inhabitableLoft existence of inhabitable loft
     */
    public void setInhabitableLoft(String inhabitableLoft) {
        this.inhabitableLoft = inhabitableLoft;
    }

    /**
     * Modifies the existence of sun exposure.
     *
     * @param sunExposure existence of sun exposure
     */
    public void setSunExposure(String sunExposure) {
        this.sunExposure = sunExposure;
    }
}