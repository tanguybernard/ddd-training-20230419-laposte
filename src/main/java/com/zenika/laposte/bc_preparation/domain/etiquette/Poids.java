package com.zenika.laposte.bc_preparation.domain.etiquette;

import com.zenika.laposte.bc_preparation.domain.etiquette.exceptions.PoidsException;

public class Poids {

    public final String unite;
    public final int valeur;

    public Poids(int valeur, String unite) throws PoidsException {

        if(valeur < 20){
            throw new PoidsException();
        }


    this.valeur=valeur ;
    this.unite=unite ;
    }
}
