package dao;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class AdicionarDiretorDAO {
	
	private Connection conexao;
	
	public AdicionarDiretorDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean adicionarDiretor(String idfilme, String nome, String biografia, Date nasc){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try{
			
			ps = conexao.prepareStatement("insert into diretor (idfilme, nome, biografia, datanasc)"
					+ "values (?, ?, ?, ?)");
			ps.setInt(1, Integer.parseInt(idfilme));
			ps.setString(2, nome);
			ps.setString(3, biografia);
			ps.setDate(4, nasc);
			ps.executeUpdate();
			ps.close();
			resultado = true;
		}catch(Exception e){
			
		}
		
		return resultado;
	}

}
