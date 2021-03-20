package com.example.mastertrainerapp.Retrofit;

import com.example.mastertrainerapp.Model.Pokedex;

import io.reactivex.Observable;

import retrofit2.http.GET;

public interface IPokemonDex {
    @GET("pokedex.json")
    Observable<Pokedex> getListPokemon();
}
