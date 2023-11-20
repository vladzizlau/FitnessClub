package service;

import by.pvt.core.domain.Client;
import by.pvt.core.service.ClientService;
import by.pvt.core.service.VisitService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VisitServiseTest {

    @InjectMocks
    VisitService visitService;

    @InjectMocks
    ClientService clientService;

    public void addVisit(){
    when(clientService.getById(1L)).thenReturn(Optional.of(client()));
    }


    private Client client(){
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Vasya");
        client.setSurName("Popov");
        client.setStatus("Good");
        return client;
    }


}
