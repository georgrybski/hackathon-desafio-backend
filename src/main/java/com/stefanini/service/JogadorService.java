package com.stefanini.service;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.dto.RegistrarJogadorDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.parser.JogadorParser;
import com.stefanini.repository.JogadorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class JogadorService {
    @Inject
    JogadorRepository jogadorRepository;

    public void salvar(RegistrarJogadorDTO registrarJogadorDTO) {
        Jogador jogador = new Jogador(registrarJogadorDTO);
        jogadorRepository.save(jogador);
    }

    public Jogador pegarPorId(Long id) {
        var jogador = jogadorRepository.findById(id);
        if(Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("Ocorreu um erro ao buscar o Jogador de id " + id, Response.Status.NOT_FOUND);
        }
        return jogador;
    }

    public void alterar(Jogador jogador) {
        jogadorRepository.update(jogador);
    }

    public void deletar(Long id) {
        jogadorRepository.delete(id);
    }

    public List<JogadorDTO> listarTodos() {
        return jogadorRepository.listAll().stream().map(JogadorParser::toDTO).collect(Collectors.toList());
    }

    public Jogador pegarJogadorPorNickname(String nickname) {
        Optional<Jogador> jogador = Optional.ofNullable(jogadorRepository.pegarJogadorPorNickname(nickname));
        if (jogador.isEmpty()) {
            throw new RegraDeNegocioException("Ocorreu um erro ao buscar o Jogador de nickname " + nickname, Response.Status.NOT_FOUND);
        }
        return jogador.get();
    }
}
