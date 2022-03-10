package com.projectsuperior.dsmovie.services;

import com.projectsuperior.dsmovie.dto.MovieDTO;
import com.projectsuperior.dsmovie.ententy.Movie;
import com.projectsuperior.dsmovie.repositories.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll (Pageable pageable){
        Page<Movie> result = repository.findAll(pageable);
        Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
        log.info("Listou tudo da lista");
        return page;
    }
    @Transactional(readOnly = true)
    public MovieDTO findById (Long id){
        Movie result = repository.findById(id).get();
        MovieDTO dto = new MovieDTO(result);
        log.info("Busca por ID autorizada");
        return dto;
    }
}
