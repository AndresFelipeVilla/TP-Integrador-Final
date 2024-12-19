package com.felipevilla.TPIntegradorFinal.service;


import com.felipevilla.TPIntegradorFinal.model.Client;


import java.util.List;

public interface IClientService  {

    //Method to create a new Client.
    public void createClient(Client client);

    //Method to read all clients.
    public List<Client> readAllClient();

    //Method to read a particular client.
    public Client readClient(Long idClient);

    //Method to delete a client.
    public void deleteClient(Long idClient);

    //Method to update a client.
    public Client updateClient(Long idClient, Client client);

    


}
