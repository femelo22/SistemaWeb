package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.ConectionFactory;

public class FornecedoresDAO {

	// método INSERIR fornecedores
	public void insertProvider(Fornecedores fornecedor) {
		try {
			String sql = "INSERT INTO fornecedor VALUES (?,?,?,?)";

			Connection conexao = ConectionFactory.getConection();

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, fornecedor.getCodigoFornecedor());
			stmt.setString(2, fornecedor.getNome());
			stmt.setString(3, fornecedor.getEmail());
			stmt.setString(4, fornecedor.getTelefone());

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			System.out.println("erro:" + e);
		}
	}

	// método para DELETAR fornecedor
	public void deleteProvider(Fornecedores fornecedor) {
		try {
			String sql = "DELETE FROM fornecedor WHERE idFornecedor = ?";

			Connection conexao = ConectionFactory.getConection();

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, fornecedor.getCodigoFornecedor());

			stmt.execute();

		} catch (Exception e) {
			System.out.println("erro: " + e);
		}
	}

	// método para EDITAR informações do fornecedor
	public void editProvider(Fornecedores fornecedor) {
		try {
			String sql = "UPDATE fornecedor SET nome=?, email=?, telefone=? WHERE idFornecedor = ?";

			Connection conexao = ConectionFactory.getConection();

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getEmail());
			stmt.setString(3, fornecedor.getTelefone());

			stmt.setInt(4, fornecedor.getCodigoFornecedor());

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			System.out.println("erro: " + e);
		}
	}

	//método para LISTAR TODOS os objetos de fornecedores
	public Fornecedores getProviderById(Fornecedores fornecedores) throws SQLException {

		String sql = "SELECT * FROM fornecedor WHERE idFornecedor = ?";

		Connection conexao = ConectionFactory.getConection();

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, fornecedores.getCodigoFornecedor());

		ResultSet rs = stmt.executeQuery();

		Fornecedores f = null;

		 if (rs.next()) {
			f = new Fornecedores();

			f.setCodigoFornecedor(rs.getInt("idFornecedor"));
			f.setNome(rs.getString("nome"));
			f.setEmail(rs.getString("email"));
			f.setTelefone(rs.getString("telefone"));
		}
		return f;
	}

	
	
	public ArrayList<Fornecedores> listProviders() throws SQLException{
		
		String sql = "SELECT * FROM fornecedor ORDER BY idFornecedor ASC";

		Connection conexao = ConectionFactory.getConection();

		PreparedStatement stmt = conexao.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();
		
		//instanciando o arrayList
		ArrayList<Fornecedores> listProviders = new ArrayList<Fornecedores>();
		
		while(rs.next()) {
			Fornecedores f = new Fornecedores();
			f.setCodigoFornecedor(rs.getInt("idFornecedor"));
			f.setNome(rs.getString("nome"));
			f.setEmail(rs.getString("email"));
			f.setTelefone(rs.getString("telefone"));
			
			listProviders.add(f);
		}	
		return listProviders;	
	}
	
	public static void main(String[] args) {
		

		FornecedoresDAO fdao = new FornecedoresDAO();

		try {
			
			ArrayList<Fornecedores> lista = fdao.listProviders();
			
			for(Fornecedores fo: lista) {
			System.out.println("fornecedor: " + fo);
			}
			
			
		} catch (Exception e) {

			System.out.println("erro ao buscar" + e);
		}

	}

}
