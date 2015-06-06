package edu.ipsas.edt.dto;


public class PersonnelAdministratifDto extends PersonneDto {

	
	private long PersonnelId;
	
	private String fonction;
	
	private String telFixe;
	
	private RoleDto role;
	
	private boolean enabled;
	
	private DepartementDto departementDto;

	public PersonnelAdministratifDto() {
		super();
	}

	public PersonnelAdministratifDto(String nom, String prenom, String cin,
			String adresse, String telephoneMobile, String email) {
		super(nom, prenom, cin, adresse, telephoneMobile, email);
	}

	public PersonnelAdministratifDto(String fonction, String telFixe) {
		super();
		this.fonction = fonction;
		this.telFixe = telFixe;
	}

	public PersonnelAdministratifDto(String fonction, String telFixe,
			RoleDto role) {
		super();
		this.fonction = fonction;
		this.telFixe = telFixe;
		this.role = role;
	}

	public PersonnelAdministratifDto(String nom, String prenom, String cin,
			String adresse, String telephoneMobile, String email,
			String fonction, String telFixe) {
		super(nom, prenom, cin, adresse, telephoneMobile, email);
		this.fonction = fonction;
		this.telFixe = telFixe;
	}

	public long getPersonnelId() {
		return PersonnelId;
	}

	public void setPersonnelId(long personnelId) {
		PersonnelId = personnelId;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getTelFixe() {
		return telFixe;
	}

	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

	public DepartementDto getDepartementDto() {
		return departementDto;
	}

	public void setDepartementDto(DepartementDto departementDto) {
		this.departementDto = departementDto;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


}
