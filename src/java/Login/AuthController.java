/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import Facade.UserFacade;
import Facade.JsfUtil;
import Model.User;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Aluno;
import static java.util.concurrent.ThreadLocalRandom.current;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;

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
            Aluno al = new Aluno();
            cr.setUsername(username);
            cr.setPlainPassword(password);
            cr.setAluno(al);
            cr.setStatus(selectedItemIndex);
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
}
