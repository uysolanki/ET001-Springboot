package com.enumtech.ET001FirstSpringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private RatingResponseDTO rating;

}
