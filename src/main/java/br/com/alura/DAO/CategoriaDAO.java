package br.com.alura.DAO;

import br.com.alura.Util.JPAUtil;
import br.com.alura.modelos.Categoria;

public class CategoriaDAO extends AbstractDAO<Categoria>{
	
	public CategoriaDAO() {
		super(JPAUtil.getEntityManager(), Categoria.class);
	}



}
