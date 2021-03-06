package com.cassiano.step;

import com.cassiano.services.ConfigLoaderService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {

    private ConfigLoaderService configLoaderService;

    private int count = 0;

    public Reader(ConfigLoaderService configLoaderService) {
        this.configLoaderService = configLoaderService;
    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        loadAnomalyConfig();

        return null;
    }

    public void loadAnomalyConfig() {
        configLoaderService.loadConfigFileToRepo();
    }

}
