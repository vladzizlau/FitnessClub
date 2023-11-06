package by.pvt.core.controller;

import by.pvt.core.dto.ClientResponse;
import by.pvt.core.mapper.ClientMap;
import by.pvt.core.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientRestContoller {

@Autowired
    private ClientService clientService;
    @Autowired
    private ClientMap clientMap;

    @GetMapping("/getallclient")
    public List<ClientResponse> getAll(){
        return clientService.getAllResponse();
    }


}
