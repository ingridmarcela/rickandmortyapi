package com.example.rickandmortyapi.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.rickandmortyapi.service.RickandMortyapiService;

@RestController
@RequestMapping( "/rickandmortyapi" ) //como lo vamos a consumir desde postman

public class RickandMortyApiController {
    private final RickandMortyapiService rickandMortyapiService;

    public RickandMortyApiController( @Autowired RickandMortyapiService rickandMortyapiService){

        this.rickandMortyapiService = rickandMortyapiService;
    }
    @GetMapping("/{id}")
    //@GetMapping
    public ResponseEntity<?> mostrarRickandMorty(@PathVariable String id){
        try {
            return ResponseEntity.ok(rickandMortyapiService.consultarRickandMortyApi(id)); //returna la interface del service
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return null;
   }
}
