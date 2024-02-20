package es.agrobook.api.configuration;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
public class DataSourceConfig {
	
    /*@Autowired
    private Environment env;*/
    

    private Logger miLogger = Logger.getLogger(getClass().getName());
	
    
    @Bean
    public DataSource dataSource() {
    	try {
    		String url = "jdbc:mysql://localhost:3306/cuaderno_digital?allowPublicKeyRetrieval=true&useSSL=false";
			String username = "root";
			String password = "KikeChrome98.-";
			String driverClassName = "com.mysql.cj.jdbc.Driver";
			//String database_platform = "org.hibernate.dialect.MySQL8Dialect";
			
			
			ComboPooledDataSource securityDS = new ComboPooledDataSource();

			securityDS.setDriverClass(driverClassName);

			miLogger.info("URL de la BBDD: " + url);
			miLogger.info("Usuario de la BBDD: " + username);
			
			securityDS.setJdbcUrl(url);
			securityDS.setUser(username);
			securityDS.setPassword(password);


			//Establecer propiedades de Pool de conexiones
			securityDS.setInitialPoolSize(5);
			securityDS.setMinPoolSize(5);
			securityDS.setMaxPoolSize(20);
			securityDS.setMaxIdleTime(3000);


			return securityDS;

		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    
	//spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
	
}