package com.stefanini.security;

import com.stefanini.entity.Jogador;

import javax.enterprise.context.ApplicationScoped;

import static com.stefanini.security.PasswordUtils.hashPassword;

@ApplicationScoped
public class PasswordValidator {

    public boolean validatePassword(Jogador jogador, String password) {
            String hash = hashPassword(password, jogador.getSalt());
            return hash.equals(jogador.getPassword());
    }
}
