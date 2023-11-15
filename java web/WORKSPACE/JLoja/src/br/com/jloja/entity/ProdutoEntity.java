package br.com.jloja.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
@NamedQueries({
		@NamedQuery(name = "ProdutoEntity.buscarPorCodigo", query = "SELECT pro FROM ProdutoEntity pro WHERE pro.idproduto = :codigo"),
		@NamedQuery(name = "PrutoEntity.listar", query = "SELECT pro FROM ProdutoEntity pro") })
public class ProdutoEntity {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long idproduto;
	@Column(length = 60)
	private String descricao;
	@Column(precision = 7, scale = 2)
	private BigDecimal valor;
	@Column
	private Long quantidade;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fabricante", referencedColumnName = "idfabricante", nullable = false)
	private FabricanteEntity fabricante_idfabricante;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Usuario", referencedColumnName = "idusuario", nullable = false)
	private UsuarioEntity usuario_idusuario;

	public Long getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(Long idproduto) {
		this.idproduto = idproduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public FabricanteEntity getFabricante_idfabricante() {
		return fabricante_idfabricante;
	}

	public void setFabricante_idfabricante(FabricanteEntity fabricante_idfabricante) {
		this.fabricante_idfabricante = fabricante_idfabricante;
	}

	public UsuarioEntity getUsuario_idusuario() {
		return usuario_idusuario;
	}

	public void setUsuario_idusuario(UsuarioEntity usuario_idusuario) {
		this.usuario_idusuario = usuario_idusuario;
	}

}
