package ie.atu.books_service;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    @NotBlank
    @Size(min = 1, max = 100, message ="Invalid Entry")
    private String name;
    @NotBlank
    @Size(min = 1, max = 100, message ="Invalid Entry")
    private String author;
    @NotBlank
    @Size(min = 1, max = 100, message ="Invalid Entry")
    private String publisher;
}
