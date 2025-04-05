package br.com.jota.refl;

import br.com.jota.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ObjectToJsonTest {

    Pessoa pessoa = new Pessoa(1, "João", "123");

    @Test
    public void shouldTransform() {
        ObjectToJson objectToJson = new ObjectToJson();
        String actual = objectToJson.transforme(pessoa);

        System.out.println(actual);

        Assertions.assertInstanceOf(String.class, actual);
    }

}