package com.cassiano.step;

import com.cassiano.services.SomeService;
import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String> {

    private SomeService someService;

    public Processor(SomeService someService){
        this.someService = someService;
    }

    @Override
    public String process(String data) throws Exception {
        someService.parse();
        return data.toUpperCase();
    }
}
