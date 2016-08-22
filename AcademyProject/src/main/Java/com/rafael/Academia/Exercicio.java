package com.rafael.Academia;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Exercicio {
	
	public Exercicio() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String tipo_exercicio;
	private int serie;
	private int repeticao;
	private int carga;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="treino_id")
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
	public String getTipo_exercicio() {
		return tipo_exercicio;
	}
	public void setTipo_exercicio(String tipo_exercicio) {
		this.tipo_exercicio = tipo_exercicio;
	}
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}
	public int getRepeticao() {
		return repeticao;
	}
	public void setRepeticao(int repeticao) {
		this.repeticao = repeticao;
	}
	public int getCarga() {
		return carga;
	}
	public void setCarga(int carga) {
		this.carga = carga;
	}
	
	
}
