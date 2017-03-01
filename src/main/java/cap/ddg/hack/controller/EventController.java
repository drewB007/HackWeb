package cap.ddg.hack.controller;

import cap.ddg.hack.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.List;

@Controller
@PropertySource("classpath:application.properties")
public class EventController {

    @Value("${team.name}")
    private String thisTeam;

    @Value("${api.host}")
    private String apiHost;

    @Value("${api.port}")
    private String apiPort;



    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String initHome(Model model) {
        String teamName = thisTeam;
        String apiURI = "http://"+apiHost + ":" + apiPort + "/api";

        model.addAttribute("teamName", teamName);

        String uri = apiURI+"/team/" + thisTeam;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Team> resp = restTemplate.getForEntity(uri, Team.class);
        Team team = resp.getBody();

        model.addAttribute("votes", team.getVoteList());
        model.addAttribute("totalScore", team.getTotal());
        model.addAttribute("messages", team.getMessages());
        return "index";
    }

    @RequestMapping(value = "/vote", method = RequestMethod.GET)
    public String getVote(Model model, Principal principal) {
        String apiURI = "http://"+apiHost + ":" + apiPort + "/api";
        String uri = apiURI+"/team/" + thisTeam + "/vote/" +principal.getName();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Vote> vote = restTemplate.getForEntity(uri, Vote.class);

        model.addAttribute(vote);
        return "vote";
    }


    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public String addVote(@Valid Vote vote, BindingResult result, SessionStatus status,
                             RedirectAttributes attributes, Principal principal) {
        if (result.hasErrors()) {
            return "vote";
        } else {
            if(principal.getName().equalsIgnoreCase(thisTeam) ){
                String apiURI = "http://" + apiHost + ":" + apiPort + "/api";
                String msgUri = apiURI + "/team/message/" + thisTeam;
                Message msg = new Message();
                msg.setSender("Admins");
                msg.setType("INFO");
                msg.setText("Nice try but you can't vote for yourself!");

                System.out.println("Sending message: " + msg + " to: " + msgUri);

                RestTemplate restTemplate = new RestTemplate();

                ResponseEntity<Message> st1 = null;
                try {
                    st1 = restTemplate.postForEntity(msgUri, msg, Message.class);
                }
                catch(Exception ex)
                    {
                        System.out.println("ex:" + ex.getMessage());
//                        System.out.println("code:" + st1.getStatusCode());
//                        System.out.println("str:" + st1.toString());
//                        System.out.println("body:" + st1.getBody());
                    }
            }
            else {
                System.out.println(principal.getName() + " called POST: /vote with value: " + vote.getValue());
                status.setComplete();
                vote.setFromTeam(principal.getName());
                String apiURI = "http://" + apiHost + ":" + apiPort + "/api";

                String uri = apiURI + "/team/" + thisTeam + "/vote/" + principal.getName();
                RestTemplate restTemplate = new RestTemplate();

                ResponseEntity<Vote> st = restTemplate.postForEntity(uri, vote, Vote.class);
            }

            return "redirect:/home";
//            return "redhome";
        }
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public String getEvent(Model model) {

        String apiURI = "http://"+apiHost + ":" + apiPort + "/api";

        String uri = apiURI + "/event/generate";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Event> event = restTemplate.getForEntity(uri, Event.class);

        return "redirect:/home";
    }




}
