package com.example.rickandmortyapi.service.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;
import com.example.rickandmortyapi.controller.RickandMortyApi;
import com.example.rickandmortyapi.service.RickandMortyapiService;
import com.google.gson.Gson;

@Service
public class RickandMortyapiServiceImpl implements RickandMortyapiService{
    
    @Override
    public RickandMortyApi consultarRickandMortyApi(String id) throws IOException{
        // TODO Auto-generated method stub
        //por qué el SPEC? en el proyecto Weather no lo usamos...???
        URL url = new URL("http://rickandmortyapi.com/api/character/"+id);
        //URL url = new URL("https://raw.githubusercontent.com/ingridmarcela/rickandmortyapi/main/rickandmortyapi.json"); //se usa cuando se quema el Json en github
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Gson g = new Gson(); //esta librería json nos transforma el Json a la clasePokeapi
            RickandMortyApi rickanmortyapi = g.fromJson(response.toString(),RickandMortyApi.class); //declaro la variable pokeapi de tipo objeto PokeApi
            return rickanmortyapi; //retorno la variable pokeapi con el contenido del Json en un objeto PokeAPi
   //     */return null;
        }
        return null;
    }
}
