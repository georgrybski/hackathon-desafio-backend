package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.Jogador;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;


@ApplicationScoped
public class JogadorRepository extends GenericDAO<Jogador, Long> {
    public Jogador pegarJogadorPorNickname(String nickname) {
        return createQuery("SELECT u FROM Jogador u WHERE u.nickname = :nickname")
                .setParameter("nickname", nickname).getSingleResult();
    }
}
