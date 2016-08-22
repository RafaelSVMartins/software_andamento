package com.caelum.tarefas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class JpaTarefaDao implements DaoTarefa {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public void adiciona(Tarefa tarefa) {
		// TODO Auto-generated method stub
		this.manager.persist(tarefa);
	}

	@Override
	public void exclui(Tarefa tarefa) {
		// TODO Auto-generated method stub
		Tarefa tr = this.buscaporid(tarefa.getId());
		this.manager.remove(tr);
	}

	@Override
	public void alterar(Tarefa tarefa) {
		// TODO Auto-generated method stub
			this.manager.merge(tarefa);
	}

	@Override
	public List<Tarefa> listatarefas() {
		// TODO Auto-generated method stub
		return this.manager.createQuery("select t from Tarefa t").getResultList();
	}

	@Override
	public Tarefa buscaporid(Long id) {
		// TODO Auto-generated method stub
		return this.manager.find(Tarefa.class, id);
	}

	@Override
	public void finaliza(Long id) {
		// TODO Auto-generated method stub
		Tarefa t = this.buscaporid(id);
		t.setFinalizado(true);
		this.manager.merge(t);
	}

}
