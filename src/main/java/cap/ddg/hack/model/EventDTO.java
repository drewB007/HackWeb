package cap.ddg.hack.model;

import org.springframework.beans.factory.annotation.Autowired;

//@Autowired
public class EventDTO {

    private String id;

    private String team;

    private String endpoint;

    private String dateTime;

    public EventDTO() {

    }

    public EventDTO(String team){

    }

    public String getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public String getEndpoint() { return endpoint; }

    public String getDateTime() {
        return dateTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setEndpoint(String endpoint) { this.endpoint = endpoint; }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

//    @Override
//    public String toString() {
//        return String.format(
//                "TodoDTO[id=%s, team=%s, endpoint=%s, dateTime=%s]",
//                this.id,
//                this.team,
//                this.endpoint,
//                this.dateTime
//        );
//    }
}
