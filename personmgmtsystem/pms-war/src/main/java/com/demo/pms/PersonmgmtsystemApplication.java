package com.demo.pms;

import com.demo.pms.dto.PersonDTO;
import com.demo.pms.person.controllers.PersonCreateController;
import com.demo.pms.person.service.PersonCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class PersonmgmtsystemApplication extends SpringBootServletInitializer {

	@Autowired
	PersonCreateController personCreateController;

	@PostConstruct
	private void initDB(){
		List<PersonDTO> personDTOS = Arrays.asList(new PersonDTO[]{new PersonDTO("Venkatesh", "M", 26, "Male", "Green", Arrays.asList(new String[]{"Watching Movies"}))});
		for(PersonDTO personDTO: personDTOS){
			personCreateController.createPerson(personDTO);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(PersonmgmtsystemApplication.class, args);
	}

}
