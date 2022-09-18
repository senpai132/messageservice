package com.DevOps2022.messageservice.helper.mappers;

import java.util.List;

public interface MapperInterface<T, U>{
    T toEntity(U dto);

    List<T> toEntityList(List<U> dtoList);

    U toDto(T entity);

    List<U> toDtoList(List<T> entityList);
}
