package Model;

public class ModelLogin {
	
	private int id_login;
	private String tipo_login;
	
	
	
	
	
	public ModelLogin() {
		super();
	}
	
	
	
	public ModelLogin(int id_login, String tipo_login) {
		super();
		this.id_login = id_login;
		this.tipo_login = tipo_login;
	}



	public int getId_login() {
		return id_login;
	}
	public void setId_login(int id_login) {
		this.id_login = id_login;
	}
	public String getTipo_login() {
		return tipo_login;
	}
	public void setTipo_login(String tipo_login) {
		this.tipo_login = tipo_login;
	}
	
	
	
	
	

}
