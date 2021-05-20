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
public class TableActivaCiclosAnt {
    
    private StringProperty MACACicloLectivo;
        public void setMACACicloLectivo(String value) { MACACicloLectivoProperty().set(value); }
        public String getMACACicloLectivo() { return MACACicloLectivoProperty().get(); }
        public StringProperty MACACicloLectivoProperty() { 
             if (MACACicloLectivo == null) MACACicloLectivo = new SimpleStringProperty(this, "MACACicloLectivo");
            return MACACicloLectivo; 
        }
        
        private StringProperty MACACarrera;
        public void setMACACarrera(String value) { MACACarreraProperty().set(value); }
        public String getMACACarrera() { return MACACarreraProperty().get(); }
        public StringProperty MACACarreraProperty() { 
             if (MACACarrera == null) MACACarrera = new SimpleStringProperty(this, "MACACarrera");
            return MACACarrera; 
        }
        
        private StringProperty MACAAnioEstudio;
        public void setMACAAnioEstudio(String value) { MACAAnioEstudioProperty().set(value); }
        public String getMACAAnioEstudio() { return MACAAnioEstudioProperty().get(); }
        public StringProperty MACAAnioEstudioProperty() { 
             if (MACAAnioEstudio == null) MACAAnioEstudio = new SimpleStringProperty(this, "MACAAnioEstudio");
            return MACAAnioEstudio; 
        }
        
        private StringProperty MACASeccion;
        public void setMACASeccion(String value) { MACASeccionProperty().set(value); }
        public String getMACASeccion() { return MACASeccionProperty().get(); }
        public StringProperty MACASeccionProperty() { 
             if (MACASeccion == null) MACASeccion = new SimpleStringProperty(this, "MACASeccion");
            return MACASeccion; 
        }
        
        private StringProperty MACAAlumno;
        public void setMACAAlumno(String value) { MACAAlumnoProperty().set(value); }
        public String getMACAAlumno() { return MACAAlumnoProperty().get(); }
        public StringProperty MACAAlumnoProperty() { 
             if (MACAAlumno == null) MACAAlumno = new SimpleStringProperty(this, "MACAAlumno");
            return MACAAlumno; 
        }
        
        private StringProperty MACADocumento;
        public void setMACADocumento(String value) { MACADocumentoProperty().set(value); }
        public String getMACADocumento() { return MACADocumentoProperty().get(); }
        public StringProperty MACADocumentoProperty() { 
             if (MACADocumento == null) MACADocumento = new SimpleStringProperty(this, "MACADocumento");
            return MACADocumento; 
        }
        
        private StringProperty MACASexo;
        public void setMACASexo(String value) { MACASexoProperty().set(value); }
        public String getMACASexo() { return MACASexoProperty().get(); }
        public StringProperty MACASexoProperty() { 
             if (MACASexo == null) MACASexo = new SimpleStringProperty(this, "MACASexo");
            return MACASexo; 
        }
        
        public TableActivaCiclosAnt(String ciclo_lectivo, String carrera, String anio_estudio, String seccion, String alumno, String documento, String sexo) {
            this.MACACicloLectivo = new SimpleStringProperty(ciclo_lectivo);
            this.MACACarrera = new SimpleStringProperty(carrera);
            this.MACAAnioEstudio = new SimpleStringProperty(anio_estudio);
            this.MACASeccion = new SimpleStringProperty(seccion);
            this.MACAAlumno = new SimpleStringProperty(alumno);
            this.MACADocumento = new SimpleStringProperty(documento);
            this.MACASexo = new SimpleStringProperty(sexo);
        }
    
}
