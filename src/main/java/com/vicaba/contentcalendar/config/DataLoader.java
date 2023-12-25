package com.vicaba.contentcalendar.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vicaba.contentcalendar.model.Content;
import com.vicaba.contentcalendar.repository.ContentRepository;
import java.io.InputStream;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

	private final ContentRepository contentRepository;

	private final ObjectMapper objectMapper;

	public DataLoader(ContentRepository contentRepository, ObjectMapper objectMapper) {
		this.contentRepository = contentRepository;
		this.objectMapper = objectMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
			var values = objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {
			});
			System.out.println("values = " + values);
			contentRepository.saveAll(values);
		}
	}

}
