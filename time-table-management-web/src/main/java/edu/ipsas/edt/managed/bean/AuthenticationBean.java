package edu.ipsas.edt.managed.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;

import edu.ipsas.edt.dto.PersonnelAdministratifDto;

@ManagedBean
@ViewScoped
public class AuthenticationBean implements Serializable, PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	private PersonnelAdministratifDto user;
	private String username; 
    private String password;
    private boolean remember;

    @ManagedProperty(value="#{authenticationManager}")
    private AuthenticationManager authenticationManager;
    
    
//    public AuthenticationBean() {
//		super();
//		user = new PersonnelAdministratifDto();
//		 SecurityContext context = SecurityContextHolder.getContext();
//	        if (context instanceof SecurityContext){
//	            Authentication authentication = context.getAuthentication();
//	            if (authentication instanceof Authentication){
//	            	user.setLogin(((PersonnelAdministratifDto)authentication.getPrincipal()).getLogin());
//	            }
//	        }
//	}
	public String doLogin() {
    	  try {
    	   Authentication authenticate = authenticationManager
    	     .authenticate(new UsernamePasswordAuthenticationToken(
    	       username, password));
    	   if (authenticate.isAuthenticated()) {
    	    SecurityContextHolder.getContext().setAuthentication(
    	      authenticate);    
    	    return "/timemanager/index.xhtml";
    	   }
    	  } catch (AuthenticationException e) {   
    	  }
    	  return "/login.xhtml";
    	 }
//    public String doLogin() throws IOException, ServletException
//    {
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
// 
//        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
//                 .getRequestDispatcher("/j_spring_security_check");
// 
//        dispatcher.forward((ServletRequest) context.getRequest(),
//                (ServletResponse) context.getResponse());
// 
//        FacesContext.getCurrentInstance().responseComplete();
      // It's OK to return null here because Faces is just going to exit.
//        return null;
//    }
    public String cancel() {
        return null;
    }

    public String logout(){
        SecurityContextHolder.clearContext();
        return "logout";
    }
 
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remenber) {
		this.remember = remenber;
	}
	
	public void afterPhase(PhaseEvent arg0) {
		
	}
	
	public void beforePhase(PhaseEvent event) {
        Exception e = (Exception) FacesContext.getCurrentInstance().
          getExternalContext().getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);
 
        if (e instanceof BadCredentialsException) {
            logger.debug("Found exception in session map: "+e);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
                    WebAttributes.AUTHENTICATION_EXCEPTION, null);
            FacesContext.getCurrentInstance().addMessage(null, 
              new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Username or password not valid.", "Username or password not valid"));
        }
    }
	
	public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
	public PersonnelAdministratifDto getUser() {
		return user;
	}
	public void setUser(PersonnelAdministratifDto user) {
		this.user = user;
	}
    
	
}
