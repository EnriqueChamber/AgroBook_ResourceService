package es.agrobook.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import es.agrobook.api.auth.AuthenticationRequest;
import es.agrobook.api.auth.AuthenticationResponse;
import es.agrobook.api.auth.RegisterRequest;
import es.agrobook.api.model.Usuario;
import es.agrobook.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    @Autowired
    private final JwtAuthService jwtAuthService;

    @Autowired
    private final UsuarioRepository repository;
    
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private final AuthenticationManager authenticationManager;



    public AuthenticationResponse register(@RequestBody RegisterRequest request){
        Usuario usuario = Usuario.builder()
            .username(request.getUsername())
            .password(bCryptPasswordEncoder.encode(request.getPassword()))
            .enabled(true)
            .nombre(request.getNombre())
            .nif(request.getNif())
            .asesor(request.getAsesor())
            .build();

            usuario = repository.save(usuario);

            String token = jwtAuthService.generateToken(usuario);

            return AuthenticationResponse.builder().token(token).build();
    }


    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request){
        
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        Usuario usuario = repository.findByUsername(request.getUsername());
        
        String token = jwtAuthService.generateToken(usuario);

        return AuthenticationResponse.builder().token(token).build();
    }
}
