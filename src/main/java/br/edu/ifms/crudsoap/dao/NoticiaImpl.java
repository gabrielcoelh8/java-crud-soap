package br.edu.ifms.crudsoap.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;

import br.edu.ifms.crudsoap.modelo.Noticia;

public class NoticiaImpl implements NoticiaDao {
	private Connection connection;
			
	public NoticiaImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public long adicionar(Noticia noticia) throws SQLException {
		Statement stmt = null;
		long id = 0;
		try {
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			String dataHora = sdf.format(noticia.getData());
			String sql = "insert into noticia (titulo, texto, data_publicacao)"
						+" values (\'"
						+ noticia.getTitulo() 
						+ "\',\'"
						+ noticia.getTexto()
						+ "\',\'"
						+ dataHora 
						+ "\') RETURNING ID";
			stmt = this.connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				id = rs.getLong(1);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return id;
	}

	@Override
	public Noticia alterar(Noticia noticia) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean apagar(long id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Noticia> listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Noticia ler(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
