package uy.com.antel.formmrree.converter;

import java.net.URL;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;

import uy.com.antel.formmrree.model.CoberturaSalud;

@FacesConverter(forClass = CoberturaSalud.class, value = "coberturaSaludConverter")
public class CoberturaSaludConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.trim().equals("")) {
			value = ((HttpServletRequest) context.getExternalContext().getRequest()).getParameter(component.getClientId()+"_input");
//			return null;
		}
		CoberturaSalud ciudad = null;
		try {
			ObjectMapper mapper = new ObjectMapper();	
			ciudad = mapper.readValue(new URL(  context.getExternalContext().getRequestScheme() + "://" + context.getExternalContext().getRequestServerName()
					+ ":" + context.getExternalContext().getRequestServerPort() + context.getExternalContext().getRequestContextPath() 
					+ "/rest/coberturasSalud/" + value), CoberturaSalud.class);
		}
		catch(Exception e) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Conversion", "CoberturaSalud no válido"));
		}
		return ciudad;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return String.valueOf( ((CoberturaSalud)value).getId()  );
        }
	}

	
}
