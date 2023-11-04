package br.com.jloja.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fabricante")
@NamedQueries({
		@NamedQuery(name = "FabricanteEntity.buscarPorCodigo", query = "SELECT fab FROM FabricanteEntity fab WHERE fab.idfabricante = :codigo"),
		@NamedQuery(name = "FabricanteEntity.listar", query = "SELECT fab FROM FabricanteEntity fab") })
public class FabricanteEntity {

	@Id
	@Column
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long idfabricante;
	@Column(length = 60, nullable = false)
	private String descricao;

	public FabricanteEntity() {
	}

	public FabricanteEntity(Long idfabricante, String descricao) {
		this.idfabricante = idfabricante;
		this.descricao = descricao;
	}

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
