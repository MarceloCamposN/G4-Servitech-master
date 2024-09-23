package com.example.avancetf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200","http://18.216.202.149/"})
@RestController
@RequestMapping("/api")
public class PagoController {
}
