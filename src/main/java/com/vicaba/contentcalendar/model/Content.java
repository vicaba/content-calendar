package com.vicaba.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public record Content(@Id Integer id, @NotBlank String title, @Column("description") String desc, Status status,
		Type contentType, LocalDateTime dateCreated, LocalDateTime dateUpdated, String url) {
}
