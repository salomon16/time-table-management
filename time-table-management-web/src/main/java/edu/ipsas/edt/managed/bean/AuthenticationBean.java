package edu.ipsas.edt.managed.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
@ViewScoped
public class AuthenticationBean {

	private String userName; 
    private String password;
    private boolean remember;

    @ManagedProperty(value="#{authenticationManager}")
    private AuthenticationManager authenticationManager;
    
//    @ManagedProperty(value="#{rememberMeServices}")
//    private RememberMeServices rememberMeServices;

    public String login() {
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(getUserName(),getPassword());
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "login";
        }
        return "/timemanager/index";
    }

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
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
    
}
