package com.demo.pms;

import com.demo.pms.api.impl.PersonsApiServiceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {
    public AppConfig(){
        register(PersonsApiServiceImpl.class);
    }
}
