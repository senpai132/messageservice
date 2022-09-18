package com.DevOps2022.messageservice.controllers;

import java.util.List;

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

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO dto) {
        
        return new ResponseEntity<>(messageService.sendMessage(messageMapper.toEntity(dto)), HttpStatus.OK);
    }

    @GetMapping("/getbysender/{username}")
    public ResponseEntity<List<MessageDTO>> getMsgsBySender(@PathVariable String username) {
        
        return new ResponseEntity<>(messageMapper.toDtoList(messageService.getMessagesBySender(username)), HttpStatus.OK);
    }

    @GetMapping("/getbyreceiver/{username}")
    public ResponseEntity<List<MessageDTO>> getMsgsByReceiver(@PathVariable String username) {
        
        return new ResponseEntity<>(messageMapper.toDtoList(messageService.getMessagesByReceiver(username)), HttpStatus.OK);
    }

    @PutMapping("/readmsg/{id}")
    public ResponseEntity<String> readMsg(@PathVariable String id) {
        return new ResponseEntity<>(messageService.readMessage(id), HttpStatus.OK);
    }

    @GetMapping("/getunreadmsgs/{username}")
    public ResponseEntity<List<MessageDTO>> getUnreadMsgs(@PathVariable String username) {
        return new ResponseEntity<>(messageMapper.toDtoList(messageService.getAllUnreadUsersMessages(username)), HttpStatus.OK);
    }

    @GetMapping("/getconversation/{participantone}/{participanttwo}")
    public ResponseEntity<List<MessageDTO>> getConversation(@PathVariable String participantone, @PathVariable String participanttwo) {
        return new ResponseEntity<>(messageMapper.toDtoList(messageService.getConversation(participantone, participanttwo)), HttpStatus.OK);
    }

    public MessageController() {
        this.messageMapper = new MessageMapper();
    }
    
}
