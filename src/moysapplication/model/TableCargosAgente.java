/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication.model;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class TableCargosAgente {
    private StringProperty Establecimiento;
    public void setEstablecimiento(String value) { EstablecimientoProperty().set(value); }
    public String getEstablecimiento() { return EstablecimientoProperty().get(); }
    public StringProperty EstablecimientoProperty() { 
         if (Establecimiento == null) Establecimiento = new SimpleStringProperty(this, "Establecimiento");
        return Establecimiento; 
    }
    
    private StringProperty Tarea;
    public void setTarea(String value) { TareaProperty().set(value); }
    public String getTarea() { return TareaProperty().get(); }
    public StringProperty TareaProperty() { 
         if (Tarea == null) Tarea = new SimpleStringProperty(this, "Tarea");
        return Tarea; 
    }

    private StringProperty IdCargo;
    public void setIdCargo(String value) { IdCargoProperty().set(value); }
    public String getIdCargo() { return IdCargoProperty().get(); }
    public StringProperty IdCargoProperty() { 
         if (IdCargo == null) IdCargo = new SimpleStringProperty(this, "IdCargo");
        return IdCargo; 
    }

    private StringProperty SitRevista;
    public void set(String value) { SitRevistaProperty().set(value); }
    public String getSitRevista() { return SitRevistaProperty().get(); }
    public StringProperty SitRevistaProperty() { 
         if (SitRevista == null) SitRevista = new SimpleStringProperty(this, "SitRevista");
        return SitRevista; 
    }

    private StringProperty FeTomaPosecion;
    public void setFeTomaPosecion(String value) { FeTomaPosecionProperty().set(value); }
    public String getFeTomaPosecion() { return FeTomaPosecionProperty().get(); }
    public StringProperty FeTomaPosecionProperty() { 
         if (FeTomaPosecion == null) FeTomaPosecion = new SimpleStringProperty(this, "FeTomaPosecion");
        return FeTomaPosecion; 
    }
    
    private StringProperty FeCese;
    public void setFeCese(String value) { FeCeseProperty().set(value); }
    public String getFeCese() { return FeCeseProperty().get(); }
    public StringProperty FeCeseProperty() { 
         if (FeCese == null) FeCese = new SimpleStringProperty(this, "FeCese");
        return FeCese; 
    }
    
    public TableCargosAgente(ArrayList<String> parametros) {
        this.Establecimiento = new SimpleStringProperty(parametros.get(0));
        this.Tarea = new SimpleStringProperty(parametros.get(1));
        this.IdCargo = new SimpleStringProperty(parametros.get(2));
        this.SitRevista = new SimpleStringProperty(parametros.get(3));
        this.FeTomaPosecion = new SimpleStringProperty(parametros.get(4));
        this.FeCese = new SimpleStringProperty(parametros.get(5));
    }
}
