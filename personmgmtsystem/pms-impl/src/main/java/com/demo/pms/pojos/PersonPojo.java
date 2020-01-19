package com.demo.pms.pojos;

import com.demo.pms.dto.PersonDTO;
import lombok.Data;

import java.util.Date;

@Data
public class PersonPojo extends PersonDTO {
    private String id;
    private Date createdOn;
    private Date modifiedOn;
    private Date createdBy;
    private Date modifiedBy;
}
