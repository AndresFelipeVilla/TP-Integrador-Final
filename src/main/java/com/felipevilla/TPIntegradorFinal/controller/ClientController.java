package com.felipevilla.TPIntegradorFinal.controller;

import com.felipevilla.TPIntegradorFinal.model.Client;
import com.felipevilla.TPIntegradorFinal.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping("/clientes/crear")
    public String createClient( @RequestBody Client client){
        clientService.createClient(client);
        return "El cliente se ha creado correctamente";
    }

    @GetMapping("/clientes")
    public List<Client> readAllClients(){
       return clientService.readAllClient();
    }

    @GetMapping("/clientes/{idClient}")
    public Client readClient (@PathVariable Long idClient){
        return clientService.readClient(idClient);
    }

    @DeleteMapping("/clientes/eliminar/{idClient}")
    public String deleteClient (@PathVariable Long idClient){
        clientService.deleteClient(idClient);
        return "El cliente se elimino correctamente";
    }

    @PutMapping("/clientes/editar/{idClient}")
    public Client updateClient(@PathVariable Long idClient, @RequestBody Client client){
        return clientService.updateClient(idClient, client);
    }


}
