package com.example.rickandmortyapi.service;
import java.io.IOException;
import com.example.rickandmortyapi.controller.RickandMortyApi;


public interface RickandMortyapiService {
    //RickandMortyApi consultarRickandMortyApi() throws IOException;
    RickandMortyApi consultarRickandMortyApi(String id) throws IOException;
        
}
