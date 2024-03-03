package es.agrobook.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class AgroBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgroBookApplication.class, args);
	}

	public static ResponseEntity<Object> handleControllerException(Exception ex){

        if(ex instanceof DataIntegrityViolationException){
            DataIntegrityViolationException exception = (DataIntegrityViolationException)ex;
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
        
        
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
