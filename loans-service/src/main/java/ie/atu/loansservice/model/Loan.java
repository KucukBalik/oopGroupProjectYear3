package ie.atu.loansservice.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Loan {
    @NotBlank
    private String loanId;
    @NotBlank
    private String userId;
    @NotBlank
    private String bookId;
    private LocalDate loanDate;
    private LocalDate dueDate;

}
