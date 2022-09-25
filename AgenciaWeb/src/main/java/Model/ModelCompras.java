package Model;

import Model.ModelClientes;
import Model.ModelDestino;

@SuppressWarnings("unused")
public class ModelCompras {

	private double valor_total;
	private String forma_pagamento;
	private double valor;
	private String data_compras;
	private int id_compras;
	private ModelClientes clientes;
	private ModelDestino destino;
	
	
	
	public ModelCompras() {
		super();
	}
	
	
	public ModelCompras(double valor_total, String forma_pagamento, double valor, String data_compras, int id_compras,
			ModelClientes clientes, ModelDestino destino) {
		super();
		this.valor_total = valor_total;
		this.forma_pagamento = forma_pagamento;
		this.valor = valor;
		this.data_compras = data_compras;
		this.id_compras = id_compras;
		this.clientes = clientes;
		this.destino = destino;
	}






	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	public String getForma_pagamento() {
		return forma_pagamento;
	}
	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getData_compras() {
		return data_compras;
	}
	public void setData_compras(String data_compras) {
		this.data_compras = data_compras;
	}
	public int getId_compras() {
		return id_compras;
	}
	public void setId_compras(int id_compras) {
		this.id_compras = id_compras;
	}
	public ModelClientes getClientes() {
		return clientes;
	}
	public void setClientes(ModelClientes clientes) {
		this.clientes = clientes;
	}
	public ModelDestino getDestino() {
		return destino;
	}
	public void setDestino(ModelDestino destino) {
		this.destino = destino;
	}
	
	
	
}
