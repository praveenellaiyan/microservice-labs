package com.praveenellaiyan.springconfigclientpractice.resource;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.praveenellaiyan.springconfigclientpractice.model.Movie;

@RestController
@RequestMapping("/app")
public class ClientApplication {

	@Autowired
	private MovieClient movieClient;
	
	@RequestMapping(path = "/movies/all", method = RequestMethod.GET)
	public List<Movie> getMovies() {
		return movieClient.getMovies();
	}
	
	@RequestMapping(path = "/movies/search", method = RequestMethod.GET)
	public Movie searchMovie(@QueryParam(value = "movie") String movie) {
		return movieClient.searchMovie(movie);
	}

}
