package br.edu.infnet.pos.java.trabalhodebloco.model;

import br.edu.infnet.pos.java.trabalhodebloco.login.AuthController;
import br.edu.infnet.pos.java.trabalhodebloco.model.util.JsfUtil;
import br.edu.infnet.pos.java.trabalhodebloco.model.util.PaginationHelper;
import java.io.IOException;

import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import br.edu.infnet.pos.java.trabalhodebloco.facade.UserFacade;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.AlunoController;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;

@Named("userController")
@RequestScoped
//@SessionScoped
//@ViewScoped
public class UserController implements Serializable {

    private User current;
    private DataModel items = null;
    @EJB
    private br.edu.infnet.pos.java.trabalhodebloco.facade.UserFacade ejbFacade;
    private UserFacade userFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
     private String username;
    private String password;
    private String email;
    private AlunoController  aluno;

    public UserController() {
    }

    public User getSelected() {
        if (current == null) {
            current = new User();
            selectedItemIndex = -1;
        }
        return current;
    }

    private br.edu.infnet.pos.java.trabalhodebloco.facade.UserFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (User) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new User();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.setUsername(username);
            current.setPlainPassword(password);
            current.setEmail(email);
            current.setStatus(0);
            getFacade().create(current);
           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UserCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
    
    
    /*  public String create() {
        //check mobile and password is not empty
        if (username == null
                || username.isEmpty()
                || password == null
                || password.isEmpty()) {
            Facade.JsfUtil.addErrorMessage("O nome de usuário e a senha não podem estar vazios");
            return null;
        }
        //check is first time to register
        User existEntity = userFacade.findByUsername(username);
        if (existEntity != null) {
            Facade.JsfUtil.addErrorMessage("Este nome de usuário já foi registrado");
            return null;
        } else {
            User cr = new User();
            
        
      
            //String x  =null;
            //x = al.getNome();
            cr.setUsername(username);
            cr.setPlainPassword(password);
            cr.setEmail(email);
            cr.setAluno(aluno.getSelected());
            cr.setStatus(0);
            userFacade.edit(cr);
            Facade.JsfUtil.addErrorMessage("Suas informações foram registradas com sucesso");
            FacesContext context = FacesContext.getCurrentInstance();
            try {
                context.getExternalContext().redirect("Create.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
*/


    public String prepareEdit() {
        current = (User) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UserUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (User) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UserDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public User getUser(java.lang.Integer id) {
        return ejbFacade.find(id);
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
    

    @FacesConverter(forClass = User.class)
    public static class UserControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UserController controller = (UserController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "userController");
            return controller.getUser(getKey(value));
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
            if (object instanceof User) {
                User o = (User) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + User.class.getName());
            }
        }

    }

}
