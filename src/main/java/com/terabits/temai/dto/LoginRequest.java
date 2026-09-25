package com.terabits.temai.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

        @NotBlank(message = "Telefone é obrigatorio")
        String phone,

        @NotBlank(message = "Senha é obrigatoria")
        String password
) {
}
