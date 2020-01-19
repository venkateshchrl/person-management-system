package com.demo.pms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {
    @JsonProperty("firstName")
    private String firstName = null;

    @JsonProperty("lastName")
    private String lastName = null;

    @JsonProperty("age")
    private Integer age = null;

    @JsonProperty("gender")
    private String gender = null;

    @JsonProperty("favouriteColor")
    private String favouriteColor = null;

    @JsonProperty("hobbies")
    private List<String> hobbies = null;
}
