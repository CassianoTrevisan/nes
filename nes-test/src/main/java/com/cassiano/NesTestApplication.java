package com.cassiano;

import com.cassiano.helper.Properties;
import com.cassiano.model.Measurement;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import lombok.Getter;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Getter
@SpringBootApplication
@EnableBatchProcessing
public class NesTestApplication {


    @Autowired
    Properties pops;

    public static void main(String[] args) {
        SpringApplication.run(NesTestApplication.class, args);

        long start = System.currentTimeMillis();
        NesTestApplication jsonStreamingGsonExample = new NesTestApplication();
     //   Properties pops = new Properties();
        String jsonFilePath = jsonStreamingGsonExample.getPops().getFilePath();
        jsonStreamingGsonExample.parse(jsonFilePath);
        System.out.println("Total Time Taken : " + (System.currentTimeMillis() - start) / 1000 + " secs");
    }


    public void parse(String jsonFilePath) {

        //create JsonReader object and pass it the json file,json source or json text.
        try (JsonReader jsonReader = new JsonReader(
                new InputStreamReader(
                        new FileInputStream(jsonFilePath), StandardCharsets.UTF_8))) {

            Gson gson = new GsonBuilder().create();

            jsonReader.beginArray(); //start of json array
            int numberOfRecords = 0;
            while (jsonReader.hasNext()) { //next json array element
                Measurement document = gson.fromJson(jsonReader, Measurement.class);
                //do something real
                System.out.println(document);
                numberOfRecords++;
            }
            jsonReader.endArray();
            System.out.println("Total Records Found : " + numberOfRecords);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
