package testehibernate;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.caelum.tarefas.Tarefa;

public class Testeentity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Mapea a unidade	
			EntityManagerFactory em = Persistence.createEntityManagerFactory("tarefas");
			//Cria a entidade
			EntityManager ent =  em.createEntityManager();
			
			//Gera a tarefa
			Tarefa tarefas = new Tarefa();
			tarefas.setDescricao("Tocar Jazz!");
			tarefas.setFinalizado(false);
			Calendar data = Calendar.getInstance();
			data.set(2012, 9, 12);
			tarefas.setDataFinalizacao(data);
			
			//abre a transação
			ent.getTransaction().begin();
			//Prepara a instrução
			ent.persist(tarefas);
			//executa a ação de persistencia
			ent.getTransaction().commit();
			//mostra o id
			System.out.println("Id da Tarefa: "+ tarefas.getId());
			//finaliza a entidade
			ent.close();
			
			
	}

}
