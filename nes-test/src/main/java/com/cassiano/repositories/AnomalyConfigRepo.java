package com.cassiano.repositories;

import com.cassiano.model.AnomalyConfig;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class AnomalyConfigRepo {
    private final List<AnomalyConfig> anomalyConfigList = new ArrayList<>();

    public void addAnomaly(AnomalyConfig anomalyConfig){
        this.anomalyConfigList.add(anomalyConfig);
    }

    public List<AnomalyConfig> getAnomalyConfigList(){
        return Collections.unmodifiableList(this.anomalyConfigList);
    }
}
