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
public class TableHistoricoMatricula {
    
    private StringProperty HMCicloLectivo;
        public void setHMCicloLectivo(String value) { HMCicloLectivoProperty().set(value); }
        public String getHMCicloLectivo() { return HMCicloLectivoProperty().get(); }
        public StringProperty HMCicloLectivoProperty() { 
             if (HMCicloLectivo == null) HMCicloLectivo = new SimpleStringProperty(this, "HMCicloLectivo");
            return HMCicloLectivo; 
        }
        
        private StringProperty HMSeccion;
        public void setHMSeccion(String value) { HMSeccionProperty().set(value); }
        public String getHMSeccion() { return HMSeccionProperty().get(); }
        public StringProperty HMSeccionProperty() { 
             if (HMSeccion == null) HMSeccion = new SimpleStringProperty(this, "HMSeccion");
            return HMSeccion; 
        }
        
        private StringProperty HMAlumno;
        public void setHMAlumno(String value) { HMAlumnoProperty().set(value); }
        public String getHMAlumno() { return HMAlumnoProperty().get(); }
        public StringProperty HMAlumnoProperty() { 
             if (HMAlumno == null) HMAlumno = new SimpleStringProperty(this, "HMAlumno");
            return HMAlumno; 
        }
        
        private StringProperty HMMatricula;
        public void setHMMatricula(String value) { HMMatriculaProperty().set(value); }
        public String getHMMatricula() { return HMMatriculaProperty().get(); }
        public StringProperty HMMatriculaProperty() { 
             if (HMMatricula == null) HMMatricula = new SimpleStringProperty(this, "HMMatricula");
            return HMMatricula; 
        }
        
        public TableHistoricoMatricula(String ciclo_lectivo, String secciones, String alumnos, String matricula) {
            this.HMCicloLectivo = new SimpleStringProperty(ciclo_lectivo);
            this.HMSeccion = new SimpleStringProperty(secciones);
            this.HMAlumno = new SimpleStringProperty(alumnos);
            this.HMMatricula = new SimpleStringProperty(matricula);
        }
    
}
