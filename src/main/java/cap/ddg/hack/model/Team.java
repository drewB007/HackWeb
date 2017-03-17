package cap.ddg.hack.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by andrew on 2/23/17.
 */
public class Team {
    private String team;

    private Map<String, Vote> votes = new HashMap<String, Vote>(5);

    private int total;

    private List<Message> messageList = new ArrayList<>(5);



    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Message> getMessages() {
        int numOfMsgs = messageList.size();
        int limit = 10;
        List<Message> latest = null;

        //System.out.println("numOfMsg: " + numOfMsgs);
        //System.out.println("limit: " + limit);

        if(numOfMsgs < limit){
            latest = messageList;
            //System.out.println("just giving you them all!");
        }
        else{
            int start = numOfMsgs - limit - 1;
            int end = numOfMsgs - 1;
            //System.out.println("start: " + start);
            //System.out.println("end: " + end);

            latest = messageList.subList(start, end);

        }

        return latest;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public void addMessage(Message msg){
        messageList.add(msg);
    }

    public void addVote(Vote vote){
        if(votes.containsKey(vote.getFromTeam()))
        {
            total = total - (votes.get(vote.getFromTeam())).getValue();
            votes.replace(vote.getFromTeam(), vote);
        }
        else{
            votes.putIfAbsent(vote.getFromTeam(), vote);
        }

        total = total + vote.getValue();

    }

    public Vote getVote(String teamName){
        if(votes.containsKey(teamName))
        {
            return votes.get(teamName);
        }
        else
        {
            return new Vote();
        }
    }

    public Map<String, Vote> getVotes() {
        return votes;
    }

    public List<Vote> getVoteList() {
        List<Vote> list = votes.entrySet().stream()
                .map(x -> x.getValue())
                .collect(Collectors.toList());
        return list;
    }

    public void setVotes(Map<String, Vote> votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return String.format(
                "Team[team=%s, total=%s]",
                this.team,
                this.total
        );
    }
}
