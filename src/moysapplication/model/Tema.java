/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication.model;

import java.util.ArrayList;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class Tema {
    private ArrayList<Integer> idTema;
    private ArrayList<String> Tema;
    
    public Tema(){
        idTema = new ArrayList<>();
        Tema = new ArrayList<>();
    }
    
    public void setTema(int id_tema, String tema){
        this.idTema.add(id_tema);
        this.Tema.add(tema);
    }
    
    public int getIdTema(int index){
        return this.idTema.get(index);
    }
    
    public String getTema(int index){
        return this.Tema.get(index);
    }
    
    public int searchTema(String tema){
        return this.Tema.indexOf(tema);
    }
    
    public int getSize(){
        return this.idTema.size();
    }
    
}
