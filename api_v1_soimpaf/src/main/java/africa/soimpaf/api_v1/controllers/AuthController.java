package africa.soimpaf.api_v1.controllers;

import africa.soimpaf.api_v1.config.jwt.JwTokenClient;
import africa.soimpaf.api_v1.config.jwt.JwtUserDetailsImpl;
import africa.soimpaf.api_v1.exeptions.NotFoundException;
import africa.soimpaf.api_v1.models.User;
import africa.soimpaf.api_v1.payload.AccessToken;
import africa.soimpaf.api_v1.payload.LoginDto;
import africa.soimpaf.api_v1.repository.IRoleRepository;
import africa.soimpaf.api_v1.repository.IUserRepository;
import africa.soimpaf.api_v1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.apache.logging.log4j.LogManager.getLogger;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest servletRequest;

    @Autowired
    private JwTokenClient jwTokenClient;

    @Autowired
    private UserService userService;
    @PostMapping("/signin")
    public ResponseEntity<HashMap> authenticateUser(@RequestBody @Valid LoginDto loginDto, BindingResult bindingResult) throws NotFoundException, BindException {
        Assert.notNull(loginDto);
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        User user = userService.authenticate(loginDto.getEmail(), loginDto.getPassword());
        if (user == null) {
            throw NotFoundException.create(loginDto.getEmail(), User.class);
        }

        // generation du token
        JwtUserDetailsImpl userDetails = JwtUserDetailsImpl.build(user, servletRequest);

        String jwtToken = jwTokenClient.generateJwtToken(userDetails);
        Date expiresAt = jwTokenClient.getExpirationDateFromToken(jwtToken);
        Date issuedAt = jwTokenClient.getIssuedAtDateFromToken(jwtToken);
        AccessToken accessToken = new AccessToken(jwtToken, expiresAt, issuedAt, servletRequest);

        getLogger().info("token :: {}", jwtToken);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(jwtToken);

        HashMap body = new HashMap<>();
        body.put("role",user.getRole().getName());
        body.put("message", "User signed-in successfully!.");
        body.put("accessToken", accessToken);

        ResponseEntity<HashMap> tResponseEntity = new ResponseEntity<>(body, HttpStatus.OK);
        return tResponseEntity;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User signUpDto){

        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setFirst_name(signUpDto.getFirst_name());
        user.setEmail(signUpDto.getEmail());
        user.setRole(signUpDto.getRole());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        User _user = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(
                Map.of(
                        "id",_user.getId(),
                        "createdAt", _user.getCreatedAt(),
                        "firstname",_user.getFirst_name(),
                        "lastname",_user.getName(),
                        "email", _user.getEmail()

                        ));
    }
}
