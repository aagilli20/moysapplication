/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class TableREDFIE {
    
    private StringProperty Descripcion;
        public void setDescripcion(String value) { DescripcionProperty().set(value); }
        public String getDescripcion() { return DescripcionProperty().get(); }
        public StringProperty DescripcionProperty() { 
             if (Descripcion == null) Descripcion = new SimpleStringProperty(this, "Descripcion");
            return Descripcion; 
        }
        
        private StringProperty Observacion;
        public void setObservacion(String value) { ObservacionProperty().set(value); }
        public String getObservacion() { return ObservacionProperty().get(); }
        public StringProperty ObservacionProperty() { 
             if (Observacion == null) Observacion = new SimpleStringProperty(this, "Observacion");
            return Observacion; 
        }
        
        
        public TableREDFIE(String descripcion, String observacion) {
            this.Descripcion = new SimpleStringProperty(descripcion);
            this.Observacion = new SimpleStringProperty(observacion);
        }
    
}
