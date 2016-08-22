package com.rafael.Academia;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Treino {

	public Treino() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy="tr")
	private List<Exercicio> listadeexercicio;
	private	String Lista_infoadicionais;
	private Alongamentos al;
	@ManyToMany()
	@JoinTable(name="Treino_Professor", 
	joinColumns = @JoinColumn(name="Treino_id"),
	inverseJoinColumns= @JoinColumn(name="Professor_id"))
	private List<Funcionario> p;
	
	public List<Funcionario> getP() {
		return p;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Exercicio> getListadeexercicio() {
		return listadeexercicio;
	}
	public void setListadeexercicio(List<Exercicio> listadeexercicio) {
		this.listadeexercicio = listadeexercicio;
	}
	public String getLista_infoadicionais() {
		return Lista_infoadicionais;
	}
	public void setLista_infoadicionais(String lista_infoadicionais) {
		Lista_infoadicionais = lista_infoadicionais;
	}
	public Alongamentos getAl() {
		return al;
	}
	public void setAl(Alongamentos al) {
		this.al = al;
	}
	
}
