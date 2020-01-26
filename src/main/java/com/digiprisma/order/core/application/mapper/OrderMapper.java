package com.digiprisma.order.core.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.digiprisma.order.api.dto.OrderDto;
import com.digiprisma.order.core.domain.Order;
import com.digiprisma.order.persistence.model.OrderDpo;

/**
 * 
 * @author SKAN
 *
 */
@Mapper(componentModel = "spring")
public interface OrderMapper {

   OrderDto toTransferObject(Order source);

   List<OrderDto> toTransferObject(List<Order> source);
   
   Order toDomaineObject(OrderDpo source);

   List<Order> toDomaineObject(List<OrderDpo> source);
   
   Order toDomaineObjectFromDto(OrderDto source);

   List<Order> toDomaineObjectFromDto(List<OrderDto> source);
   
   OrderDpo toDpoObject(Order source);

   List<OrderDpo> toDpoObject(List<Order> source);
   
   
}
