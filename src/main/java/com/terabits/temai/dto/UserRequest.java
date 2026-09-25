package com.terabits.temai.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRequest(

        @NotBlank(message = "Nome é obrigatório")
        String name,

        @NotBlank(message = "Telefone é obrigatório")
        String phone,

        @NotBlank(message = "Senha é obrigatória")
        String password

) {
}