package cap.ddg.hack.model;

/**
 * Created by andrew on 2/23/17.
 */
public class Vote {
    private String fromTeam;

    private int value;

    public String getFromTeam() {
        return fromTeam;
    }

    public void setFromTeam(String fromTeam) {
        this.fromTeam = fromTeam;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = Integer.valueOf(value);
    }
}
