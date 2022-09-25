package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conection.ConnectionMySQL;
import Model.ModelClientes;
import Model.ModelLogin;

public class DAOClientes {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(ModelClientes cliente) {
		String sql = "INSERT INTO cliente (cpf_cliente, nome_cliente, email_cliente, id_login) values(?,?,?,?)";
		
		
		try {
			// Cria uma conexao com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, cliente.getCpf_cliente());
			pstm.setString(2, cliente.getNome_cliente());
			pstm.setString(3, cliente.getEmail_cliente());
			
			pstm.setInt(4,cliente.getLogin().getId_login());
			
			

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
	public List<ModelClientes> getClientes() {
		String sql = "select * from clientes;";

		List<ModelClientes> clientes = new ArrayList<ModelClientes>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				
				ModelClientes cliente = new ModelClientes();
				ModelLogin login =new ModelLogin();

				cliente.setId_cliente(rset.getInt("id_cliente"));

				cliente.setCpf_cliente(rset.getString("cpf_cliente"));
				
				cliente.setNome_cliente(rset.getString("nome_cliente"));

				cliente.setEmail_cliente(rset.getString("email_cliente"));
				
				login.setId_login(rset.getInt("id_login"));

				cliente.setLogin(login);
				
				clientes.add(cliente);

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

		return clientes;
	}
	// Metodo pra atualizar

	public void update(ModelClientes clientes) {
		String sql = "UPDATE clientes set cpf_cliente = ? nome_cliente = ? email_cliente = ?  where id_cliente = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, clientes.getLogin().getId_login());

			pstm.setString(2, clientes.getCpf_cliente());
			
			pstm.setString(3, clientes.getNome_cliente());
			
			pstm.setString(4, clientes.getEmail_cliente());
			
			pstm.setInt(5, clientes.getId_cliente());

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
		String sql = "DELETE FROM clientes WHERE id_cliente = ?";

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

	public ModelClientes getClientesById(int id) {
		String sql = "SELECT * FROM clientes WHERE id_cliente = ?;";

		ModelClientes cliente = new ModelClientes();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(id, id);

			rset = pstm.executeQuery();

			rset.next();

			cliente.setId_cliente(rset.getInt("id_cliente"));

			cliente.setCpf_cliente(rset.getString("cpf_cliente"));
			
			cliente.setNome_cliente(rset.getString("nome_cliente"));
			
			cliente.setEmail_cliente(rset.getString("email_cliente"));
			
			

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

		return cliente;
	}

}



