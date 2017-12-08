package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.controllers;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.enviodeemail.Email;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Avaliacao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.controllers.util.JsfUtil;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.controllers.util.PaginationHelper;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.beans.AvaliacaoFacade;

import java.io.Serializable;
import java.util.List;
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

@Named("avaliacaoController")
@SessionScoped
public class AvaliacaoController implements Serializable {

    private Avaliacao current;
    private DataModel items = null;
    @EJB
    private br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.beans.AvaliacaoFacade ejbAvaliacaoFacade;
    @EJB
    private br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.AlunoFacade ejbAlunoFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public AvaliacaoController() {
    }

    public Avaliacao getSelected() {
        if (current == null) {
            current = new Avaliacao();
            selectedItemIndex = -1;
        }
        return current;
    }

    private AvaliacaoFacade getFacade() {
        return ejbAvaliacaoFacade;
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
        current = (Avaliacao) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }
    
    public void enviarEmail(Integer idModulo) {
        List<String> emails = ejbAlunoFacade.findAllEmailAlunoByModulo(idModulo);
        emails.stream().forEach(email -> {
            try {
                Email.enviarEmail(email);
            } catch (Exception ex) {
                Logger.getLogger(AvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public String prepareCreate() {
        current = new Avaliacao();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AvaliacaoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Avaliacao) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AvaliacaoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Avaliacao) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AvaliacaoDeleted"));
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
        return JsfUtil.getSelectItems(ejbAvaliacaoFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbAvaliacaoFacade.findAll(), true);
    }

    public Avaliacao getAvaliacao(java.lang.Integer id) {
        return ejbAvaliacaoFacade.find(id);
    }

    @FacesConverter(forClass = Avaliacao.class)
    public static class AvaliacaoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AvaliacaoController controller = (AvaliacaoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "avaliacaoController");
            return controller.getAvaliacao(getKey(value));
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
            if (object instanceof Avaliacao) {
                Avaliacao o = (Avaliacao) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Avaliacao.class.getName());
            }
        }

    }

}
