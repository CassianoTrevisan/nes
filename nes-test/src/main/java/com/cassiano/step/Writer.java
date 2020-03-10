package com.cassiano.step;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Writer implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> messages) throws Exception {
        System.out.println(messages.toString());
       // for (String msg : messages) {
            System.out.println("Writing the data " + messages.get(0));
        //}
    }
}
