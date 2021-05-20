/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moysapplication.model;


/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class User {
   
    private final String UserId;
    private int UserType;
    private final String UserPassword;
    private final String Agent;

    public User(String userId, int userType, String userPassword, String agent) {
        this.UserId = userId;
        this.UserType = userType;
        this.UserPassword = userPassword;
        this.Agent = agent;
    }

    public String getUser() {
        return this.UserId;
    }
    
    public int getUserType() {
        return this.UserType;
    }
    
    public String getUserPassword(){
        return this.UserPassword;
    }
    
    public String getAgent(){
        return this.Agent;
    }
    
    public void setUserType(int userType){
        this.UserType = userType;
    }
}
