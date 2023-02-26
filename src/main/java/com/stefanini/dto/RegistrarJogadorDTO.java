package com.stefanini.dto;

import com.stefanini.entity.Stefamon;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class RegistrarJogadorDTO {

    @NotEmpty
    private String nickname;
    @NotEmpty
    @Size(min = 4, max = 10)
    private String password;
    @NotNull
    private List<Stefamon> stefamons = new ArrayList<>();

    public RegistrarJogadorDTO() {
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Stefamon> getStefamons() {
        return stefamons;
    }
    public void setStefamons(List<Stefamon> stefamons) {
        this.stefamons = stefamons;
    }
}
