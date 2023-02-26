package com.stefanini.service;

import com.stefanini.entity.Jogador;
import com.stefanini.entity.Stefamon;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BatalhaService {

    public void batalhar(Jogador jogador1, Jogador jogador2) {
        List<Stefamon> stefamons1 = jogador1.getStefamons();
        List<Stefamon> stefamons2 = jogador2.getStefamons();
        Stefamon currentStefamon1 = stefamons1.get(0);
        Stefamon currentStefamon2 = stefamons2.get(0);
        while(stefamonsLeft(stefamons1) && stefamonsLeft(stefamons2)) {
            if(currentStefamon1.isAlive()) {
                currentStefamon1.attack(currentStefamon2);
            } else {
                currentStefamon1 = stefamons1.stream().filter(Stefamon::isAlive).findFirst().orElse(null);
            }
        }
        // Incompleto, mas obrigado pela oportunidade, aprendi demais, espero aprender mais com voces
    }

    public boolean stefamonsLeft(List<Stefamon> stefamons) {
        return stefamons.stream().anyMatch(Stefamon::isAlive);
    }
}
