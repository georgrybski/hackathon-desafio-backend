package com.stefanini.security;


import com.stefanini.entity.Jogador;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class ValidadorDeLogin {
    @Inject
    private PasswordValidator passwordValidator;
    public boolean validarLogin(Jogador jogador, String password) {
        return passwordValidator.validatePassword(jogador, password);
    }

}
