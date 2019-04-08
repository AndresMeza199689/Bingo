/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;


public class Carton {
    private ArrayList<Integer> numeros;
    static final int tamaño= 9;

    public Carton(ArrayList<Integer> numeros) {
        this.numeros=numeros;
    }

    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    public static int getTamaño() {
        return tamaño;
    }
    
    
}
