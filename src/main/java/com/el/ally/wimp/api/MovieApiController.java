package com.el.ally.wimp.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.wimp.models.Movie;
import com.el.ally.wimp.repositories.MovieRepository;

@RestController
@RequestMapping("/api/Movie")
public class MovieApiController {

  private MovieRepository MovieRepo;

  public MovieApiController(MovieRepository MovieRepo) {
    this.MovieRepo = MovieRepo;
  }

  @GetMapping("")
  public List<Movie> getAll() {
    return MovieRepo.findAll();
  }

  @GetMapping("{id}")
  public Movie getOne(@PathVariable int id) {
    return MovieRepo.findOne(id);
  }

  @PostMapping("")
  public Movie create(@RequestBody Movie Movie) {
    return MovieRepo.save(Movie);
  }

  @PutMapping("{id}")
  public Movie update(@RequestBody Movie Movie, @PathVariable int id) {
    Movie.setId(id);
    return MovieRepo.save(Movie);
  }

  @DeleteMapping("{id}")
  public Movie delete(@PathVariable int id) {
    Movie Movie = MovieRepo.findOne(id);
    MovieRepo.delete(id);
    return Movie;
  }

}