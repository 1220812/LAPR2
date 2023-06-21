package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.SunExposure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Sun exposure repository.
 */
public class SunExposureRepository implements Serializable {
    private List<SunExposure> sunExposureList = new ArrayList<>();

    /**
     * Addsun exposure.
     *
     * @param sunExposure the sun exposure
     */
    public void addsunExposure(SunExposure sunExposure){
        if(validateSunExposure(sunExposure))
            sunExposureList.add(sunExposure);
    }


    /**
     * Get sun exposure list list.
     *
     * @return the list
     */
    public List<SunExposure> getSunExposureList(){
        return List.copyOf(this.sunExposureList);
    }

    /**
     * Add list.
     *
     * @param sunExposure the sun exposure
     * @return the list
     */
    public List<SunExposure> add(SunExposure sunExposure) {

        sunExposureList.add(sunExposure);

        Optional<SunExposure> newSunExposure = Optional.empty();
        boolean operationSuccess = false;

        if (validateSunExposure(sunExposure)) {
            newSunExposure = Optional.of((SunExposure) sunExposure.clone());
            operationSuccess = sunExposureList.add((SunExposure) newSunExposure.get());
        }

        if (!operationSuccess) {
            newSunExposure = Optional.empty();
        }
        return sunExposureList;
    }

    private boolean validateSunExposure(SunExposure sunExposure) {
        boolean isValid = !sunExposureList.contains(sunExposure);
        return isValid;
    }
}
