package com.projectsuperior.dsmovie.services;

import com.projectsuperior.dsmovie.dto.MovieDTO;
import com.projectsuperior.dsmovie.dto.ScoreDTO;
import com.projectsuperior.dsmovie.ententy.Movie;
import com.projectsuperior.dsmovie.ententy.Score;
import com.projectsuperior.dsmovie.ententy.User;
import com.projectsuperior.dsmovie.repositories.MovieRepository;
import com.projectsuperior.dsmovie.repositories.ScoreRepository;
import com.projectsuperior.dsmovie.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore (ScoreDTO dto){
        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        var score = new Score();
        score.setMovie(movie);
        score.setValue(dto.getScore());
        score.setUser(user);

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum += s.getValue();
        }
        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return  new MovieDTO(movie);
    }
}
