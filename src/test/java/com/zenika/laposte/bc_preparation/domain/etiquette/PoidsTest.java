package com.zenika.laposte.bc_preparation.domain.etiquette;

import com.zenika.laposte.bc_preparation.domain.etiquette.exceptions.PoidsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;


public class PoidsTest {


    @Test
    void createNonConformePoidsShouldThrowAnException(){
        //GIVEN
        int valeur = 15 ;
        String unite = "g" ;
        //WHEN
        // THEN
        assertThrowsExactly(PoidsException.class , () -> new Poids(valeur , unite) );
    }

    @Test
    void createConformePoids(){
        //GIVEN
        int valeur = 25 ;
        String unite = "g" ;
        //WHEN
        Poids poids = new Poids(valeur, unite);
        // THEN
        assertEquals(25 , poids.valeur);
    }
}
