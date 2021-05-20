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
public class TableConectividad {
    
    private StringProperty Anio;
        public void setAnio(String value) { AnioProperty().set(value); }
        public String getAnio() { return AnioProperty().get(); }
        public StringProperty AnioProperty() { 
             if (Anio == null) Anio = new SimpleStringProperty(this, "Anio");
            return Anio; 
        }
        
        private StringProperty Mes;
        public void setMes(String value) { MesProperty().set(value); }
        public String getMes() { return MesProperty().get(); }
        public StringProperty MesProperty() { 
             if (Mes == null) Mes = new SimpleStringProperty(this, "Mes");
            return Mes; 
        }
        
        private StringProperty Detalle;
        public void setDetalle(String value) { DetalleProperty().set(value); }
        public String getDetalle() { return DetalleProperty().get(); }
        public StringProperty DetalleProperty() { 
             if (Detalle == null) Detalle = new SimpleStringProperty(this, "Detalle");
            return Detalle; 
        }
        
        private StringProperty Importe;
        public void setImporte(String value) { ImporteProperty().set(value); }
        public String getImporte() { return ImporteProperty().get(); }
        public StringProperty ImporteProperty() { 
             if (Importe == null) Importe = new SimpleStringProperty(this, "Importe");
            return Importe; 
        }
        
        public TableConectividad(String anio, String mes, String detalle, String importe) {
            this.Anio = new SimpleStringProperty(anio);
            this.Mes = new SimpleStringProperty(mes);
            this.Detalle = new SimpleStringProperty(detalle);
            this.Importe = new SimpleStringProperty(importe);
        }
        
}
