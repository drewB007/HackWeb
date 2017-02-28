package cap.ddg.hack.controller;

import cap.ddg.hack.RESTServer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.security.Principal;
import org.springframework.web.client.RestTemplate;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

import cap.ddg.hack.model.*;

@PropertySource("classpath:application.properties")
@Controller

public class LoginController {

    //RESTServer mRESTServer = context.getBean(RESTServer.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Authentication authentication) {
        System.out.println("hello from GET: /login");
       return "login";
    }


//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String applogin(Authentication authentication) throws URISyntaxException {
//
//        final String uri = "http://localhost:8888/api/event";
////        RestTemplate restTemplate = new RestTemplate();
////
////        EventDTO newEvent = new EventDTO();
////        newEvent.setTeam("authentication.getName()");
////        newEvent.setEndpoint("/login");
//
//        //ResponseEntity<String> st = restTemplate.postForEntity(uri, newEvent, String.class);
//        //System.out.println("[" + st.getBody() + "]");
//        System.out.println("hello from POST: /applogin");
//        System.out.println("user logged in: " + authentication.getName());
//        return "home";
//    }



}
