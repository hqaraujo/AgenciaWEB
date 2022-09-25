package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Conection.ConnectionMySQL;
import Model.ModelClientes;
import Model.ModelCompras;
import Model.ModelDestino;

public class DAOCompras {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	
	public void save(ModelCompras compras) {
		String sql = "INSERT INTO compras (valor_total, forma_pagamento,"
				+ " valor, data_compras, id_cliente, id_destino) values(?,?,?,?,?,?)";
		
		
		try {
			// Cria uma conexao com o banco
			
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			
			pstm.setDouble(1, compras.getValor_total());
			pstm.setString(2, compras.getForma_pagamento());
			pstm.setDouble(3, compras.getValor());
			SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy");
            pstm.setDate(4, new Date (formatter.parse(compras.getData_compras()).getTime()));
            
            pstm.setInt(5,compras.getClientes().getId_cliente());
            pstm.setInt(6,compras.getDestino().getId_destino());
            
            
          
            
			// Executar a sql para inser��o dos dados
            
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// Metodo para Ler
	
	public List<ModelCompras> getCompras1() {
		String sql = "select * from compras;";

		List<ModelCompras> compras = new ArrayList<ModelCompras>();

		// Classe que vai recuperar os dados do banco de dados
		
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				ModelCompras compras1 = new ModelCompras();
				ModelDestino destino = new ModelDestino();
				ModelClientes clientes = new ModelClientes();
				
				compras1.setId_compras(rset.getInt("id_compras"));

				compras1.setValor_total(rset.getDouble("valor_total"));

				compras1.setForma_pagamento(rset.getString("forma_pagamento"));

				compras1.setValor(rset.getDouble("valor"));

				SimpleDateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy");
                compras1.setData_compras(dateFormat.format(rset.getDate("data_compras")));
				clientes.setId_cliente(rset.getInt("id_cliente"));
				destino.setId_destino(rset.getInt("id_destino"));
				
				
				compras.add(compras1);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return compras;
	}
	// Metodo pra atualizar

	public void update(ModelCompras compras) {
		String sql = "UPDATE compras set valor_total = ?" + " forma_pagamento = ?" + " valor = ?" + "data_compras = ?"
				+ "where id_compras = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setDouble(1, compras.getValor_total());

			pstm.setString(2, compras.getForma_pagamento());

			pstm.setDouble(3, compras.getValor());

			SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy");
            pstm.setDate(4, new Date(formatter.parse(compras.getData_compras()).getTime()));

			pstm.setInt(5, compras.getId_compras());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Metodo para deletar
	
	public void deleteById(int id) {
		String sql = "DELETE FROM compras WHERE id_compras = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ModelCompras getComprasById(int id) {
		String sql = "SELECT * FROM compras WHERE id_compras = ?;";

		ModelCompras compras = new ModelCompras();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			compras.setId_compras(rset.getInt("id_compras"));

			SimpleDateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy");
            compras.setData_compras(dateFormat.format(rset.getDate("data_compras")));


			compras.setValor(rset.getDouble("valor"));

			compras.setValor_total(rset.getDouble("valor_total"));

			compras.setForma_pagamento(rset.getString("forma_pagamento"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return compras;
	}

	

}



