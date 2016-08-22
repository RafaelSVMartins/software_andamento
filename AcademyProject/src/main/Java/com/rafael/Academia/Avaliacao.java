package com.rafael.Academia;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Avaliacao {

	public Avaliacao() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Nome_Aluno;
	private String Nome_Professor;
	private Calendar Data_Avaliacao;
	
	@OneToOne()
	private Cliente aluno;
	public String getNome_Aluno() {
		return Nome_Aluno;
	}
	public void setNome_Aluno(String nome_Aluno) {
		Nome_Aluno = nome_Aluno;
	}
	public String getNome_Professor() {
		return Nome_Professor;
	}
	public void setNome_Professor(String nome_Professor) {
		Nome_Professor = nome_Professor;
	}
	public Calendar getData_Avaliacao() {
		return Data_Avaliacao;
	}
	public void setData_Avaliacao(Calendar data_Avaliacao) {
		Data_Avaliacao = data_Avaliacao;
	}
	
}
