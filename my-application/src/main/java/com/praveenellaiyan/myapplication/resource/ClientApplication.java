package com.praveenellaiyan.myapplication.resource;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.praveenellaiyan.myapplication.model.Movie;

import lombok.extern.java.Log;

@RestController
@RequestMapping("/app")
@Log
public class ClientApplication {

	@Autowired
	private MovieClient movieClient;
	
	@RequestMapping(path = "/movies/all", method = RequestMethod.GET)
	public List<Movie> getMovies() {
		log.info("[ClientApplication : getMovies] fetching movies list...");
		return movieClient.getMovies();
	}
	
	@RequestMapping(path = "/movies/search", method = RequestMethod.GET)
	public Movie searchMovie(@QueryParam(value = "movie") String movie) {
		log.info("[ClientApplication : searchMovie] searching for a movie...");
		return movieClient.searchMovie(movie);
	}

}
