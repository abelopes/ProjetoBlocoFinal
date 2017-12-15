package br.edu.infnet.pos.java.trabalhodebloco.infra.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "br.edu.infnet.pos.java.trabalhodebloco.infra.converter.JsfToLocalDateConverter", forClass = LocalDate.class)
public class JsfStringToLocalDateConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LocalDate dataEnviada = null;
        if (value.length() > 0) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataEnviada = LocalDate.parse(value, formatter);
        }
        return dataEnviada;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String dataFormatada = "";
        if (value instanceof LocalDate) {
            dataFormatada = ((LocalDate) value).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return dataFormatada;
    }

}
