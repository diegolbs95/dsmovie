package com.projectsuperior.dsmovie.controllers;

import com.projectsuperior.dsmovie.dto.MovieDTO;
import com.projectsuperior.dsmovie.dto.ScoreDTO;
import com.projectsuperior.dsmovie.repositories.ScoreRepository;
import com.projectsuperior.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto){
        var movieDTO = service.saveScore(dto);
        return movieDTO;
    }
}
