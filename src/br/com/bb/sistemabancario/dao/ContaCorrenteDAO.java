package br.com.bb.sistemabancario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.bb.sistemabancario.jdbc.ConnectionFactory;
import br.com.bb.sistemabancario.modelo.ContaCorrente;

public class ContaCorrenteDAO {
	private Connection connection;
	public ContaCorrenteDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insere(ContaCorrente cc) {
		String sql = "insert into \"ContaCorrente\" (numero, agencia, descricao, ativa, variacao) values (?,?,?,?, ?)";
		try { // prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta valores
			stmt.setString(1, cc.getNumero());
			stmt.setString(2, cc.getAgencia());
			stmt.setString(3, cc.getDescricao());
			stmt.setBoolean(4, true);
			stmt.setInt(5, cc.getVariacao());
			//executa
			stmt.execute();
			// fecha statement
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

