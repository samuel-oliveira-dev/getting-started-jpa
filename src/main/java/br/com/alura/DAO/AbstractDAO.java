package br.com.alura.DAO;
import java.util.List;
import javax.persistence.EntityManager;
import br.com.alura.modelos.AbstractModel;

public abstract class AbstractDAO<T extends AbstractModel> {
	
	protected EntityManager entityManager;
	private Class<T> genericClass;
	
	protected AbstractDAO(EntityManager entityManager, Class<T> genericClass) {
		this.entityManager = entityManager;
		this.genericClass = genericClass;
		
	}
	
	protected void start() {
		this.entityManager.getTransaction().begin();
		
	}
	
	protected void end() {
		this.entityManager.getTransaction().commit();
		
	}
	
	public void cadastrar(AbstractModel model) {
		start();
		this.entityManager.persist(model);
		end();
	}
	
	public T obterPorId(long id) {
		T model = this.entityManager.find(genericClass, id);
		return model;
	}
	
	
	public void atualizar(T model) {
		start();
		T merged = this.entityManager.merge(model);
		merged = model;
		end();
	}
	
	public void remover(T model) {
		start();
		model = this.entityManager.merge(model);
		this.entityManager.remove(model);
		end();
	}
	
	public List<T> obterTodos(){
		StringBuilder sb = new StringBuilder();
		String className = genericClass.getName();
		sb.append("SELECT o FROM ")
		  .append(className + " o");
		return this.entityManager.createQuery(sb.toString(), genericClass)
				.getResultList();
		
	}
	
	
	
	

}
