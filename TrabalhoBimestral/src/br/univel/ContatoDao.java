package br.univel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDao {
	
	private static final String SQL_BUSCA_TODOS = "SELECT * FROM CONTATO";

	public List<Produto> getTodos() {
		
		Connection con = ConexaoBD
				.getInstance()
				.getConnection();
		
		List<Produto> lista = new ArrayList<>();
		try (PreparedStatement ps = con
					.prepareStatement(SQL_BUSCA_TODOS);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getLong(1));
				p.setDescricao(rs.getString(2));
				p.setValorDolar(rs.getBigDecimal(3));
				lista.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void insere(Produto p) {
		
	}
	
	public void atualiza(int id, Produto p) {
		
	}
	
	public void exclui(int id) {
		
	}
	
}
