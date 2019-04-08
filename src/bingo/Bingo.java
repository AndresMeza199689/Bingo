/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import Logica.Carton;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Bingo {
    private ArrayList<Integer> Bombo;
    private ArrayList<Integer> bolas_extraidas;
    private ArrayList<Carton> Cartones;
    private ArrayList<Carton> CartonesGanadores;
    private boolean finalizado;

    public Bingo() {
        this.bolas_extraidas=new ArrayList<>();
        this.Bombo=this.getNewListNum(30);
        this.Cartones=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.Cartones.add(this.getNewListCartones());
        }
        this.finalizado=false;
        this.run();
    }
    
    
    

    private ArrayList<Integer> getNewListNum(int max) {
        ArrayList<Integer> aux=new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            aux.add(i);
        }
        java.util.Collections.shuffle(aux);
        return aux;
    }

    private Carton getNewListCartones() {
        ArrayList<Integer> aux=this.getNewListNum(30);
        java.util.Collections.shuffle(aux);
        ArrayList<Integer>aux2=new ArrayList<>();
        for (int i = 0; i < Carton.getTamaño(); i++) {
            aux2.add(aux.get(i));
        }
        return new Carton(aux2);
    }

    private void run() {
        int bola=0;
        while(!this.finalizado){
            bola=this.extraerBola();
            System.out.println( "Bola :" +bola);
            this.mostrarCartones();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bingo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private Integer extraerBola(){
        Integer bola= this.Bombo.remove(0);
        
        if(bola==0){
            this.finalizado=true;
            System.out.println("Error");
        }else{
            this.bolas_extraidas.add(bola);
            boolean v[]={false,false,false};
            for (int i = 0; i< 3; i++) {
                v[i]=this.ComprobarCarton(i);
            }
            for (int i = 0; i <3; i++) {
                if(v[i]==true){
                    this.finalizado=true;
                    this.ImprimirGanadores(i);
                }
            }
        }
       
        return bola;
    }

    private boolean ComprobarCarton(int i) {
        boolean v=false;
        
        for (int j = 0; j < Carton.getTamaño(); j++) {
            for (int k = 0; k <  this.bolas_extraidas.size(); k++) {
                if(0==this.Cartones.get(i).getNumeros().get(j).compareTo(this.bolas_extraidas.get(k))){
                    v=true;
                }
                    
            }
            if(v)
                v=false;
            else
                return false;
        }
        return true;
        
    }

    private void ImprimirGanadores(int i) {
        System.out.println("El jugador del carton numero " +(i+1)+ " ha ganado, el carton ganador es " +this.Cartones.get(i).getNumeros().toString()+  " Bolas extraidas "  +this.bolas_extraidas.toString() );
    }

    private void mostrarCartones() {
        for (int i = 0; i < 3; i++) {
            System.out.println("el jugador del carton numero "  +(i+1)+  " "+this.Cartones.get(i).getNumeros().toString());
        }
    }
    public static void main(String[] args) {
        Bingo b=new Bingo();
    }
    
}
