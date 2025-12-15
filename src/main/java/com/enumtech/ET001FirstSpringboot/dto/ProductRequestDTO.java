package com.enumtech.ET001FirstSpringboot.dto;

import com.enumtech.ET001FirstSpringboot.util.Category;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;
    
    /*
    @NotBlank rejects
    null
	"" (empty string)
	" " (whitespace-only string)
     */
    
    @Min(value = 1, message = "Price must be greater than 0")
    @Max(value = 50000, message = "Price must be less than or equal to 50,000") 
    private double price;

    @NotBlank(message = "Description is required")
    @Size(min = 6, max = 200, message = "Description must be between 6 and 200 characters")
    private String description;

    @NotNull(message = "Category is required")
    private Category category;

    private String image;

    private RatingRequestDTO rating;

}
