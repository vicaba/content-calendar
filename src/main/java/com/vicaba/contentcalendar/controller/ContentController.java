package com.vicaba.contentcalendar.controller;

import com.vicaba.contentcalendar.model.Content;
import com.vicaba.contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/content")
@CrossOrigin
public class ContentController {

	private final ContentRepository contentRepository;

	public ContentController(ContentRepository contentRepository) {
		this.contentRepository = contentRepository;
	}

	@GetMapping("")
	public List<Content> findAll() {
		return contentRepository.findAll();
	}

	@GetMapping("/{id}")
	public Content findById(@PathVariable Integer id) {
		return contentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public void create(@Valid @RequestBody Content content) {
		contentRepository.save(content);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	public void update(@RequestBody Content content, @PathVariable Integer id) {
		if (!contentRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		contentRepository.save(content);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!contentRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		contentRepository.deleteById(id);
	}

	@GetMapping("/filter/{keyword}")
	public List<Content> findByTitle(@PathVariable String keyword) {
		return contentRepository.findAllByTitleContains(keyword);
	}

	@GetMapping("/filter/status/{status}")
	public List<Content> findByStatus(@PathVariable String status) {
		return contentRepository.listByStatus(status);
	}

}
