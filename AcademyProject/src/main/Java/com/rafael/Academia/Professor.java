package com.rafael.Academia;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Professor extends Funcionario{

	public Professor() {
		// TODO Auto-generated constructor stub
	}
	
	@ManyToMany(mappedBy="p")
	private List<Treino> treinos;
	
	public List<Treino> getTreinos() {
		return treinos;
	}

	
	
}
