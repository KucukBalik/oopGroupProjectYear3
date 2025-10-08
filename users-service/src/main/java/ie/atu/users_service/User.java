package ie.atu.users_service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotBlank
    @Size(min = 5, max = 30)
    private String email;
    @NotBlank
    @Size(min = 8, max = 30)
    private String password;

}
