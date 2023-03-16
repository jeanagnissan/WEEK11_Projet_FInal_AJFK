package africa.soimpaf.api_v1.services;
import africa.soimpaf.api_v1.exeptions.EntityException;
import africa.soimpaf.api_v1.payload.LoginDto;
import africa.soimpaf.api_v1.payload.SignupDto;
public interface IAuthService {

    String login(LoginDto loginDto);
    String register(SignupDto registerDto) throws EntityException;
}
