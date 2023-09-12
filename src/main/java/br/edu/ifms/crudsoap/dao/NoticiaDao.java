package br.edu.ifms.crudsoap.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifms.crudsoap.modelo.Noticia;

public interface NoticiaDao {
	public long adicionar(Noticia noticia) throws SQLException;
	public Noticia alterar(Noticia noticia) throws SQLException;
	public boolean apagar(long id) throws SQLException;
	public List<Noticia> listar() throws SQLException;
	public Noticia ler(long id) throws SQLException;
}