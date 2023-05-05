package com.logikcode.movieservicewithwebflux.repository;

import com.logikcode.movieservicewithwebflux.model.MovieInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieInfoRepository extends ReactiveMongoRepository<MovieInfo, String> {

}
