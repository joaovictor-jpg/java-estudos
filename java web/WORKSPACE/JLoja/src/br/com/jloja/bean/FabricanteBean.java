package br.com.jloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jloja.DAO.FabricanteDAO;
import br.com.jloja.entity.FabricanteEntity;
import br.com.jloja.util.MsgUtil;

@ManagedBean(name = "FabricanteMB")
@ViewScoped
public class FabricanteBean {

	private List<FabricanteEntity> listaFabricantes;
	private List<FabricanteEntity> listaFabricantesFiltrados;
	private FabricanteEntity fabricanteEntity;

	public FabricanteEntity getFabricanteEntity() {
		return fabricanteEntity;
	}

	public void setFabricanteEntity(FabricanteEntity fabricanteEntity) {
		this.fabricanteEntity = fabricanteEntity;
	}

	public List<FabricanteEntity> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<FabricanteEntity> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

	public List<FabricanteEntity> getListaFabricantesFiltrados() {
		return listaFabricantesFiltrados;
	}

	public void setListaFabricantesFiltrados(List<FabricanteEntity> listaFabricantesFiltrados) {
		this.listaFabricantesFiltrados = listaFabricantesFiltrados;
	}

	public void listarFabricante() {
		try {
			FabricanteDAO fabDAO = new FabricanteDAO();
			listaFabricantes = fabDAO.listar();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public FabricanteBean() {

		this.fabricanteEntity = new FabricanteEntity();
	}

	public void adicionarFabricante() {

		try {

			FabricanteDAO fabdao = new FabricanteDAO();
			fabdao.adicionar(fabricanteEntity);
			fabricanteEntity = new FabricanteEntity();
			MsgUtil.msgInfo("Fabricante gravado com Sucesso!");
		} catch (Exception ex) {
			MsgUtil.msgError("Erro ao gravar fabricante: " + ex.getMessage());
		}

	}

	public void buscarFabricanteCodigo(Long codigo) {

		try {
			FabricanteDAO fabDAO = new FabricanteDAO();
			fabricanteEntity = fabDAO.buscarPorCodigo(codigo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void editarFabricante() {

		try {
			FabricanteDAO fabdao = new FabricanteDAO();
			fabdao.editar(fabricanteEntity);
			fabricanteEntity = new FabricanteEntity();
			MsgUtil.msgInfo("Fabricante editado com Sucesso!");
		} catch (Exception ex) {
			MsgUtil.msgError("Erro ao tentar editar um fabricante: " + ex.getMessage());
		}
	}

	public void excluirFabricante() {

		try {
			FabricanteDAO fabdao = new FabricanteDAO();
			fabdao.excluir(fabricanteEntity);
			fabricanteEntity = new FabricanteEntity();
			MsgUtil.msgInfo("Fabricante excluído com Sucesso!");
		} catch (Exception ex) {
			MsgUtil.msgError("Erro ao tentar excluir fabricante: " + ex.getMessage());
		}

	}
	
	public void limpar() {
		fabricanteEntity = new FabricanteEntity();
	}

}