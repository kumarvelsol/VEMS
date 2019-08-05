package igrand.com.vems.samplemodelclasses;

import java.io.Serializable;

import lombok.Data;

@Data
public class MessageModel implements Serializable
{
    public String messageDate;
    public String messageTime;
    public String messageName;
    public String messageClass;
    public String messageContent;

    public MessageModel(String messageDate, String messageTime, String messageName, String messageClass, String messageContent) {
        this.messageDate = messageDate;
        this.messageTime = messageTime;
        this.messageName = messageName;
        this.messageClass = messageClass;
        this.messageContent = messageContent;
    }
}
