package ie.atu.books_service.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @NotBlank
    @Size(min = 1, max = 100, message ="Invalid Entry")
    private String name;

    @NotBlank
    @Size(max = 40)
    private String BookID;

    @NotBlank
    @Size(min = 1, max = 100, message ="Invalid Entry")
    private String author;

    @NotBlank
    @Size(min = 1, max = 100, message ="Invalid Entry")
    private String publisher;
}
