package com.cassiano.step;

import com.cassiano.services.ConfigLoaderService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Reader implements ItemReader<String> {

    @Autowired
    private ConfigLoaderService configLoaderService;

    private int count = 0;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        loadAnomalyConfig();

        return null;
    }

    public void loadAnomalyConfig() {
       // configLoaderService.loadConfigFileToRepo();
    }

}
