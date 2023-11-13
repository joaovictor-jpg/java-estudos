package br.com.jloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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

	private UsuarioEntity usuarioLogado;

	public UsuarioEntity getUsuarioLogado() {
		if (usuarioLogado == null)
			usuarioLogado = new UsuarioEntity();
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioEntity usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

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

	public void autenticar() {
		try {
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuarioLogado = usuDAO.autenticar(usuarioLogado.getLogin(), usuarioLogado.getSenha());
			if (usuarioLogado == null) {
				MsgUtil.msgError("Usuário e/ou senha inmválidos");
				usuarioLogado = new UsuarioEntity();
			} else if (usuarioLogado.getSituacao() == 'N') {
				MsgUtil.msgError("Este usuário está inativo no sistema!");
				usuarioLogado = null;
			} else {
				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				ec.redirect("/jloja/index.xhtml");
			}
		} catch (Exception e) {
			MsgUtil.msgError("Error ao autenticar usuário");
		}
	}

}
