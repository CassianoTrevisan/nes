package com.cassiano.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Measurement {
    String parentId,deviceId;
    Double measuredValue;
    String timestamp;
}
