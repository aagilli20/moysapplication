/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moysapplication;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class AccessControlController implements Initializable {
    
    @FXML
    Label errorMessage;
    @FXML
    TextField userId;
    @FXML
    TextField password;
    
    private MoysApplication application;
    
    public void setApp(MoysApplication application){
        this.application = application;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorMessage.setText("");
        userId.setPromptText("usuario");
        password.setPromptText("contraseña");

        
    }
     
    @FXML
    private void handleExitButtonAction(ActionEvent event) {
        // cierra la aplicación
        System.out.println("You clicked exit!");
        System.exit(0);
    }
    
    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws SQLException, NoSuchAlgorithmException {
        // envía usuario y contraseña al control de autenticacion
        if (application == null){
            // Podemos estar corriendo un FXML aislado, posiblemente en Scene Builder
            // NO-OP.
            errorMessage.setText("Hello " + userId.getText());
        } else {
            // verifico la longitud - 5 - 20
            if(((this.userId.getLength() < 5) || (this.userId.getLength() > 20)) && (! "root".equals(this.userId.getText()))){
                errorMessage.setText("El nombre de usuario tiene que tener entre 5 y 20 caracteres");
                password.clear();
                }else if(((this.password.getLength() < 5) || (this.password.getLength() > 20))){
                    errorMessage.setText("La contraseña tiene que tener entre 5 y 20 caracteres");
                    password.clear();
                } else if (!application.userLogging(userId.getText().toLowerCase(), password.getText())){
                errorMessage.setText(application.getErrorMessage());
                password.clear();
            }
        } 
    }
    
    
 }
    
    

