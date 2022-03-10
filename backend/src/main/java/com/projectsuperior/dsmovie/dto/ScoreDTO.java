package com.projectsuperior.dsmovie.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScoreDTO {

    private Long movieId;
    private String email;
    private Double score;
}
