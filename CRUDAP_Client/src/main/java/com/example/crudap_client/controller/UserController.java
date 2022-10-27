package com.example.crudap_client.controller;

import com.example.crudap_client.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@CrossOrigin(origins = "+", maxAge = 3600)
@Controller
public class UserController {

    private final String REST_API_LIST = "http://localhost:8080/user";
    private final String REST_API_CREATE = "http://localhost:8080/user";
    private final String REST_API_DELETE = "http://localhost:8080/deleteuser/";
    private final String REST_API_UPDATE = "http://localhost:8080/user";

    private static Client createJerseyRestClient() {
        ClientConfig clientConfig = new ClientConfig();

        // Config logging for client side
        clientConfig.register( //
                new LoggingFeature( //
                        Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), //
                        Level.INFO, //
                        LoggingFeature.Verbosity.PAYLOAD_ANY, //
                        10000));

        return ClientBuilder.newClient(clientConfig);
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        Client client = createJerseyRestClient();
        WebTarget target = client.target(REST_API_LIST);
        List<User> ls =  target.request(MediaType.APPLICATION_JSON_TYPE).get(List.class);
        System.out.println("Lis Size: " + ls.size());
        model.addAttribute("lsUser", ls);

        return "index";
    }

    @GetMapping(value = "createnewuser")
    public String createNewUser() {
        return "createnewuser";
    }



    User u = new User();

}
