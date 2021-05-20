/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication.model;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class Escuela {
    
    private final int NroOrg;
    private final String Nombre;
    private final String CUE;
    private final int Anexo;
    private final String CodJuris;
    private final String Region;
    private final String Localidad;
    
    public Escuela(){
        this.NroOrg = -1;
        this.Nombre = null;
        this.CUE = null;
        this.Anexo = -1;
        this.CodJuris = null;
        this.Region = null;
        this.Localidad = null;
    }
    
    public Escuela(int nro_organismo, String nombre, String cue, int anexo, String cod_juris, String region, String localidad){
        this.NroOrg = nro_organismo;
        this.Nombre = nombre;
        this.CUE = cue;
        this.Anexo = anexo;
        this.CodJuris = cod_juris;
        this.Region = region;
        this.Localidad = localidad;
    }
    
    /*
    * Acceso a datos
    */
    
    public int getNroOrg(){
        return this.NroOrg;
    }
    
    public String getNombre(){
        return this.Nombre;
    }
    
    public String getCUE(){
        return this.CUE;
    }
    
    public int getAnexo(){
        return this.Anexo;
    }
    
    public String getCodJuris(){
        return this.CodJuris;
    }
    
    public String getRegion(){
        return this.Region;
    }
    
    public String getLocalidad(){
        return this.Localidad;
    }
}
