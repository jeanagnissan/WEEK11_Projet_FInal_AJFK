package africa.soimpaf.api_v1.payload;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}
