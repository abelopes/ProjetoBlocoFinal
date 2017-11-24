package br.edu.infnet.pos.java.trabalhodebloco.infra.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "br.edu.infnet.pos.java.trabalhodebloco.infra.converter.JsfLocalDateTimeConverter", forClass = LocalDateTime.class)
public class JsfLocalDateTimeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LocalDate dataEnviada = null;
        LocalDateTime dataEnviadaTime = null;
        if (value.length() > 0) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataEnviada = LocalDate.parse(value, formatter);
            dataEnviadaTime = dataEnviada.atStartOfDay();
        }
        
        return dataEnviadaTime;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String dataFormatada = "";
        if (value instanceof LocalDateTime) {
            dataFormatada = ((LocalDateTime) value).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return dataFormatada;
    }

}
