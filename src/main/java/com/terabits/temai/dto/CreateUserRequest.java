package com.terabits.temai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record CreateUserRequest(

        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 100)
        String name,


        @NotBlank(message = "Telefone é obrigatório")
        String phone,


        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
        String password

) {
}