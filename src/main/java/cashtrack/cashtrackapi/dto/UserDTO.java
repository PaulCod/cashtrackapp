package cashtrack.cashtrackapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {

    @NotBlank(message = "Name is empty!")
    private String name;

    @Email(message = "invalid Email")
    @NotBlank(message = "Email is empty!")
    private String email;

    @NotBlank(message = "Password is empty!")
    @Size(message = "Password must be least at 6 character", min = 6)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
