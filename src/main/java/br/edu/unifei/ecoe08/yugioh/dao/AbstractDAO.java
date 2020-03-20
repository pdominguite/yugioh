package br.edu.unifei.ecoe08.yugioh.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import lombok.Data;

@Data
public abstract class AbstractDAO <T, K> {
	
	private EntityManager entityManager = DataSource.createEntityManager();
	private Class<T> clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	public void create(T obj) {
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
	}
	public void update(T obj) {
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
	}
	public void delete (T obj) {
		entityManager.getTransaction().begin();
		entityManager.remove(obj);
		entityManager.getTransaction().commit();
	}
	public void deleteKey (K key) {
		T obj = this.find(key);
		this.delete(obj);
	}
	public T find(K key) {
		return (T)entityManager.find(clazz, key);
	}
	public List<T> findAll(){
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}
	public long getCount() {
		return (Long)entityManager.createQuery("select count (*) from " + clazz.getName()).getSingleResult();
	}

}
