/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import moysapplication.data.NPMoysConnect;
import moysapplication.data.readExcel;

/**
 * FXML Controller class
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class UpdateDbOrgController implements Initializable {

    MoysApplication application;
    
    @FXML
    TextArea textMessage;
    
    public void setApp(MoysApplication application){
        this.application = application;
    }
    
    public void processLogout(ActionEvent event) {
        if (application == null){
            // Podemos estar corriendo un FXML aislado, posiblemente en Scene Builder
            // NO-OP.
            return;
        }
        
        application.userLogout();
    }
    
    public void processUpdateDB(ActionEvent event) throws IOException, SQLException {
        // acceso a los datos del ministerio de educación
        String message = "Comenzando la conexión con las bases del Ministerio de Educación...\n";
        this.textMessage.setText(message);
        readExcel leerExcel = new readExcel();
        int idSQL = 51990;
        String param = "&PNombreArchivo=reporte";
        ArrayList<ArrayList<String>> organismos = leerExcel.getArrayList(idSQL, param);
        NPMoysConnect conn = new NPMoysConnect();
        boolean ok;
        if(organismos.size() > 0){
            // la comunicación fue exitosa
            message += "La conexión se realizó con éxito!\n";
            this.textMessage.setText(message);
            // realizar el truncado
            message += "Comenzando el truncado de datos...\n";
            this.textMessage.setText(message);
            ok = conn.truncateDB();
            if(ok) {
                message += "El truncado se realizó con éxito!\n";
                this.textMessage.setText(message);
                // realizar la actualización
                message += "Comenzando la actualización de los organismos...\n";
                this.textMessage.setText(message);
                ok = conn.updateDB(organismos);
                if(ok) { 
                    message += "La actualización se realizó con éxito!\n";
                    this.textMessage.setText(message);
                } else {
                    message += "Se produjo un error al realizar la actualización, intentelo nuevamente...\n";
                    this.textMessage.setText(message);
                }
            }
            else {
                message += "Error al realizar el truncado, intentelo nuevamente...\n";
                this.textMessage.setText(message);
            }
        } else {
            // la conexión falló
            message += "Error al establecer la conexión, intentelo nuevamente...\n";
            this.textMessage.setText(message);
        }
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.textMessage.setText("");
    }    
    
}
