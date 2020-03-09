package com.cassiano.helper;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Properties {

    @Value("${files.directory}")
    private String filePath;
}
