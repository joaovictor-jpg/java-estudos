package br.com.alura.client;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.http.HttpResponse;

public interface IClientHttpConfiguration {
    HttpResponse<String> dispararRequisicaoPost(String uri, JsonObject json) throws IOException, InterruptedException;

    HttpResponse<String> dispararRequisicaoGet(String uri) throws IOException, InterruptedException;
}
