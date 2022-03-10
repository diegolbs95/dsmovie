package com.projectsuperior.dsmovie.repositories;

import com.projectsuperior.dsmovie.ententy.Score;
import com.projectsuperior.dsmovie.ententy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
