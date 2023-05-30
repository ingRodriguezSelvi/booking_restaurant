package com.pavlova.pavlova.modules.user.services;

import com.pavlova.pavlova.modules.user.models.Client;
import com.pavlova.pavlova.modules.user.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void createClient(Client client){
        try {
            clientRepository.save(client);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public void updateClient(Client client, Long id) {
        Optional<Client> clientDB = clientRepository.findById(id);
        if (clientDB.isEmpty() && Objects.equals(client.getId(), id)){
            throw new RuntimeException("El cliente no existe");
        }
        if (clientDB.get().isStatus() != client.isStatus()){
            throw new RuntimeException("Esta intentando eliminar o activar un cliente, accion no permitida");
        }
        clientRepository.save(client);
    }
}
