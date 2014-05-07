package uy.com.antel.formmrree.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import uy.com.antel.formmrree.controller.RegistroDemandaInicial;
import uy.com.antel.formmrree.model.DemandaInicial;

@ManagedBean
@RequestScoped
public class DemandaInicialBean {
	

		@Inject
		private RegistroDemandaInicial registroCoberturaSalud;
		
		public void registrar() {
			try {
				registroCoberturaSalud.registro();
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró ", "con éxito!");  
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al registrar ", "");  
	        FacesContext.getCurrentInstance().addMessage(null, msg); 
			}
		}
		
		public void onEdit(RowEditEvent event) {  
	            DemandaInicial demandaInicial = ((DemandaInicial) event.getObject());
	           
	            try {
					registroCoberturaSalud.modificar(demandaInicial);
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se modificó ", demandaInicial.getNombre());  
		            FacesContext.getCurrentInstance().addMessage(null, msg); 
				} catch (Exception e) {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error al modificar ", demandaInicial.getNombre());  
		            FacesContext.getCurrentInstance().addMessage(null, msg); 
				}
	    }
		
		public void onCancel(RowEditEvent event) {  
	        FacesMessage msg = new FacesMessage("Se canceló modificar ", ((DemandaInicial) event.getObject()).getNombre());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }  
		
		public void eliminar(Long id) {
			try {
				registroCoberturaSalud.eliminar(id);
				FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());  
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			catch(Exception e) {
				FacesMessage msg = new FacesMessage("Error al eliminar", id.toString());  
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			  
		}

}
