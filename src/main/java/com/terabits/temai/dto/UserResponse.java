package com.terabits.temai.dto;

import java.time.LocalDateTime;

public record UserResponse(

        Long id,
        String name,
        String phone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}