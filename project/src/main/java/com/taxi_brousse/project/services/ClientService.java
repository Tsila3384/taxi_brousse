package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Client;
import com.taxi_brousse.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Integer id) {
        return clientRepository.findById(id);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Integer id, Client client) {
        if (clientRepository.existsById(id)) {
            client.setIdClient(id);
            return clientRepository.save(client);
        }
        return null;
    }

    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }
}
