package com.enumtech.ET001FirstSpringboot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class ProductRequestDTO {
    @NotBlank(message = "Title is required")
    private String title;
    
    /*
    @NotBlank rejects
    null
	"" (empty string)
	" " (whitespace-only string)
     */
    
    @Min(value = 1, message = "Price must be greater than 0")
    private double price;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Category is required")
    private String category;

    private String image;

    private RatingRequestDTO rating;

}
