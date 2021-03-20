package com.example.mastertrainerapp.Model;

import java.util.List;

public class Pokedex {
    private List<Pokemon> pokemonList;

    private Pokedex(){
    }

    private Pokedex(List<Pokemon> pokemon){
        this.pokemonList = pokemon;
    }

    public List<Pokemon> getPokedex(){
        return this.pokemonList;
    }

    public void setPokemon (List<Pokemon> pokemon){
        this.pokemonList = pokemon;
    }
}
