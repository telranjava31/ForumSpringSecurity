package telran.forum.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ManagedResource
public class AccountConfiguration {
		
	@Value("${exp.value}")
	long expPeriod = 90;

	@ManagedAttribute
	public long getExpPeriod() {
		return expPeriod;
	}

	@ManagedAttribute
	public void setExpPeriod(long expPeriod) {
		this.expPeriod = expPeriod;
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
