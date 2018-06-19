package com.el.ally.wimp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.wimp.models.Actor;
import com.el.ally.wimp.models.Movie;
import com.el.ally.wimp.repositories.ActorRepository;
import com.el.ally.wimp.repositories.MovieRepository;

@RestController
@RequestMapping("/api/movie")
public class MovieApiController {

  private MovieRepository movieRepo;
  
  @Autowired
  private ActorRepository actorRepo;

  public MovieApiController(MovieRepository movieRepo) {
    this.movieRepo = movieRepo;
  }

  @GetMapping("")
  public List<Movie> getAll() {
    return movieRepo.findAll();
  }

  @GetMapping("{id}")
  public Movie getOne(@PathVariable int id) {
    return movieRepo.findOne(id);
  }

  @PostMapping("")
  public Movie create(@RequestBody Movie Movie) {
    return movieRepo.save(Movie);
  }
  
  @PostMapping("{movieId}/actor")
  public Movie associate(@PathVariable int movieId, @RequestBody Actor jsonActor) {
	  Movie movie = movieRepo.findOne(movieId);
	  Actor actor = actorRepo.findOne(jsonActor.getId());
	  movie.addActor(actor);
	  movieRepo.save(movie);
	  return movie;
  }

  @PutMapping("{id}")
  public Movie update(@RequestBody Movie Movie, @PathVariable int id) {
    Movie.setId(id);
    return movieRepo.save(Movie);
  }

  @DeleteMapping("{id}")
  public Movie delete(@PathVariable int id) {
    Movie Movie = movieRepo.findOne(id);
    movieRepo.delete(id);
    return Movie;
  }

}