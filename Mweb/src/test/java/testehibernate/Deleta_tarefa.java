package testehibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.caelum.tarefas.Tarefa;
import com.caelum.tarefas.TarefasDao;

public class Deleta_tarefa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("tarefas");
		EntityManager en = fac.createEntityManager();
		
		Tarefa encontrada = en.find(Tarefa.class, 8L);
		System.out.println(encontrada.getDescricao());
		en.getTransaction().begin();
		en.remove(encontrada);
		en.getTransaction().commit();
		en.close();
	}

}
