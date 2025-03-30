package br.com.alura.client;

import java.io.IOException;
import java.net.http.HttpResponse;

public interface IClientHttpConfiguration {
    HttpResponse<String> dispararRequisicaoPost(String uri, Object object) throws IOException, InterruptedException;

    HttpResponse<String> dispararRequisicaoGet(String uri) throws IOException, InterruptedException;
}
