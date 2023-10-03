package br.edu.ifms.crudsoap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
			String sql = "insert into noticia (titulo, texto, data)"
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
		PreparedStatement stmt = null;
		try {
			String sql = "update noticia set titulo = ? , texto = ? , data = ? "
					   + "where id = ? ;";
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, noticia.getTitulo());		
			stmt.setString(2, noticia.getTexto());
			stmt.setDate(3, new Date(noticia.getData().getTime()));
			stmt.setLong(4, noticia.getId());
			stmt.execute();			
			return ler(noticia.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			stmt.close();
		}
		return null;

	}

	@Override
	public boolean apagar(long id) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "delete from noticia where id = ? ;";
			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			stmt.close();
		}
		return false;
	}

	@Override
	public List<Noticia> listar() throws SQLException {
		ArrayList<Noticia> noticias = new ArrayList<Noticia>();
		Statement stmt = null;
		try {
			String sql = "select * from noticia";
			stmt = this.connection.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);		    
		    while (rs.next()) {
	            Noticia not = new Noticia();
	            not.setId(rs.getLong("id"));
	            not.setTitulo(rs.getString("titulo"));
	            not.setTexto(rs.getString("texto"));
	            not.setData(new java.util.Date(rs.getDate("data").getTime()));
	            noticias.add(not);
	        }			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			stmt.close();
		}
		return noticias;
	}

	@Override
	public Noticia ler(long id) throws SQLException {
		Statement stmt = null;		 
        Noticia not = null;        
        try {
        	String sql = "select * from noticia where id = " + id;
        	stmt = this.connection.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);		    
		    if (rs.next()) {
	            not = new Noticia();
                not.setId(rs.getLong("id"));
                not.setTitulo(rs.getString("titulo"));
                not.setTexto(rs.getString("texto"));
                not.setData(new java.util.Date(rs.getDate("data").getTime()));
	        }			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			stmt.close();
		}       
        return not;
	}

}
