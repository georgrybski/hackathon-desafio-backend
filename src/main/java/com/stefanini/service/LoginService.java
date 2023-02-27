package com.stefanini.service;

import com.stefanini.dto.RequisicaoDeLogin;
import com.stefanini.security.ValidadorDeLogin;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class LoginService {

    @Inject
    private ValidadorDeLogin validadorDeLogin;

    @Inject
    private JogadorService jogadorService;

    public boolean validarLogin(RequisicaoDeLogin requisicaoDeLogin) {
        var jogador = jogadorService.pegarJogadorPorNickname(requisicaoDeLogin.getNickname());
        return validadorDeLogin.validarLogin(jogador, requisicaoDeLogin.getPassword());
    }
}
