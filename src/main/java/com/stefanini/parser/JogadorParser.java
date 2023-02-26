package com.stefanini.parser;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.entity.Jogador;

public class JogadorParser {
        public static JogadorDTO toDTO(Jogador jogador) {
            JogadorDTO jogadorDTO = new JogadorDTO();
            jogadorDTO.setId(jogador.getId());
            jogadorDTO.setNickname(jogador.getNickname());
            jogadorDTO.setSaldo(jogador.getSaldo());
            return jogadorDTO;
        }
}
