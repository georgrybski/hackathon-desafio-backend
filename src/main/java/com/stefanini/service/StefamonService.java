package com.stefanini.service;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.entity.Stefamon;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.parser.StefamonParser;
import com.stefanini.repository.StefamonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class StefamonService {

    @Inject
    private StefamonRepository repository;

    @Inject
    private JogadorService jogadorService;

    public List<Stefamon> listarTodos(){
        return repository.listAll();
    }

    public Stefamon pegarPorId(Long id) {
        var stefamon =  repository.findById(id);
        if(Objects.isNull(stefamon)) {
            throw new RegraDeNegocioException("Não encontramos nada com o id " + id, Response.Status.NOT_FOUND);
        }
        return stefamon;
    }

    public JogadorDTO comprar(Long id, String nickname) {
        var stefamon = pegarPorId(id);
        var jogador = jogadorService.pegarJogadorPorNickname(nickname);
        if(Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("O Stefamon de id " + id + " não está disponível para compra", Response.Status.NOT_FOUND);
        }
        if(!jogador.getNickname().equals(nickname)) {
            throw new RegraDeNegocioException("O Stefamon de id " + id + " não pertence ao jogador " + nickname, Response.Status.NOT_FOUND);
        }
        if (jogador.getSaldo().subtract(StefamonParser.entityToDto(stefamon).getPrice()).compareTo(BigDecimal.ZERO) < 0) {
            throw new RegraDeNegocioException("O jogador " + nickname + " não possui saldo suficiente para comprar o Stefamon de id " + id, Response.Status.NOT_FOUND);
        }
        jogador.setSaldo(jogador.getSaldo().subtract(StefamonParser.entityToDto(stefamon).getPrice()));
        repository.update(stefamon);
        return new JogadorDTO(jogador);
    }
}
