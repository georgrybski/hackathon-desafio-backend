package com.stefanini.service;

import com.stefanini.dto.RequisicaoDeLogin;
import com.stefanini.security.ValidadorDeLogin;
import org.slf4j.LoggerFactory;

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
        LoggerFactory.getLogger(LoginService.class).info("Validando login do jogador: " + jogador.getNickname() + " com senha: " + requisicaoDeLogin.getPassword());
        LoggerFactory.getLogger(LoginService.class).info("BOolean" + validadorDeLogin.validarLogin(jogador, requisicaoDeLogin.getPassword()));
        return validadorDeLogin.validarLogin(jogador, requisicaoDeLogin.getPassword());
    }
}
