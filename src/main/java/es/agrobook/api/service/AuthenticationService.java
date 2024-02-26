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

@Service
public class AuthenticationService {
    
    @Autowired
    private JwtAuthService jwtAuthService;

    @Autowired
    private UsuarioRepository repository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    /*@Autowired
    private AuthenticationManager authenticationManager;*/



    public AuthenticationResponse register(@RequestBody RegisterRequest request){
        Usuario usuario = new Usuario();
        usuario.setUsername(request.getUsername());
        usuario.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        usuario.setEnabled(true);
        usuario.setNombre(request.getNombre());
        usuario.setNif(request.getNif());
        usuario.setAsesor(request.getAsesor());

            usuario = repository.save(usuario);

            String token = jwtAuthService.generateToken(usuario);

            return AuthenticationResponse.builder().token(token).build();
    }


    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request){
        /*authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );*/

        Usuario usuario = repository.findByUsername(request.getUsername());
        
        String token = jwtAuthService.generateToken(usuario);

        return AuthenticationResponse.builder().token(token).build();
    }
}
