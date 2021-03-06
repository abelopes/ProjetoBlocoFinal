package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.enviodeemail.Email;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.util.JsfUtil;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.util.PaginationHelper;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.beans.AvaliacaoFacade;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.controllers.AvaliacaoController;
import java.io.IOException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javax.inject.Inject;
import jxl.write.WriteException;

@Named("moduloController")
@SessionScoped
public class ModuloController implements Serializable {

    private static final long serialVersionUID = 8444977427822536284L;

    private Modulo current;
    private DataModel items = null;
    @Inject
    ExcelController excelController;

    @EJB
    private br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.ModuloFacade ejbFacade;
    @EJB
    private br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.AlunoFacade ejbAlunoFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    @EJB
    private AvaliacaoFacade avaliacaoFacade;

    public ModuloController() {
    }

    public Modulo getSelected() {
        if (current == null) {
            current = new Modulo();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ModuloFacade getFacade() {
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
        current = (Modulo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Modulo();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ModuloCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Modulo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public void exportarExcel() {
        current = (Modulo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        try {
            excelController.writeExcel(current);
        } catch (WriteException | IOException ex) {
            Logger.getLogger(ModuloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ModuloUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Modulo) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ModuloDeleted"));
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

    public Modulo getModulo(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Modulo.class)
    public static class ModuloControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ModuloController controller = (ModuloController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "moduloController");
            return controller.getModulo(getKey(value));
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
            if (object instanceof Modulo) {
                Modulo o = (Modulo) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Modulo.class.getName());
            }
        }

    }

    public void enviarEmail() {
        current = (Modulo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        List<Aluno> alunos = ejbAlunoFacade.findAllAlunoByModulo(current.getId());
        alunos.stream().forEach(aluno -> {
            aluno.getTurmas().stream().forEach(turma -> {
                avaliacaoFacade.findAll().stream()
                        //.filter(avaliacao -> avaliacao.getInicio().isAfter(LocalDate.now()) && avaliacao.getFim().isBefore(LocalDate.now()))
                        .forEach(avaliacao -> {
                    try {
                        Email.enviarEmail(aluno, current.getId(), turma.getId(), avaliacao.getId());
                    } catch (Exception ex) {
                        Logger.getLogger(ModuloController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            });
        });
    }

}
