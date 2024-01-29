package com.shop.core.controllers;

import com.shop.core.models.Client;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClientRestController {
    private List<Client> clients = new ArrayList<>(Arrays.asList(
            new Client("pecortes","pedro","12345678"),
            new Client("sebaor","sebas","12345678"),
            new Client("wendylo","wendy","12345678")
    ));

    @GetMapping("/clients")
    public List<Client> getClients() {
        return clients;
    }

    @GetMapping("/clients/{username}")
    public Client getClientByUsername(@PathVariable String username) {
        return clients.stream().filter(client -> client.getUsername().equalsIgnoreCase(username)).findFirst().orElseThrow();
    }

    @PostMapping("/clients")
    public Client createCliente(@RequestBody Client client) {
        clients.add(client);
        return client;
    }

    @PutMapping("/clients")
    public Client updateCliente(@RequestBody Client client) {
        Client clientToUpdate = clients
                                    .stream()
                                    .filter(clientDB->clientDB.getUsername().equalsIgnoreCase(client.getUsername()))
                                    .findFirst()
                                    .orElseThrow();

        clientToUpdate.setPassword(client.getPassword());
        clientToUpdate.setName(client.getName());
        return clientToUpdate;
    }

    @DeleteMapping("/clients/{username}")
    public void deleteCliente(@PathVariable String username) {
        Client clientToDelete = clients
                                    .stream()
                                    .filter(clientDB -> clientDB.getUsername().equalsIgnoreCase(username)).findFirst()
                                    .orElseThrow();
        clients.remove(clientToDelete);
    }
}
