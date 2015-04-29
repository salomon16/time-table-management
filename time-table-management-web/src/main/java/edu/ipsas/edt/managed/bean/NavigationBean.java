package edu.ipsas.edt.managed.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
@ManagedBean
@RequestScoped
public class NavigationBean {
	 private String pageName="/timemanager/default";

	    public NavigationBean() {
	    }

	    public String doNav() {
	        System.out.println("Hello");
	        String str = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("test");
	        this.pageName = str;
	        return "";
	        
	    }
	    
	    public String openPage(String src){
	        this.pageName = src; 
	        return "";
	    }
	    public String getPageName() {
	        return pageName;
	    }

	    public void setPageName(String pageName) {
	        this.pageName = pageName;
	    }
}
