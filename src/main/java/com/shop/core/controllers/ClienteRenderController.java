package com.shop.core.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteRenderController {

    @GetMapping(value = "/clients-html", produces = MediaType.TEXT_HTML_VALUE)
    public String getClientHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        sb.append("<div>");
        sb.append("<h1>Client</h1>");
        sb.append("<ul>");
        sb.append("<li>Name: Jonathan Tellez</li>");
        sb.append("<li>Username: jontel</li>");
        sb.append("</ul>");
        sb.append("</div>");
        sb.append("</body></html>");
        return sb.toString();
    }

    @GetMapping(value = "/clients-xml", produces = MediaType.TEXT_XML_VALUE)
    public String getClientXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append(" <client>");
        sb.append("  <name>Name: Jonathan Tellez</name>");
        sb.append("  <username>Username: jontel</username>");
        sb.append(" </client>");
        sb.append("</xml>");
        return sb.toString();
    }
}
