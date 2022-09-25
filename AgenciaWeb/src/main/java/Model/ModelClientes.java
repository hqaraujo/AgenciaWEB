package Model;

import Model.ModelLogin;

@SuppressWarnings("unused")
public class ModelClientes {

	private int id_cliente;
	private String cpf_cliente;
	private String nome_cliente;
	private String email_cliente;
	private Model.ModelLogin login;
	
	
	public ModelClientes() {
		super();
	}
	
	
	public ModelClientes(int id_cliente, String cpf_cliente, String nome_cliente, String email_cliente,
			ModelLogin login) {
		super();
		this.id_cliente = id_cliente;
		this.cpf_cliente = cpf_cliente;
		this.nome_cliente = nome_cliente;
		this.email_cliente = email_cliente;
		this.login = login;
	}











	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getCpf_cliente() {
		return cpf_cliente;
	}
	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public String getEmail_cliente() {
		return email_cliente;
	}
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	public Model.ModelLogin getLogin() {
		return login;
	}
	public void setLogin(Model.ModelLogin login) {
		this.login = login;
	}
	
	
	
	
}
