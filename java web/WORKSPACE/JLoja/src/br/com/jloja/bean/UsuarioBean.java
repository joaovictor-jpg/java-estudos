package br.com.jloja.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jloja.DAO.UsuarioDAO;
import br.com.jloja.entity.UsuarioEntity;
import br.com.jloja.util.MsgUtil;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioBean {

	private List<UsuarioEntity> listaUsuario = new ArrayList<>();
	private List<UsuarioEntity> listaUsuarioFiltrados = new ArrayList<>();
	private UsuarioEntity usuario;
	private Long codigo;

	public UsuarioBean() {
	}

	public UsuarioBean(List<UsuarioEntity> listaUsuario, List<UsuarioEntity> listaUsuarioFiltrados,
			UsuarioEntity usuario, Long codigo) {
		this.usuario = new UsuarioEntity();
	}

	public List<UsuarioEntity> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<UsuarioEntity> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public List<UsuarioEntity> getListaUsuarioFiltrados() {
		return listaUsuarioFiltrados;
	}

	public void setListaUsuarioFiltrados(List<UsuarioEntity> listaUsuarioFiltrados) {
		this.listaUsuarioFiltrados = listaUsuarioFiltrados;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioBean other = (UsuarioBean) obj;
		return Objects.equals(codigo, other.codigo);
	}

	public void listarUsuario() {
		try {
			UsuarioDAO usuDAO = new UsuarioDAO();
			listaUsuario = usuDAO.listar();
		} catch (Exception e) {
			throw e;
		}
	}

	public void adicionarUsuario() {
		try {
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.adicionar(usuario);
			MsgUtil.msgInfo("Usuário gravado com sucesso!");
		} catch (Exception e) {
			MsgUtil.msgError("Error ao gravar usuário: " + e.getMessage());
		}
	}

	public void buscarUsuarioCodigo(Long codigo) {
		try {
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuario = usuDAO.buscarPorCodigo(codigo);
		} catch (Exception e) {
			throw e;
		}
	}

	public void editarUsuario() {
		try {
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.editar(usuario);
			usuario = new UsuarioEntity();
			MsgUtil.msgInfo("Usuário editado com sucesso!");
		} catch (Exception e) {
			MsgUtil.msgError("Erro ao tentar editar um usuáro: " + e.getMessage());
		}
	}

	public void excluir() {
		try {
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.excluir(usuario);
			usuario = new UsuarioEntity();
			MsgUtil.msgInfo("Usuário excluído com sucesso!");
		} catch (Exception e) {
			MsgUtil.msgError("Erro ao tentar excluir usuário: " + e.getMessage());
		}
	}

}
