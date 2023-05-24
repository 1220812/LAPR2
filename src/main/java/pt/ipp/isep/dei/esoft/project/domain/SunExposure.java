package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

/**
 * The type Sun exposure.
 */
public class SunExposure {
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

    @Override
    public SunExposure clone() {
        return new SunExposure(this.sunExposure);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SunExposure that = (SunExposure) o;
        return Objects.equals(sunExposure, that.sunExposure);
    }

    @Override
    public String toString() {
        return sunExposure;
    }
}