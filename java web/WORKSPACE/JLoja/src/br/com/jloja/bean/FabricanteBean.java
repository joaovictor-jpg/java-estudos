package br.com.jloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.jloja.DAO.FabricanteDAO;
import br.com.jloja.entity.FabricanteEntity;
import br.com.jloja.util.MsgUtil;

@ManagedBean(name = "FabricanteMB")
@ViewScoped
public class FabricanteBean {

	private FabricanteEntity fabricanteEntity;

	private List<FabricanteEntity> listaFabricantes;
	private List<FabricanteEntity> listaFabricantesFiltrados;

	public List<FabricanteEntity> getListaFabricantes() {
		return listaFabricantes;
	}

	public FabricanteBean() {
		this.fabricanteEntity = new FabricanteEntity();
	}

	public FabricanteEntity getFabricanteEntity() {
		return fabricanteEntity;
	}

	public void setFabricanteEntity(FabricanteEntity fabricanteEntity) {
		this.fabricanteEntity = fabricanteEntity;
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
			FabricanteDAO dao = new FabricanteDAO();
			listaFabricantes = dao.listar();
		} catch (Exception e) {
			throw e;
		}
	}

	public void adicionarFabricante() {
		try {
			FabricanteDAO fabdao = new FabricanteDAO();
			fabdao.adicionar(fabricanteEntity);
			fabricanteEntity = new FabricanteEntity();
			MsgUtil.msgInfo("Fabricante gravado com sucesso!!!");
		} catch (Exception e) {
			MsgUtil.msgError("Error ao Gravar fabricante: " + e.getMessage());
		}
	}

}
