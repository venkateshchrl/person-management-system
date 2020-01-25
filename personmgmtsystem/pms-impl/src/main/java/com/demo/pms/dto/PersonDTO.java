package com.demo.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private String firstName = null;

    private String lastName = null;

    private Integer age = null;

    private String gender = null;

    private String favouriteColor = null;

    private List<String> hobbies = null;
}
