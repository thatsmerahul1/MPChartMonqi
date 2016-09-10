package forMonqi;

/**
 * Created by 20113966 on 10-09-2016.
 */
public class DemoPojo {


    private String messageType;
    private String kidNumber;
    private String parentNumber;
    private Boolean onParentDemand;
    private Message message;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getKidNumber() {
        return kidNumber;
    }

    public void setKidNumber(String kidNumber) {
        this.kidNumber = kidNumber;
    }
    public String getParentNumber() {
        return parentNumber;
    }

    public void setParentNumber(String parentNumber) {
        this.parentNumber = parentNumber;
    }

    public Boolean getOnParentDemand() {
        return onParentDemand;
    }

    public void setOnParentDemand(Boolean onParentDemand) {
        this.onParentDemand = onParentDemand;
    }
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
