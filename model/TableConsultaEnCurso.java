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
public class TableConsultaEnCurso {
    
        private StringProperty IdConsulta;
        public void setIdConsulta(String value) { IdConsultaProperty().set(value); }
        public String getIdConsulta() { return IdConsultaProperty().get(); }
        public StringProperty IdConsultaProperty() { 
             if (IdConsulta == null) IdConsulta = new SimpleStringProperty(this, "IdConsulta");
            return IdConsulta; 
        }
        
        private StringProperty Tema;
        public void setTema(String value) { TemaProperty().set(value); }
        public String getTema() { return TemaProperty().get(); }
        public StringProperty TemaProperty() { 
             if (Tema == null) Tema = new SimpleStringProperty(this, "Tema");
            return Tema; 
        }
        
        private StringProperty Observacion;
        public void setObservacion(String value) { ObservacionProperty().set(value); }
        public String getObservacion() { return ObservacionProperty().get(); }
        public StringProperty ObservacionProperty() { 
             if (Observacion == null) Observacion = new SimpleStringProperty(this, "Observacion");
            return Observacion; 
        }
        
        private StringProperty FeAlta;
        public void setFeAlta(String value) { FeAltaProperty().set(value); }
        public String getFeAlta() { return FeAltaProperty().get(); }
        public StringProperty FeAltaProperty() { 
             if (FeAlta == null) FeAlta = new SimpleStringProperty(this, "FeAlta");
            return FeAlta; 
        }
        
        private StringProperty Operador;
        public void setOperador(String value) { OperadorProperty().set(value); }
        public String getOperador() { return OperadorProperty().get(); }
        public StringProperty OperadorProperty() { 
             if (Operador == null) Operador = new SimpleStringProperty(this, "Operador");
            return Operador; 
        }
       
        public TableConsultaEnCurso(String tema, String observacion, String fe_alta, String operador, String id_consulta) {
            this.IdConsulta = new SimpleStringProperty(id_consulta);
            this.Tema = new SimpleStringProperty(tema);
            this.Observacion = new SimpleStringProperty(observacion);
            this.FeAlta = new SimpleStringProperty(fe_alta);
            this.Operador = new SimpleStringProperty(operador);
        }
}
