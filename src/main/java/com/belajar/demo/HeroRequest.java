package com.belajar.demo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HeroRequest {

    @NotBlank(message = "Nama Hero tidak boleh kosong, Bos!")
    private String name;

    @Min(value = 1, message = "Level minimal 1 dong, masa minus?")
    private Integer level;
}