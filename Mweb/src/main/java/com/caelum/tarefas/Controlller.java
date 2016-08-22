package com.caelum.tarefas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@Transactional
public class Controlller {
	@Autowired
	private JpaTarefaDao dao;
	
	@RequestMapping("novaTarefa") 
	public String form() {
	return "tarefas/formulario";	
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(Tarefa tarefa, HttpServletRequest req) {
		
		String data = req.getParameter("finalizado");
		Date d;
		Calendar da = Calendar.getInstance();
		try {
			d = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			da.setTime(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tarefa.setDataFinalizacao(da);
		dao.adiciona(tarefa);
		return "tarefas/adicionada";
		
	}
	@RequestMapping("olaMundoSpring")
	public String alomundo() {
		System.out.println("Alo mundo!!!");
		return "ok";
	}
	
	@RequestMapping("ListaTarefas")
	public String lista(Model modelo) {
		
		modelo.addAttribute("tarefas", dao.listatarefas());
		return "tarefas/finalizada";
	}
	
	@RequestMapping("RemoveTarefa")
	public String remove(Tarefa tarefa) {
		
		dao.exclui(tarefa);
		return "forward:ListaTarefas";
	}
	
	@RequestMapping("MostraTarefa")
	public String mostra(Long id, Model modelo) {
		
		modelo.addAttribute("tarefa", dao.buscaporid(id));
		return "tarefas/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		
		dao.alterar(tarefa);
		return "forward:ListaTarefas";
	}
	
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id, HttpServletResponse response) {
	
	dao.finaliza(id);
	response.setStatus(200);
	}
}
