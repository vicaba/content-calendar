package com.vicaba.contentcalendar.controller;

import com.vicaba.contentcalendar.config.ContentCalendarProperties;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private final ContentCalendarProperties contentCalendarProperties;

	public HomeController(ContentCalendarProperties contentCalendarProperties) {
		this.contentCalendarProperties = contentCalendarProperties;
	}

	@GetMapping("/")
	public ContentCalendarProperties home() {
		return contentCalendarProperties;
	}

}
