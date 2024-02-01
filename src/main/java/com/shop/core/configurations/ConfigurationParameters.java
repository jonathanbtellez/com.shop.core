package com.shop.core.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="app")
public class ConfigurationParameters {
    private  String name;
    private  String language;
    private  String country;
    private  String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAuthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    @Override
    public String toString(){
        return "ConfigurationParameters{" +
                "name = "+ name +
                ", country = "+ country +
                ", author = "+ author +
                ", language ="+ language +
                "}";
    }
}
