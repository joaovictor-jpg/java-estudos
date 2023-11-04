package br.com.jloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.jloja.DAO.FabricanteDAO;
import br.com.jloja.entity.FabricanteEntity;

@ManagedBean(name = "FabricanteMB")
@ViewScoped
public class FabricanteBean {

	private List<FabricanteEntity> listaFabricantes;
	private List<FabricanteEntity> listaFabricantesFiltrados;

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
			FabricanteDAO dao = new FabricanteDAO();
			listaFabricantes = dao.listar();
		} catch (Exception e) {
			throw e;
		}
	}

}
