package com.stefanini.parser;

import com.stefanini.dto.StefamonDTO;
import com.stefanini.entity.Stefamon;

import java.math.BigDecimal;

public class StefamonParser {
    public static Stefamon dtotoEntity(StefamonDTO dto) {
        Stefamon stefamon = new Stefamon();
        stefamon.setNome(dto.getNome());
        stefamon.setVida(dto.getVida());
        stefamon.setAtaque(dto.getAtaque());
        stefamon.setDefesa(dto.getDefesa());
        stefamon.setInteligencia(dto.getInteligencia());
        stefamon.setPoder(dto.getPoder());
        stefamon.setVelocidade(dto.getVelocidade());
        stefamon.setUrlFoto(dto.getUrlFoto());
        return stefamon;
    }

    public static StefamonDTO entityToDto(Stefamon stefamon) {
        StefamonDTO dto = new StefamonDTO();
        dto.setId(stefamon.getId());
        dto.setNome(stefamon.getNome());
        dto.setVida(stefamon.getVida());
        dto.setAtaque(stefamon.getAtaque());
        dto.setDefesa(stefamon.getDefesa());
        dto.setInteligencia(stefamon.getInteligencia());
        dto.setPoder(stefamon.getPoder());
        dto.setVelocidade(stefamon.getVelocidade());
        dto.setUrlFoto(stefamon.getUrlFoto());
        dto.setPrice(getStefamonPrice(stefamon));
        return dto;
    }

    private static BigDecimal getStefamonPrice(Stefamon stefamon) {
        double price = (stefamon.getVida() +
                stefamon.getAtaque() +
                stefamon.getDefesa() +
                stefamon.getInteligencia() +
                stefamon.getPoder() +
                stefamon.getVelocidade()) / 6;

        return BigDecimal.valueOf(price);
    }
}
