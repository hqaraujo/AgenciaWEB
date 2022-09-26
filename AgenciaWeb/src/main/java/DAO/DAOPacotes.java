package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conection.ConnectionMySQL;
import Model.ModelPacotes;

public class DAOPacotes {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(ModelPacotes pacote) {
		String sql = "INSERT INTO pacotespromocionais (origem, promocao) values (?, ?)";

		try {
			// Cria uma conexao com o banco
			conn = ConnectionMySQL.createConnectionMySQL();
			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, pacote.getOrigem());
			pstm.setDouble(2, pacote.getPromocao());

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
	public  List<ModelPacotes> getPacotespromocionais() {
		String sql = "select * from pacotes;";

		List<ModelPacotes> listaPacotes = new ArrayList<ModelPacotes>();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				ModelPacotes pacote = new ModelPacotes();

				pacote.setId_pacote(rset.getInt("id_pacote"));
				pacote.setOrigem(rset.getString("origem"));
				pacote.setPromocao(rset.getDouble("promocao"));

				listaPacotes.add(pacote);
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
		return listaPacotes;
	}

	// UPDATE
	public void update(ModelPacotes pacote) {
		String sql = "UPDATE pacotespromocionais SET origem= ?, promocao = ?  WHERE id_pacote = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pacote.getOrigem());
			pstm.setDouble(2, pacote.getPromocao());
			pstm.setInt(3, pacote.getId_pacote());

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

	// DELETE
	public void deleteById(int id) {
		String sql = "DELETE FROM pacotespromocionais WHERE id_pacote = ?";

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

	// BUSCAR POR ID
	public ModelPacotes getPacotesById(int id) {
		String sql = "select * from pacotespromocionais WHERE id_pacote = ?";

		ModelPacotes pacote = new ModelPacotes();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();

			pacote.setId_pacote(rset.getInt("id_pacote"));
			pacote.setOrigem(rset.getString("origem"));
			pacote.setPromocao(rset.getDouble("promocao"));

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
		return pacote;
	}

}



