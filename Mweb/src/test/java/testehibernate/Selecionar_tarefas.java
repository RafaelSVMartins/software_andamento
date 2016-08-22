package testehibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.caelum.tarefas.Tarefa;

public class Selecionar_tarefas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("tarefas");
		EntityManager en = fac.createEntityManager();
		
		Query query = en.createQuery("select t from Tarefa as t where t.finalizado= :paramfinalizado");
		query.setParameter("paramfinalizado", false);
		
		List<Tarefa> lista = query.getResultList();
		
		for(Tarefa ta : lista) {
			System.out.println("Descrição: " + ta.getDescricao());
		}
		en.close();

	}

}
