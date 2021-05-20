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
public class Llamada {
    
    private final String opcionElegida;
    private final String idEmisor;
    private final int idTipoEmisor;
    

    public Llamada(String OpcionElegida, String IdEmisor, int IdTipoEmisor) {
        this.opcionElegida = OpcionElegida;
        this.idEmisor = IdEmisor;
        this.idTipoEmisor = IdTipoEmisor;
    }
    
    public String getOpcionElegida(){return this.opcionElegida;}
    
    public String getIdEmisor(){return this.idEmisor;}
    
    public int getIdTipoEmisor(){return this.idTipoEmisor;}
    
}
