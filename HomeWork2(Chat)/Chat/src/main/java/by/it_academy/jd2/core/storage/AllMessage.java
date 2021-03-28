package by.it_academy.jd2.core.storage;

import by.it_academy.jd2.core.view.Message;
import java.util.ArrayList;
import java.util.List;

/**
 * AllMessage clacc contains List<Message> AllMessage
 * List<Message> AllMessage contains all message chat
 */
public class AllMessage {
    private static List<Message> AllMessage;

    private AllMessage() {
    }

    /**
     * Method getMessage()
     * @return AllMessage
     */
    public static List<Message> getAllMessage() {
        if (AllMessage == null) {
            synchronized (AllMessage.class) {
                if (AllMessage == null) {
                    AllMessage = new ArrayList<Message>();
                }

            }
        }
        return AllMessage;
    }
}

