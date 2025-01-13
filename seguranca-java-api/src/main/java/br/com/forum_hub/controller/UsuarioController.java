package br.com.forum_hub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.forum_hub.domain.perfil.DadosPerfil;
import br.com.forum_hub.domain.usuario.AtualizarSenha;
import br.com.forum_hub.domain.usuario.DadosAtualizarUsuario;
import br.com.forum_hub.domain.usuario.DadosCadostroUsuarios;
import br.com.forum_hub.domain.usuario.DadosListagemUsuario;
import br.com.forum_hub.domain.usuario.Usuario;
import br.com.forum_hub.domain.usuario.UsuarioEmail;
import br.com.forum_hub.domain.usuario.UsuarioService;
import jakarta.validation.Valid;

@RestController
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/registrar")
    public ResponseEntity<DadosListagemUsuario> cadastrar(@Valid @RequestBody DadosCadostroUsuarios dados,
            UriComponentsBuilder uriBuilder) {
        var usuario = service.cadastrar(dados);

        var uri = uriBuilder.path("/{nomeUsuario}").buildAndExpand(usuario.getNome()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemUsuario(usuario));
    }

    @PostMapping("/alterar-senha")
    public ResponseEntity<String> recuperarSenha(@RequestBody UsuarioEmail usewEmail) {
        service.tokenTrocaSenha(usewEmail);
        return ResponseEntity.ok("Email enviado com sucesso!");
    }

    @GetMapping("/verificar-conta")
    public ResponseEntity<String> getMethodName(@RequestParam String codigo) {
        service.verifcarEmail(codigo);
        return ResponseEntity.ok("Conta verificada com sucesso!");
    }

    @GetMapping("/{nomeUsuario}")
    public ResponseEntity<DadosListagemUsuario> listarUsuario(@PathVariable String nomeUsuario) {
        var listarUsuario = new DadosListagemUsuario(service.buscarUsuarioNomeUsuario(nomeUsuario));

        return ResponseEntity.ok().body(listarUsuario);
    }

    @PutMapping("/editar-perfil")
    public ResponseEntity<DadosListagemUsuario> atualizarDadosUsuarios(@AuthenticationPrincipal Usuario usuario,
            @RequestBody DadosAtualizarUsuario dados) {
        var listarUsuario = new DadosListagemUsuario(service.atualizarDadosUsuarios(usuario.getId(), dados));

        return ResponseEntity.ok().body(listarUsuario);
    }

    @PatchMapping("/atualizar-senha")
    public ResponseEntity<String> putMethodName(@RequestBody @Valid AtualizarSenha atualizar) {
        service.atualizarSenha(atualizar);
        return ResponseEntity.ok().body("Senha alterada com sucesso");
    }

    @DeleteMapping("/desativar")
    public ResponseEntity<Void> banirUsuario(@AuthenticationPrincipal Usuario logado) {
        service.desativarUsuario(logado);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/adicionar-perfil/{id}")
    public ResponseEntity<DadosListagemUsuario> adicionarPerfil(@PathVariable Long id, @Valid @RequestBody DadosPerfil dados) {
        var usuario = service.adicionarPerfil(id, dados);
        return ResponseEntity.ok(new DadosListagemUsuario(usuario));
    }

    @PatchMapping("/remover-perfil/{id}")
    public ResponseEntity<DadosListagemUsuario> removerPerfil(@PathVariable Long id, @RequestBody @Valid DadosPerfil dados){
        var usuario = service.removerPerfil(id, dados);
        return ResponseEntity.ok(new DadosListagemUsuario(usuario));
    }

}
