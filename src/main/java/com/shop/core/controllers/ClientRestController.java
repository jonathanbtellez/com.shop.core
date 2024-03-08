package com.shop.core.controllers;

import com.shop.core.exceptions.BadRequestException;
import com.shop.core.exceptions.ResourceNotFoundException;
import com.shop.core.models.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientRestController {
}
