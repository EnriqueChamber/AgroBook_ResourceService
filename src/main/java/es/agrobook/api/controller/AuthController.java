package es.agrobook.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.agrobook.api.auth.AuthenticationRequest;
import es.agrobook.api.auth.AuthenticationResponse;
import es.agrobook.api.auth.RegisterRequest;
import es.agrobook.api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        AuthenticationResponse response = authenticationService.register(request);
        
        return ResponseEntity.ok(response);
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/validate-token")
    public ResponseEntity<Object> validateToken(@RequestBody Object request){
        return ResponseEntity.ok(authenticationService.authenticate((AuthenticationRequest)request));
    }
}