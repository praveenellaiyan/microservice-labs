package com.praveenellaiyan.myapplication.resource;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.praveenellaiyan.myapplication.model.Movie;

@FeignClient(name = "${movies.client}", decode404 = true)
public interface MovieClient {
	
	@RequestMapping(path = "${movies.all}", method = RequestMethod.GET)
	List<Movie> getMovies();
	
	@RequestMapping(path = "${movies.search}", method = RequestMethod.GET)
	Movie searchMovie(@RequestParam(value = "movie") String movie);

}
