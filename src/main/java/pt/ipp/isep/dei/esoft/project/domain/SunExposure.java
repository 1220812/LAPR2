package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;
public class SunExposure {
    /**
     * sun exposure
     */
    private String sunExposure;

    /**
     * Instantiates a new Sun exposure.
     *
     * @param sunExposure the sun exposure
     */
    public SunExposure(String sunExposure) {
        this.sunExposure = sunExposure;
    }

    /**
     * Gets sun exposure.
     *
     * @return the sun exposure
     */
    public String getSunExposure() {
        return sunExposure;
    }

    /**
     * Sets sun exposure.
     *
     * @param sunExposure the sun exposure
     */
    public void setSunExposure(String sunExposure) {
        this.sunExposure = sunExposure;
    }

    /**
     * Method that creates a clone of sun exposure.
     * @return the sun exposure
     */
    @Override
    public SunExposure clone() {
        return new SunExposure(this.sunExposure);
    }

    /**
     * Method that compares two instances of SunExposure.
     * @param o other instance of SunExposure
     * @return true if the instances are equal, false otherwise
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SunExposure that = (SunExposure) o;
        return Objects.equals(sunExposure, that.sunExposure);
    }

    /**
     * Method that returns the characteristics of the sun exposure.
     * @return characteristics of the sun exposure
     */

    @Override
    public String toString() {
        return sunExposure;
    }
}