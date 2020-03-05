package com.cassiano.step;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class Writer implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> messages) throws Exception {
        System.out.println(messages.toString());
       // for (String msg : messages) {
            System.out.println("Writing the data " + messages.get(0));
        //}
    }
}
