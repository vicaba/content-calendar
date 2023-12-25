package com.vicaba.contentcalendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cc")
public record ContentCalendarProperties(String welcome, String about) {

}
