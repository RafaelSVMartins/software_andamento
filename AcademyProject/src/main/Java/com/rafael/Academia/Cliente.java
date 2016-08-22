package com.rafael.Academia;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	
	public Cliente() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String endereco;
	private String planodematricula;
	private Calendar datadenascimento;
	@OneToOne()
	private Treino tr;
	
	public Treino getTr() {
		return tr;
	}
	public void setTr(Treino tr) {
		this.tr = tr;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getPlanodematricula() {
		return planodematricula;
	}
	public void setPlanodematricula(String planodematricula) {
		this.planodematricula = planodematricula;
	}
	public Calendar getDatadenascimento() {
		return datadenascimento;
	}
	public void setDatadenascimento(Calendar datadenascimento) {
		this.datadenascimento = datadenascimento;
	}
	
	
}
