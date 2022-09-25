package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conection.ConnectionMySQL;
import Model.ModelDestino;
import Model.ModelPacotes;

public class DAODestino {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(ModelDestino destino) {
		String sql = "INSERT INTO destino (pais, cidade, id_pacote) values(?,?,?)";
		
		
		try {
			// Cria uma conexao com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setNString(1, destino.getPais());
			pstm.setString(2, destino.getCidade());
			pstm.setInt(3,destino.getPacotes().getId_pacote());
			
		
			
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
	public List<ModelDestino> getDestino() {
		String sql = "select * from destino;";

		List<ModelDestino> lista = new ArrayList<ModelDestino>();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				ModelDestino destino = new ModelDestino();

				destino.setId_destino(rset.getInt("id_destino"));

				destino.setPais(rset.getString("Pais"));
				
				destino.setCidade(rset.getString("Cidade"));
				
				
				ModelPacotes pacotes = new ModelPacotes();
				pacotes.setId_pacote(rset.getInt("id_pacote"));

			
				lista.add(destino);

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

		return lista;
	}
	// Metodo pra atualizar

	public void update(ModelDestino destino) {
		String sql = "UPDATE destino set pais = ?" + " cidade = ?" +
				 "WHERE id_destino = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getPais());
			pstm.setString(2, destino.getCidade());
			pstm.setInt(3, destino.getId_destino());


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
		String sql = "DELETE FROM destino WHERE id_destino = ?";

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

	public ModelDestino getDestinoById(int id) {
		String sql = "SELECT * FROM destino WHERE id_destino = ?;";

		ModelDestino destino = new ModelDestino();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			destino.setId_destino(rset.getInt("id_destino"));

			destino.setPais(rset.getString("pais"));
			
			destino.setCidade(rset.getString("cidade"));


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

		return destino;
	}

	
}





