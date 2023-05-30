package com.pavlova.pavlova.modules.user.controllers;

import com.pavlova.pavlova.modules.user.models.Client;
import com.pavlova.pavlova.modules.user.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<?> createClient(@RequestBody Client client) {
       try {
           clientService.createClient(client);
           return ResponseEntity.ok("Client created");
         }catch (Exception e){
              return ResponseEntity.badRequest().body("Client not created");
       }
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<?> getClient() {
       try {
           return ResponseEntity.ok(clientService.getAllClients());
         }catch (Exception e){
              return ResponseEntity.badRequest().body("Client not created");
       }
    }

    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClient(@RequestParam Long id) {
       try {
              clientService.delete(id);
           return ResponseEntity.status(204).body("Deleted");
         }catch (Exception e){
              return ResponseEntity.badRequest().body("Client not created");
       }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clientService.getClientById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Client not created");
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody Client client) {
        try {
            clientService.updateClient(client,id);
            return ResponseEntity.ok("Client updated");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Client not created");
        }
    }
}
