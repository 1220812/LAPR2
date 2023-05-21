package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.SunExposure;

import java.util.ArrayList;
import java.util.List;

public class SunExposureRepository {
    private List<SunExposure> sunExposureList = new ArrayList<>();

    public void addsunExposure(SunExposure sunExposure){
        if(validateSunExposure(sunExposure))
            sunExposureList.add(sunExposure);
    }

    public boolean validateSunExposure(SunExposure sunExposure) {
        return !this.sunExposureList.contains(sunExposure);
    }

    public List<SunExposure> getSunExposureList(){
        return List.copyOf(this.sunExposureList);
    }
}
