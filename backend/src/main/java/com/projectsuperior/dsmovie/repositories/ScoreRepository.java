package com.projectsuperior.dsmovie.repositories;

import com.projectsuperior.dsmovie.ententy.Movie;
import com.projectsuperior.dsmovie.ententy.Score;
import com.projectsuperior.dsmovie.ententy.ScorePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePk> {
}
