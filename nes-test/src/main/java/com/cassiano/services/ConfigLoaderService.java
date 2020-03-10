package com.cassiano.services;

import com.cassiano.anomalies.Anomaly;
import com.cassiano.model.AnomalyConfig;
import com.cassiano.model.Measurement;
import com.cassiano.repositories.AnomalyConfigRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class ConfigLoaderService {

    @Value("${anomaly.file.path}")
    private String configFilePath;

    @Autowired
    private AnomalyConfigRepo anomalyConfigRepo;

    public void loadConfigFileToRepo(){
        try (JsonReader jsonReader = new JsonReader(
                new InputStreamReader(
                        new FileInputStream(configFilePath), StandardCharsets.UTF_8))) {

            Gson gson = new GsonBuilder().create();

            jsonReader.beginArray(); //start of json array

            while (jsonReader.hasNext()) { //next json array element
                AnomalyConfig anomalyConfig = gson.fromJson(jsonReader, AnomalyConfig.class);

                System.out.println(anomalyConfig);

            }
            jsonReader.endArray();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
