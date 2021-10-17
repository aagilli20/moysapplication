/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication.model;

import java.io.IOException;
import java.util.ArrayList;
import moysapplication.data.readExcel;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class BecasOtorgadas {
    private int becasOtorgadas;
    
    public BecasOtorgadas(){
        becasOtorgadas = 0;
    }
    
    public void loadBecasOtorgadas(int NroOrganismo) throws IOException{
        readExcel data = new readExcel();
        int idSQL = 400;
        String param = "&PEscuela="+NroOrganismo+"&PAnio=&PNombreArchivo=Becas";
        ArrayList<ArrayList<String>> resultados = data.getArrayList(idSQL, param);
        if(resultados.size() > 2) this.becasOtorgadas = resultados.size() - 1;
        else {
            if(resultados.size() == 2){
                if(resultados.get(1).get(1).equals("-")) this.becasOtorgadas = 0;
                else this.becasOtorgadas = 1;
            }
        }
    }
    
    public int getBecasOtorgadas(){ return this.becasOtorgadas; }
           
}
