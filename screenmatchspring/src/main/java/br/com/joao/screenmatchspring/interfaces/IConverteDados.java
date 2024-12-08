package br.com.joao.screenmatchspring.interfaces;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
