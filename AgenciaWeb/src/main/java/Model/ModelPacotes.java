package Model;

public class ModelPacotes {
	
	private int id_pacote;
	private String origem;
	private double promocao;
	
	

	public ModelPacotes() {
		super();
	}
	
	
	public ModelPacotes(int id_pacote, String origem, double promocao) {
		super();
		this.id_pacote = id_pacote;
		this.origem = origem;
		this.promocao = promocao;
	}


	public int getId_pacote() {
		return id_pacote;
	}
	public void setId_pacote(int id_pacote) {
		this.id_pacote = id_pacote;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public double getPromocao() {
		return promocao;
	}
	public void setPromocao(double promocao) {
		this.promocao = promocao;
	}
	
	
	
	

}
