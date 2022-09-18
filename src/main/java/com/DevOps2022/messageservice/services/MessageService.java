package com.DevOps2022.messageservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevOps2022.messageservice.helper.Algorithms.ConversationRetriever;
import com.DevOps2022.messageservice.model.Message;
import com.DevOps2022.messageservice.repositories.MessageRepository;


@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public String sendMessage(Message message) {
        
        messageRepository.save(message);
        
        return "Message to " + message.getReceiver() + " successfully sent";
    }

    public List<Message> getMessagesByReceiver(String receiver) {
        return messageRepository.findByReceiverOrderByTimeSentDesc(receiver);
    }

    public List<Message> getMessagesBySender(String sender) {
        return messageRepository.findBySenderOrderByTimeSentDesc(sender);
    }

    public String readMessage(String id) {
        Optional<Message> message = messageRepository.findById(id);

        message.get().setIsRead(1);

        messageRepository.save(message.get());

        return "Message successfully read";
    }

    public List<Message> getAllUnreadUsersMessages(String receiver) {
        return messageRepository.findByReceiverAndIsReadOrderByTimeSentDesc(receiver, 0);
    }

    public List<Message> getConversation(String participant_one, String participant_two) {
        List<Message> sendersMessages = messageRepository.findBySenderAndReceiverOrderByTimeSentDesc(participant_one, participant_two);
        List<Message> receiversMessages = messageRepository.findBySenderAndReceiverOrderByTimeSentDesc(participant_two, participant_one);

        return ConversationRetriever.getConversation(sendersMessages, receiversMessages);
    }
}
