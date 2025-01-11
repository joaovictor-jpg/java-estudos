package med.voll.web_application.controller;

import jakarta.validation.Valid;
import med.voll.web_application.domain.RegraDeNegocioException;
import med.voll.web_application.domain.paciente.DadosCadastroPaciente;
import med.voll.web_application.domain.paciente.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cadastro-paciente")
public class CadastrarPacienteController {

    private static final String PAGINA_CADASTRO = "paciente/cadastro-paciente";
    private static final String REDIRECT_LISTAGEM = "redirect:/login?sucesso";

    private final PacienteService service;

    public CadastrarPacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public String carregaPaginaCadastrpPaciente(Model model) {
        model.addAttribute("dados", new DadosCadastroPaciente(null, "", "", "", ""));
        return PAGINA_CADASTRO;
    }

    @PostMapping
    public String criarUsuario(@Valid @ModelAttribute("dados") DadosCadastroPaciente dados, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("dados", dados);
            return PAGINA_CADASTRO;
        }

        try {
            service.cadastrar(dados);
            return REDIRECT_LISTAGEM;
        } catch (RegraDeNegocioException e) {
            model.addAttribute("erro", e.getMessage());
            model.addAttribute("dados", dados);
            return PAGINA_CADASTRO;
        }
    }

}
