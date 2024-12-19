package com.felipevilla.TPIntegradorFinal.service;

import com.felipevilla.TPIntegradorFinal.model.Client;
import com.felipevilla.TPIntegradorFinal.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService{


    @Autowired
    ClientRepository clientRepository;


    //Method to create a new sale.
    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }

    //Method to read all clients.
    @Override
    public List<Client> readAllClient() {
        return clientRepository.findAll();
    }

    //Method to read a particular client.
    @Override
    public Client readClient(Long idClient) {
        Client client = clientRepository.findById(idClient).orElse(null);
        return client;
    }

    //Method to delete a client.
    @Override
    public void deleteClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }

    //Method to update a client.
    @Override
    public Client updateClient(Long idClient, Client client) {

            Client client1 = clientRepository.findById(idClient)
                    .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

            if (client.getIdClient() != null) {
                client1.setIdClient(client.getIdClient());
            }
            if (client.getName() != null && !client.getName().isEmpty()) {
                client1.setName(client.getName());
            }
            if (client.getLastName() != null && !client.getLastName().isEmpty()) {
                client1.setLastName(client.getLastName());
            }
            if (client.getDni() != null && !client.getDni().isEmpty()) {
                client1.setDni(client.getDni());
            }

            return clientRepository.save(client1);

    }

}
