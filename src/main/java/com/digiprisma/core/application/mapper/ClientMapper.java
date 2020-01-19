package com.digiprisma.core.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import com.digiprisma.api.dto.ClientDto;
import com.digiprisma.core.domain.Client;
import com.digiprisma.persistence.model.ClientDpo;

/**
 * 
 * @author SKAN
 *
 */
@Mapper(componentModel = "spring")
public interface ClientMapper {

   ClientDto toTransferObject(Client source);

   List<ClientDto> toTransferObject(List<Client> source);
   
   Client toDomaineObject(ClientDpo source);

   List<Client> toDomaineObject(List<ClientDpo> source);
   
   Client toDomaineObjectFromDto(ClientDto source);

   List<Client> toDomaineObjectFromDto(List<ClientDto> source);
   
   ClientDpo toDpoObject(Client source);

   List<ClientDpo> toDpoObject(List<Client> source);
   
   
}
