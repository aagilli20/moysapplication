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
public class TableMedioBoleto {
    
    private StringProperty MBAlumno;
        public void setMBAlumno(String value) { MBAlumnoProperty().set(value); }
        public String getMBAlumno() { return MBAlumnoProperty().get(); }
        public StringProperty MBAlumnoProperty() { 
             if (MBAlumno == null) MBAlumno = new SimpleStringProperty(this, "MBAlumno");
            return MBAlumno; 
        }
        
        private StringProperty MBDocumento;
        public void setMBDocumento(String value) { MBDocumentoProperty().set(value); }
        public String getMBDocumento() { return MBDocumentoProperty().get(); }
        public StringProperty MBDocumentoProperty() { 
             if (MBDocumento == null) MBDocumento = new SimpleStringProperty(this, "MBDocumento");
            return MBDocumento; 
        }
        
        private StringProperty MBMensaje;
        public void setMBMensaje(String value) { MBMensajeProperty().set(value); }
        public String getMBMensaje() { return MBMensajeProperty().get(); }
        public StringProperty MBMensajeProperty() { 
             if (MBMensaje == null) MBMensaje = new SimpleStringProperty(this, "MBMensaje");
            return MBMensaje; 
        }
        
        private StringProperty MBEstado;
        public void setMBEstado(String value) { MBEstadoProperty().set(value); }
        public String getMBEstado() { return MBEstadoProperty().get(); }
        public StringProperty MBEstadoProperty() { 
             if (MBEstado == null) MBEstado = new SimpleStringProperty(this, "MBEstado");
            return MBEstado; 
        }
        
        private StringProperty MBObservacion;
        public void setMBObservacion(String value) { MBObservacionProperty().set(value); }
        public String getMBObservacion() { return MBObservacionProperty().get(); }
        public StringProperty MBObservacionProperty() { 
             if (MBObservacion == null) MBObservacion = new SimpleStringProperty(this, "MBObservacion");
            return MBObservacion; 
        }
        
        public TableMedioBoleto(String mb_alumno, String mb_documento, String mb_estado, String mb_mensaje, String mb_observacion) {
            this.MBAlumno = new SimpleStringProperty(mb_alumno);
            this.MBDocumento = new SimpleStringProperty(mb_documento);
            this.MBMensaje = new SimpleStringProperty(mb_mensaje);
            this.MBEstado = new SimpleStringProperty(mb_estado);
            this.MBObservacion = new SimpleStringProperty(mb_observacion);
        }
}
