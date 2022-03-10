package com.projectsuperior.dsmovie.ententy;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_score")
public class Score  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Embedded
    private ScorePk id = new ScorePk();

    private Double value;

    public void setUser (User user){
        id.setUser(user);
    }
    public void setMovie (Movie movie){
        id.setMovie(movie);
    }

}
