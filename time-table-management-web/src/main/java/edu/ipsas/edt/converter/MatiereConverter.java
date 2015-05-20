package edu.ipsas.edt.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import edu.ipsas.edt.dto.MatiereDto;
import edu.ipsas.edt.managed.bean.MatiereBean;

@FacesConverter("matiereConverter")
public class MatiereConverter {

	 public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
	        if(value != null && value.trim().length() > 0) {
	            try {
	                MatiereBean service = (MatiereBean) fc.getExternalContext().getApplicationMap().get("matiereBean");
	                return service.getAllMatiere();
	            } catch(NumberFormatException e) {
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
	            }
	        }
	        else {
	            return null;
	        }
	    }
	 
	    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
	        if(object != null) {
	            return String.valueOf(((MatiereDto) object).getMatiereId());
	        }
	        else {
	            return null;
	        }
	    }   
}
