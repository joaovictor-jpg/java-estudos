package br.com.jota.refl;

import br.com.jota.Endereco;
import br.com.jota.Pessoa;
import br.com.jota.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

class TransformatorTest {

    Pessoa pessoa = new Pessoa(1, "João", "123");
    Endereco endereco = new Endereco("Cristiano Machado", 661);

    @Test
    public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();

        PessoaDTO dto = transformator.transform(pessoa);

        Assertions.assertInstanceOf(PessoaDTO.class, dto);
        Assertions.assertEquals(pessoa.getNome(), dto.getNome());
        Assertions.assertEquals(pessoa.getCpf(), dto.getCpf());
    }

    @Test
    public void shouldNotTransform() {
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            Transformator transformator = new Transformator();
            transformator.transform(endereco);
        });
    }

    @Test
    public void shouldTransformWhenSomeFieldIsNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoaSemCpf = new Pessoa("Teste");
        Transformator transformator = new Transformator();

        PessoaDTO dtoSemCpf = transformator.transform(pessoaSemCpf);

        Assertions.assertEquals(pessoaSemCpf.getNome(), dtoSemCpf.getNome());
        Assertions.assertNull(dtoSemCpf.getCpf());
    }

}