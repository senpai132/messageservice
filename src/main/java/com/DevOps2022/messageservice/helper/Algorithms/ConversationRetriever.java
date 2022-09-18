package com.DevOps2022.messageservice.helper.Algorithms;

import java.util.ArrayList;
import java.util.List;

import com.DevOps2022.messageservice.model.Message;

public class ConversationRetriever {
    public static List<Message> getConversation(List<Message> sendersMessages, List<Message> receiversMessages) {
        List<Message> conversation = new ArrayList<Message>();

        int i = 0, j = 0;

        while(i < sendersMessages.size() || j < receiversMessages.size()) {

            if(i >= sendersMessages.size()) {
                conversation.add(receiversMessages.get(j));
                j += 1;
                continue;
            }

            if(j >= receiversMessages.size()) {
                conversation.add(sendersMessages.get(i));
                i += 1;
                continue;
            }

            if(sendersMessages.get(i).getTimeSent().compareTo(receiversMessages.get(j).getTimeSent()) > 0) {
                conversation.add(sendersMessages.get(i));
                i += 1;
            }
            else {
                conversation.add(receiversMessages.get(j));
                j += 1;
            }
        }

        return conversation;
    }
}
