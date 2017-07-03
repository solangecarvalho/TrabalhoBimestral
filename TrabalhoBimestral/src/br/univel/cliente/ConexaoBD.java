package br.univel.cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

	private static ConexaoBD self;

	private Connection con;

	private ConexaoBD() {
		try {
			Class.forName("org.postgresql.Driver");
			this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cliente",
													"postgres", "1234");

			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						ConexaoBD.this.con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public final static synchronized ConexaoBD getInstance() {
		if (self == null) {
			self = new ConexaoBD();
		}
		return self;
	}

	public Connection getConnection() {
		return this.con;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Só pode haver um!");
	}

}


