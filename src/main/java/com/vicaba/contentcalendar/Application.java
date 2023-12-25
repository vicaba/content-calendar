package com.vicaba.contentcalendar;

import com.vicaba.contentcalendar.config.ContentCalendarProperties;
import com.vicaba.contentcalendar.model.Content;
import com.vicaba.contentcalendar.model.Status;
import com.vicaba.contentcalendar.model.Type;
import com.vicaba.contentcalendar.repository.ContentRepository;
import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// https://www.youtube.com/watch?v=UgX5lgv4uVM 3:28:00

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
