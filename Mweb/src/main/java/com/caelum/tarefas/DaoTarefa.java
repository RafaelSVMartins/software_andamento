package com.caelum.tarefas;

import java.util.List;

public interface DaoTarefa {
	public void adiciona(Tarefa tarefa);
	public void exclui(Tarefa tarefa);
	public void alterar(Tarefa tarefa);
	public List<Tarefa>listatarefas();
	public Tarefa buscaporid(Long id);
	public void finaliza(Long id);
}
