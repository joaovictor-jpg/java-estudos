package br.com.jloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jloja.DAO.ProdutoDAO;
import br.com.jloja.entity.FabricanteEntity;
import br.com.jloja.entity.ProdutoEntity;
import br.com.jloja.entity.UsuarioEntity;
import br.com.jloja.util.MsgUtil;

@ManagedBean(name = "produtoMB")
@SessionScoped
public class ProdutoBean {

	private List<ProdutoEntity> listarProdutos;
	private List<ProdutoEntity> listarProdutosFiltrados;
	private ProdutoEntity produtoEntity;
	private Long codigo;

	public List<ProdutoEntity> getListarProdutos() {
		return listarProdutos;
	}

	public void setListarProdutos(List<ProdutoEntity> listarProdutos) {
		this.listarProdutos = listarProdutos;
	}

	public List<ProdutoEntity> getListarProdutosFiltrados() {
		return listarProdutosFiltrados;
	}

	public void setListarProdutosFiltrados(List<ProdutoEntity> listarProdutosFiltrados) {
		this.listarProdutosFiltrados = listarProdutosFiltrados;
	}

	public ProdutoEntity getProdutoEntity() {
		return produtoEntity;
	}

	public void setProdutoEntity(ProdutoEntity produtoEntity) {
		this.produtoEntity = produtoEntity;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public ProdutoBean() {
		this.produtoEntity = new ProdutoEntity();
	}

	public void listarProduto() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			listarProdutos = dao.listar();
		} catch (Exception e) {
			throw e;
		}
	}

	public void adicionarProduto(UsuarioEntity usuario, FabricanteEntity fabricante) {
		try {
			produtoEntity.setUsuario_idusuario(usuario);
			produtoEntity.setFabricante_idfabricante(fabricante);

			ProdutoDAO dao = new ProdutoDAO();
			dao.adicionar(produtoEntity);
			produtoEntity = new ProdutoEntity();

			MsgUtil.msgInfo("Produto gravado com sucesso!");
		} catch (Exception e) {
			MsgUtil.msgError("Erro ao gravar produto: " + e.getMessage());
		}
	}

	public void buscarProdudtoCodigo(Long codigo) {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			produtoEntity = dao.buscarProdutoPorCodigo(codigo);
		} catch (Exception e) {
			throw e;
		}
	}

	public void editarProduto(FabricanteEntity fab) {
		try {
			produtoEntity.setFabricante_idfabricante(fab);
			ProdutoDAO dao = new ProdutoDAO();

			dao.adicionar(produtoEntity);

			produtoEntity = new ProdutoEntity();
			MsgUtil.msgInfo("Produto editado com sucesso!");
		} catch (Exception e) {
			MsgUtil.msgError("Erro ao tentar editar um produto: " + e.getMessage());
		}
	}

	public void excluirProduto() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produtoEntity);
			produtoEntity = new ProdutoEntity();
			MsgUtil.msgInfo("Produto excluído com sucesso!");
		} catch (Exception e) {
			MsgUtil.msgError("Erro ao excluír produto: " + e.getMessage());
		}
	}

}
