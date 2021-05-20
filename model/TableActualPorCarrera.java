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
public class TableActualPorCarrera {
    
    private StringProperty MAPCCicloLectivo;
        public void setMAPCCicloLectivo(String value) { MAPCCicloLectivoProperty().set(value); }
        public String getMAPCCicloLectivo() { return MAPCCicloLectivoProperty().get(); }
        public StringProperty MAPCCicloLectivoProperty() { 
             if (MAPCCicloLectivo == null) MAPCCicloLectivo = new SimpleStringProperty(this, "MAPCCicloLectivo");
            return MAPCCicloLectivo; 
        }
        
        private StringProperty MAPCNivel;
        public void setMAPCNivel(String value) { MAPCNivelProperty().set(value); }
        public String getMAPCNivel() { return MAPCNivelProperty().get(); }
        public StringProperty MAPCNivelProperty() { 
             if (MAPCNivel == null) MAPCNivel = new SimpleStringProperty(this, "MAPCNivel");
            return MAPCNivel; 
        }
        
        private StringProperty MAPCCarrera;
        public void setMAPCCarrera(String value) { MAPCCarreraProperty().set(value); }
        public String getMAPCCarrera() { return MAPCCarreraProperty().get(); }
        public StringProperty MAPCCarreraProperty() { 
             if (MAPCCarrera == null) MAPCCarrera = new SimpleStringProperty(this, "MAPCCarrera");
            return MAPCCarrera; 
        }
        
        private StringProperty MAPCSeccion;
        public void setMAPCSeccion(String value) { MAPCSeccionProperty().set(value); }
        public String getMAPCSeccion() { return MAPCSeccionProperty().get(); }
        public StringProperty MAPCSeccionProperty() { 
             if (MAPCSeccion == null) MAPCSeccion = new SimpleStringProperty(this, "MAPCSeccion");
            return MAPCSeccion; 
        }
        
        private StringProperty MAPCAlumno;
        public void setMAPCAlumno(String value) { MAPCAlumnoProperty().set(value); }
        public String getMAPCAlumno() { return MAPCAlumnoProperty().get(); }
        public StringProperty MAPCAlumnoProperty() { 
             if (MAPCAlumno == null) MAPCAlumno = new SimpleStringProperty(this, "MAPCAlumno");
            return MAPCAlumno; 
        }
        
        private StringProperty MAPCMatricula;
        public void setMAPCMatricula(String value) { MAPCMatriculaProperty().set(value); }
        public String getMAPCMatricula() { return MAPCMatriculaProperty().get(); }
        public StringProperty MAPCMatriculaProperty() { 
             if (MAPCMatricula == null) MAPCMatricula = new SimpleStringProperty(this, "MAPCMatricula");
            return MAPCMatricula; 
        }
        
        public TableActualPorCarrera(String ciclo_lectivo, String nivel, String carrera, String seccion, String alumnos, String matricula) {
            this.MAPCCicloLectivo = new SimpleStringProperty(ciclo_lectivo);
            this.MAPCNivel = new SimpleStringProperty(nivel);
            this.MAPCCarrera = new SimpleStringProperty(carrera);
            this.MAPCSeccion = new SimpleStringProperty(seccion);
            this.MAPCAlumno = new SimpleStringProperty(alumnos);
            this.MAPCMatricula = new SimpleStringProperty(matricula);
        }
    
}
