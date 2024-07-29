package br.com.alura.DAO;

import br.com.alura.Util.JPAUtil;
import br.com.alura.modelos.Cliente;

public class ClienteDAO extends AbstractDAO<Cliente>{
	
	public ClienteDAO() {
		super(JPAUtil.getEntityManager(), Cliente.class);
	}
}
