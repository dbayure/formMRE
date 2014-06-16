package validaciones;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator ("ValidaDocumentoCi")
public class ValidaDocumentoCi implements Validator {

	@Override
	 public void validate(FacesContext contexto, UIComponent comp, Object valor) throws ValidatorException{
			  int [] validador = new int [] {0,4,3,6,7,8,9,2};
			  int sumaDigitos = 0;
			  int ciInt = Integer.parseInt(valor.toString());
			  int [] arrayCiInt = new int [8];
			  System.out.println("valor del numero que saco de la casilla: " + ciInt);
			  for (int i=0; i<(arrayCiInt.length);i++)
			  {
				  arrayCiInt[i] = ciInt%10;
				  ciInt = ciInt/10;
				  sumaDigitos = (sumaDigitos + (arrayCiInt[i]*validador[i]));
				  System.out.println("Suma parcial de " + arrayCiInt[i] + "x" + validador[i] + "=" + sumaDigitos );
			  }
		      int digitModDiez = sumaDigitos % 10;
		      int digito = ((10-digitModDiez)%10);
		      System.out.println("valor de la suma: " + sumaDigitos);
		      System.out.println("Valor del digito encontrado: " + digito);
		      if (digito != (arrayCiInt[0])){    
		    	  FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error la cedula ingresada no es valida ", "");  
//		    	  FacesContext.getCurrentInstance().addMessage(null, msg);
		    	  throw new ValidatorException(msg);
		}
		  
	}


}
