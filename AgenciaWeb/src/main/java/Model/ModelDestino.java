package Model;


import Model.ModelPacotes;
@SuppressWarnings("unused")
public class ModelDestino {
	
	private int id_destino;
	private String pais;
	private String cidade;
	private ModelPacotes pacotes;
	
	
	public ModelDestino() {
		super();
	}
	
	
	public ModelDestino(int id_destino, String pais, String cidade, ModelPacotes pacotes) {
		super();
		this.id_destino = id_destino;
		this.pais = pais;
		this.cidade = cidade;
		this.pacotes = pacotes;
	}


	public int getId_destino() {
		return id_destino;
	}
	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public ModelPacotes getPacotes() {
		return pacotes;
	}
	public void setPacotes(ModelPacotes pacotes) {
		this.pacotes = pacotes;
	}


	public void setPacotes(String parameter) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
