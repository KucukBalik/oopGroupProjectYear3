package ie.atu.books_service.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @NotBlank(message = "Name must not be blank")
    @Size(min = 1, max = 100, message ="Invalid Entry")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name can contain only English letters")
    private String name;

    @NotBlank(message = "BookID must not be blank")
    @Size(max = 40)
    @Pattern(regexp = "\\d+", message = "BookID must contain only numbers")
    private String BookID;

    @NotBlank(message = "Author must not be blank")
    @Size(min = 1, max = 100, message ="Invalid Entry")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Author name can contain only English letters")
    private String author;

    @NotBlank(message = "Publisher must not be blank")
    @Size(min = 1, max = 100, message ="Invalid Entry")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Publisher name can contain only English letters")
    private String publisher;
}
