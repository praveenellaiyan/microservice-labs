package com.praveenellaiyan.movieservice.resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.praveenellaiyan.movieservice.model.Movie;

import lombok.extern.java.Log;

@RestController
@RequestMapping("/movies")
@Log
public class MovieResource {
	
	BiPredicate<String, String> movieP = (m1, m2) -> m1.equalsIgnoreCase(m2);

	private List<Movie> movies =
			//Arrays.asList(new Movie("Psycho", "Kollywood"), new Movie("96", "Kollywood"), new Movie("KD Karuapdurai", "Kollywood"));
			Arrays.asList(new Movie("Silicon Valley", "Hollywood"), new Movie("Game of thrones", "Hollywood"), new Movie("Vikings", "Hollywood"));

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<Movie> getMovies() {
		log.info("[MovieResource: GetAllMovies] fetching movie list...");
		return movies;
	}

	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public Movie findMovie(@RequestParam(value = "movie") String movie) {
		log.info("[MovieResource: FindMovie] Searching for movie...");
		Optional<Movie> result = movies
									.stream()
									.filter(film -> movieP.test(film.getName(), movie))
									.findFirst();
		if(result.isPresent()) {
			return result.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found!");
		}
	}

}