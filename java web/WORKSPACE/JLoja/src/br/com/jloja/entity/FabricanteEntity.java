package br.com.jloja.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="fabricante")
public class FabricanteEntity {
	
	@Id
	@Column
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long idfabricante;
	@Column(length = 60, nullable=false)
	private String descricao;
	
	
	public Long getIdfabricante() {
		return idfabricante;
	}
	public void setIdfabricante(Long idfabricante) {
		this.idfabricante = idfabricante;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
