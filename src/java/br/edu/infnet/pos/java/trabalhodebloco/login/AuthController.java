/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.pos.java.trabalhodebloco.login;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.edu.infnet.pos.java.trabalhodebloco.facade.UserFacade;
import br.edu.infnet.pos.java.trabalhodebloco.facade.JsfUtil;
import br.edu.infnet.pos.java.trabalhodebloco.model.User;
import br.edu.infnet.pos.java.trabalhodebloco.model.UserController;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Aluno;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.AlunoController;
import static java.util.concurrent.ThreadLocalRandom.current;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.persistence.Id;

/**
 *
 * @author davood
 */
@Named(value = "authController")
@ViewScoped
//@SessionScoped
public class AuthController implements Serializable {

    @EJB
    private UserFacade userFacade;

     private User current;
    private DataModel items = null;
    private int selectedItemIndex;
    
    private String username;
    private String password;
    private String email;
    private AlunoController  aluno;

    public AuthController() {
    }
    
        public User getSelected() {
        if (current == null) {
            current = new User();
            selectedItemIndex = -1;
        }
        return current;
    }
        


 
    public String login() {
        User user = userFacade.findByUsername(username);
        if (user == null || !user.checkPassword(password) || user.getStatus() == -1) {
            JsfUtil.addErrorMessage("Nome de usuário ou senha incorreto");
            return null;
        }
        if (user.getStatus() == 1) {
            JsfUtil.addErrorMessage("Sua conta foi desativada");
            return null;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("user", user);
        JsfUtil.addSuccessMessage("Você foi logado com sucesso");
        return "index.xhtml?faces-redirect=true";
    }

    public String create() {
        //check mobile and password is not empty
        if (username == null
                || username.isEmpty()
                || password == null
                || password.isEmpty()) {
            JsfUtil.addErrorMessage("O nome de usuário e a senha não podem estar vazios");
            return null;
        }
        //check is first time to register
        User existEntity = userFacade.findByUsername(username);
        if (existEntity != null) {
            JsfUtil.addErrorMessage("Este nome de usuário já foi registrado");
            return null;
        } else {
            User cr = new User();
            
        
      
            //String x  =null;
            //x = al.getNome();
            cr.setUsername(username);
            cr.setPlainPassword(password);
            cr.setEmail(email);
            cr.setAluno(aluno.getAluno(selectedItemIndex));
            cr.setStatus(0);
            userFacade.edit(cr);
            JsfUtil.addErrorMessage("Suas informações foram registradas com sucesso");
            FacesContext context = FacesContext.getCurrentInstance();
            try {
                context.getExternalContext().redirect("Create.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void logout() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        //context.getExternalContext().invalidateSession();
        context.getExternalContext().getSessionMap().remove(this);
        context.getExternalContext().redirect("login.xhtml");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public AlunoController getAluno() {
        return aluno;
    }
     
    

    public void setAluno (AlunoController aluno) {
        this.aluno = aluno;
    }
    
    @FacesConverter(forClass = Aluno.class)
    public static class AlunoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AlunoController controller = (AlunoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "alunoController");
            return controller.getAluno(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Aluno) {
                Aluno o = (Aluno) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Aluno.class.getName());
            }
        }

    }
 
    
}


