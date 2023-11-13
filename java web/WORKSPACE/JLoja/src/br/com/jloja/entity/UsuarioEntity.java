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
@Table(name = "usuario")
@NamedQueries({
		@NamedQuery(name = "UsuarioEntity.buscarPorCodigo", query = "SELECT usu FROM UsuarioEntity usu WHERE usu.idusuario = :codigo"),
		@NamedQuery(name = "UsuarioEntity.listar", query = "SELECT usu FROM UsuarioEntity usu"),
		@NamedQuery(name = "UsuarioEntity.login", query = "SELECT usu FROM UsuarioEntity usu " + "WHERE usu.login = :login AND usu.senha = :senha")})
public class UsuarioEntity {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long idusuario;
	@Column(length = 60)
	private String nome;
	@Column(length = 20)
	private String login;
	@Column(length = 50)
	private String senha;
	@Column(length = 1)
	private char situacao;

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public char getSituacao() {
		return situacao;
	}

	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}

}
