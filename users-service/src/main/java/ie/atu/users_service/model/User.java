package ie.atu.users_service.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor@Builder
public class User {
    @NotBlank
    @Size(max=50)
    private String userID;
    @NotBlank
    @Size(min = 5, max = 30)
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, max = 30)
    private String password;
}