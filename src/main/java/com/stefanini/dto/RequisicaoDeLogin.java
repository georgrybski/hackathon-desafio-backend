package com.stefanini.dto;

import javax.validation.constraints.NotEmpty;

public class RequisicaoDeLogin {
    @NotEmpty
    private String nickname;
    @NotEmpty
    private String password;

    public RequisicaoDeLogin() {
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }
}
