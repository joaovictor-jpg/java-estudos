package br.com.jloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jloja.DAO.UsuarioDAO;
import br.com.jloja.entity.UsuarioEntity;
import br.com.jloja.util.MsgUtil;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioBean {

	private List<UsuarioEntity> listaUsuarios;
	private List<UsuarioEntity> listaUsuariosFiltrados;
	private UsuarioEntity usuario;
	private Long codigo;

	public List<UsuarioEntity> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<UsuarioEntity> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<UsuarioEntity> getListaUsuariosFiltrados() {
		return listaUsuariosFiltrados;
	}

	public void setListaUsuariosFiltrados(List<UsuarioEntity> listaUsuariosFiltrados) {
		this.listaUsuariosFiltrados = listaUsuariosFiltrados;
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

	public UsuarioBean() {
		this.usuario = new UsuarioEntity();
	}

	public void listarUsuario() {
		try {
			UsuarioDAO usuDAO = new UsuarioDAO();
			listaUsuarios = usuDAO.listar();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void adicionarUsuario() {
		try {
			UsuarioDAO usudao = new UsuarioDAO();
			usudao.adicionar(usuario);
			usuario = new UsuarioEntity();
			MsgUtil.msgInfo("Usuário gravado com Sucesso!");
		} catch (Exception ex) {
			MsgUtil.msgError("Erro ao gravar usuário: " + ex.getMessage());
		}
	}

	public void buscarUsuarioCodigo(Long codigo) {
		try {
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuario = usuDAO.buscarPorCodigo(codigo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void editarUsuario() {
		try {
			UsuarioDAO usudao = new UsuarioDAO();
			usudao.editar(usuario);
			usuario = new UsuarioEntity();
			MsgUtil.msgInfo("Usuário editado com Sucesso!");

		} catch (Exception ex) {
			MsgUtil.msgError("Erro ao tentar editar um usuário: " + ex.getMessage());
		}
	}

	public void excluirUsuario() {
		try {
			UsuarioDAO usudao = new UsuarioDAO();
			usudao.excluir(usuario);
			usuario = new UsuarioEntity();
			MsgUtil.msgInfo("Usuário excluído com Sucesso!");
		} catch (Exception ex) {
			MsgUtil.msgError("Erro ao tentar excluir usuário: " + ex.getMessage());
		}
	}

}
