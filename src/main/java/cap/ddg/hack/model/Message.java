package cap.ddg.hack.model;

import java.util.Date;

/**
 * Created by andrew on 2/24/17.
 */
public class Message {

    private String type;
    private Date created = new Date();
    private String sender;
    private String text;
    private String formattedText;


    private void formatText(){
        formattedText = type + " from: " + sender + " - " + text;
    }

    public String getFormattedText() {
        formatText();
        return formattedText;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format(
                "Message[type=%s, created=%s, sender=%s, text=%s]",
                this.type,
                this.created,
                this.sender,
                this.text
        );
    }
}
