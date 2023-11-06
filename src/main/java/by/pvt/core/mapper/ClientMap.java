package by.pvt.core.mapper;


import by.pvt.core.domain.Client;
import by.pvt.core.dto.ClientRequest;
import by.pvt.core.dto.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMap
    {
    ClientResponse toResponse(Client client);
    Client toEntity(ClientResponse clientResponse);
}
