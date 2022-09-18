package com.DevOps2022.messageservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.DevOps2022.messageservice.model.Message;

public interface MessageRepository extends MongoRepository<Message, String>{
    List<Message> findBySenderAndReceiverOrderByTimeSentDesc(String sender, String receiver);
    List<Message> findBySenderOrderByTimeSentDesc(String sender);
    List<Message> findByReceiverOrderByTimeSentDesc(String receiver);
    List<Message> findByReceiverAndIsReadOrderByTimeSentDesc(String receiver, int isRead);
    Optional<Message> findById(String id);
}
