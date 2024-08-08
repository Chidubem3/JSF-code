/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dubem
 */
//import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

//annotation below names my managedBean as userBean so anywhere userbean is called it calls my java class (managedBeanClass)
@ManagedBean(name = "userBean")
@SessionScoped

public class ManagedBeanClass{

    
    private String fullName;
    private String email;
    private String password;
    private boolean isAuthenticated = false;

//    Getter and Setter for the above variables
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullname) {
        this.fullName = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
    
 
    
//    Sign-up Method
    public String signUp(){
        if(fullName.isEmpty()|| email.isEmpty() || password.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "All fields "
                            + "are required"));
            return null;   
        }
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sign-up Successfull", 
                         "success! Please sign in."));
        return "signin.xhml"; // This will Navigate to sign-in page    
    }
    


// Sign-In Method
    public String signIn(){
        
        if("dubemubah123@gmail.com".equals(email) && "peter1".equals(password)){
            isAuthenticated = true;
            return "welcome.xhtml";// this will take you to the welcome page
        }else{
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Invalid email or password","Error"));
            return null;
        } 
    }
    
// Sign-Out Method
    public String signOut(){
        System.out.println("Sign-out Method Called");
        isAuthenticated = false;
       
        return "signin.xhtml";
    }
}
