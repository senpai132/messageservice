package com.DevOps2022.messageservice.helper.mappers;

import java.util.ArrayList;
import java.util.List;

import com.DevOps2022.messageservice.helper.dto.MessageDTO;
import com.DevOps2022.messageservice.model.Message;

public class MessageMapper implements MapperInterface<Message, MessageDTO>{

    @Override
    public Message toEntity(MessageDTO dto) {
        Message message = new Message();
        message.setContent(dto.getContent());
        message.setReceiver(dto.getReceiver());
        message.setSender(dto.getSender());
        //message.setId(dto.getId());
        return message;
    }

    @Override
    public List<Message> toEntityList(List<MessageDTO> dtoList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MessageDTO toDto(Message entity) {
        MessageDTO dto = new MessageDTO();
        dto.setId(entity.getId());
        dto.setContent(entity.getContent());
        dto.setIsRead(entity.getIsRead());
        dto.setReceiver(entity.getReceiver());
        dto.setSender(entity.getSender());
        dto.setTimeSent(entity.getTimeSent());
        return dto;
    }

    @Override
    public List<MessageDTO> toDtoList(List<Message> entityList) {
        List<MessageDTO> dtoList = new ArrayList<MessageDTO>();

        for(Message dto : entityList) {
            dtoList.add(toDto(dto));
        }
        return dtoList;
    }
    
}
