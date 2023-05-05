package com.logikcode.movieservicewithwebflux.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieReview {
    private String name;
    private String email;
    private String description;
    private String date;
}
