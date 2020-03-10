package com.cassiano.step;

import com.cassiano.model.AnomalyConfig;
import com.cassiano.services.ConfigLoaderService;
import com.cassiano.services.SomeService;
import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String> {

    private SomeService someService;
    private ConfigLoaderService configLoaderService;

    public Processor(SomeService someService, ConfigLoaderService configLoaderService){
        this.someService = someService;
        this.configLoaderService = configLoaderService;
    }

    @Override
    public String process(String data) throws Exception {

        System.out.println("test");

        for(AnomalyConfig anomalyConfig : configLoaderService.getAnomalyConfigRepo().getAnomalyConfigList()){
            System.out.println(anomalyConfig);
        }
        //someService.parse();
        return data.toUpperCase();
    }
}
