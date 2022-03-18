package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	// parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/gameBoy";
	private String user = "root";
	private String password = "d1d21528";

	// metodo de conexao (retorna a conexao)
	public Connection conectar() {
               //criando objeto para estabelecer a conexão
		   Connection con = null;
		 //tratamento de excecoes
			try {
				// uso do driver para conectar com o banco(estabeler a conexao)
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
				return con;
			} catch (Exception e) {
				 //exibe a excecao
				System.out.println(e);
				return null;
		}
   }
}
