package uy.com.antel.formmrree.converter;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;

import uy.com.antel.formmrree.model.Pais;
import uy.com.antel.formmrree.model.PaisResidencia;

@FacesConverter(forClass = PaisResidencia.class, value = "paisResidenciaConverter")
public class PaisResidenciaConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.trim().equals("")) {
			value = ((HttpServletRequest) context.getExternalContext().getRequest()).getParameter(component.getClientId()+"_input");
		}
		PaisResidencia paisResidencia = null;
		try {
			ObjectMapper mapper = new ObjectMapper();	
			Pais pais = mapper.readValue(new URL( context.getExternalContext().getRequestScheme() + "://" + context.getExternalContext().getRequestServerName()
					+ ":"  + context.getExternalContext().getRequestServerPort() + context.getExternalContext().getRequestContextPath() 
					+ "/rest/paises/" + value), Pais.class);

			paisResidencia = new PaisResidencia();
			paisResidencia.setPais(pais);
		}
		catch(Exception e) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Conversion", "Pais Residencia no válido"));
		}
		return paisResidencia;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || value.equals("") || value instanceof ArrayList<?>) {
            return "";
        } else {
        	return String.valueOf( ((Pais)value).getId()  );
        }
	}
}
