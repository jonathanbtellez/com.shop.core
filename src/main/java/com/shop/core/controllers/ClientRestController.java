package com.shop.core.controllers;

import com.shop.core.exceptions.BadRequestException;
import com.shop.core.exceptions.ResourceNotFoundException;
import com.shop.core.models.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientRestController {
    private List<Client> clients = new ArrayList<>(Arrays.asList(
            new Client("pecortes","pedro","12345678"),
            new Client("sebaor","sebas","12345678"),
            new Client("wendylo","wendy","12345678")
    ));

    @GetMapping
    public ResponseEntity<?> getClients() {
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getClientByUsername(@PathVariable String username) {

        if(username.length() < 3){
            throw new BadRequestException("The username parameter must be at least 3 characters.");
        }
        return clients.stream()
                .filter(client-> client.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new ResourceNotFoundException("Client " + username + " not found"));
    }

    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody Client client) {

        //send the url of endpoint
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{username}")
                        .buildAndExpand(client.getUsername())
                        .toUri();

        clients.add(client);
        return ResponseEntity.created(location).body(client);
    }

    @PutMapping
    public ResponseEntity<?> updateCliente(@RequestBody Client client) {
        Client clientToUpdate = clients
                                    .stream()
                                    .filter(clientDB->clientDB.getUsername().equalsIgnoreCase(client.getUsername()))
                                    .findFirst()
                                    .orElseThrow();

        clientToUpdate.setPassword(client.getPassword());
        clientToUpdate.setName(client.getName());

        return ResponseEntity.ok(clientToUpdate);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteCliente(@PathVariable String username) {
        Client clientToDelete = clients
                                    .stream()
                                    .filter(clientDB -> clientDB.getUsername().equalsIgnoreCase(username)).findFirst()
                                    .orElseThrow();

        clients.remove(clientToDelete);

        return ResponseEntity.noContent().build();
    }

    // services implementation
}
