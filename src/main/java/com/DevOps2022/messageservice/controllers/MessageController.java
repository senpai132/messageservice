package com.DevOps2022.messageservice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DevOps2022.messageservice.helper.dto.MessageDTO;
import com.DevOps2022.messageservice.helper.mappers.MessageMapper;
import com.DevOps2022.messageservice.services.MessageService;

@RestController
@CrossOrigin
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    private MessageService messageService;

    private MessageMapper messageMapper;

    private static Logger logger;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO dto) {
        logger.info("[MessageService] Sending message from {} to {}", dto.getSender(), dto.getReceiver());
        return new ResponseEntity<>(messageService.sendMessage(messageMapper.toEntity(dto)), HttpStatus.OK);
    }

    @GetMapping("/getbysender/{username}")
    public ResponseEntity<List<MessageDTO>> getMsgsBySender(@PathVariable String username) {
        String logMessage = "[MessageService] Returning messages by sender: " + username;
        logger.info(logMessage);
        return new ResponseEntity<>(messageMapper.toDtoList(messageService.getMessagesBySender(username)), HttpStatus.OK);
    }

    @GetMapping("/getbyreceiver/{username}")
    public ResponseEntity<List<MessageDTO>> getMsgsByReceiver(@PathVariable String username) {
        logger.info("[MessageService] Returning messages by receiver: " + username);
        return new ResponseEntity<>(messageMapper.toDtoList(messageService.getMessagesByReceiver(username)), HttpStatus.OK);
    }

    @PutMapping("/readmsg/{id}")
    public ResponseEntity<String> readMsg(@PathVariable String id) {
        logger.info("[MessageService] Read message with id: " + id);
        return new ResponseEntity<>(messageService.readMessage(id), HttpStatus.OK);
    }

    @GetMapping("/getunreadmsgs/{username}")
    public ResponseEntity<List<MessageDTO>> getUnreadMsgs(@PathVariable String username) { 
        logger.info("[MessageService] Returning unread messages for user: " + username);
        return new ResponseEntity<>(messageMapper.toDtoList(messageService.getAllUnreadUsersMessages(username)), HttpStatus.OK);
    }

    @GetMapping("/getconversation/{participantone}/{participanttwo}")
    public ResponseEntity<List<MessageDTO>> getConversation(@PathVariable String participantone, @PathVariable String participanttwo) { 
        logger.info("[MessageService] Returning conversation between" + participantone + " and " + participanttwo);
        return new ResponseEntity<>(messageMapper.toDtoList(messageService.getConversation(participantone, participanttwo)), HttpStatus.OK);
    }

    public MessageController() {
        this.messageMapper = new MessageMapper();
        logger = LoggerFactory.getLogger(MessageController.class);
    }
    
}
