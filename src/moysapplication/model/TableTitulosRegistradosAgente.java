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
public class TableTitulosRegistradosAgente {
    private StringProperty Establecimiento;
    public void setEstablecimiento(String value) { EstablecimientoProperty().set(value); }
    public String getEstablecimiento() { return EstablecimientoProperty().get(); }
    public StringProperty EstablecimientoProperty() { 
         if (Establecimiento == null) Establecimiento = new SimpleStringProperty(this, "Establecimiento");
        return Establecimiento; 
    }
    
    private StringProperty Plan;
    public void setPlan(String value) { PlanProperty().set(value); }
    public String getPlan() { return PlanProperty().get(); }
    public StringProperty PlanProperty() { 
         if (Plan == null) Plan = new SimpleStringProperty(this, "Plan");
        return Plan; 
    }

    private StringProperty Titulo;
    public void setTitulo(String value) { TituloProperty().set(value); }
    public String getTitulo() { return TituloProperty().get(); }
    public StringProperty TituloProperty() { 
         if (Titulo == null) Titulo = new SimpleStringProperty(this, "Titulo");
        return Titulo; 
    }

    private StringProperty Registro;
    public void set(String value) { RegistroProperty().set(value); }
    public String getRegistro() { return RegistroProperty().get(); }
    public StringProperty RegistroProperty() { 
         if (Registro == null) Registro = new SimpleStringProperty(this, "Registro");
        return Registro; 
    }

    private StringProperty Diploma;
    public void setDiploma(String value) { DiplomaProperty().set(value); }
    public String getDiploma() { return DiplomaProperty().get(); }
    public StringProperty DiplomaProperty() { 
         if (Diploma == null) Diploma = new SimpleStringProperty(this, "Diploma");
        return Diploma; 
    }
    
    public TableTitulosRegistradosAgente(ArrayList<String> parametros) {
        this.Establecimiento = new SimpleStringProperty(parametros.get(0));
        this.Plan = new SimpleStringProperty(parametros.get(1));
        this.Titulo = new SimpleStringProperty(parametros.get(2));
        this.Registro = new SimpleStringProperty(parametros.get(3));
        this.Diploma = new SimpleStringProperty(parametros.get(4));
    }
}
