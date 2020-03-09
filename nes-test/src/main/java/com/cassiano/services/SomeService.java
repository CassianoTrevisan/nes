package com.cassiano.services;

import com.cassiano.helper.Properties;
import com.cassiano.model.Measurement;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;


@Service
public class SomeService {

    @Value("${files.directory}")
    private String jsonFilePath;

       public void parse() {

        long start = System.currentTimeMillis();

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
            System.out.println("Total Time Taken : " + (System.currentTimeMillis() - start) / 1000 + " secs");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
