package br.edu.ifms.crudsoap.servico;

import java.util.List;

import br.edu.ifms.crudsoap.modelo.Noticia;
import jakarta.jws.WebService;

@WebService(endpointInterface = "br.edu.ifms.crudsoap.servico.NoticiaSEI")
public class NoticiaSIB implements NoticiaSEI {

	@Override
	public long adicionar(Noticia noticia) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Noticia alterar(Noticia noticia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean apagar(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Noticia> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Noticia ler(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
