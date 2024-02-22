package es.agrobook.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import es.agrobook.api.model.Usuario;
import es.agrobook.api.repository.UsuarioRepository;
import es.agrobook.api.utils.JwtUtil;
import es.agrobook.api.utils.TokenReqRes;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody Usuario user){
        try{
            String hasehdPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(hasehdPassword);

            if(usuarioRepository.save(user).getId() > 1){
                return ResponseEntity.ok(user);
            }
            else{
                throw new Exception("Unable to save user");
            }
        }
        catch(Exception ex){
            return ResponseEntity.internalServerError().body("User not Saved. Internal Server Error: " + ex);
        }
    }


    @PostMapping("/generate-token")
    public ResponseEntity<Object> generateToken(@RequestBody TokenReqRes tokenReqRes){
        Usuario user = usuarioRepository.findByUsername(tokenReqRes.getUsername());
        if (user == null) {
            return ResponseEntity.badRequest().body("User does not exist");
        }
        if(bCryptPasswordEncoder.matches(tokenReqRes.getPassword(), user.getPassword())){
            String token = jwtUtil.generateToken(tokenReqRes.getUsername());
            tokenReqRes.setToken(token);
            tokenReqRes.setExpirationTime("60 Seconds");
            return ResponseEntity.ok(tokenReqRes);
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password does not match");
        }
    }

    @PostMapping("/validate-token")
    public ResponseEntity<Object> validateToken(@RequestBody TokenReqRes tokenReqRes){
        return ResponseEntity.ok(jwtUtil.validateToken(tokenReqRes.getToken()));
    }
}