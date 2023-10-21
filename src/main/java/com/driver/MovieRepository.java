package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;

import java.util.ArrayList;

@Repository
public class MovieRepository {

    private HashMap<String , Movie> movieMap;
    private HashMap<String , Director> directorMap;
    private HashMap<String , List<String>> directorMovieMapping;

  public MovieRepository(){
      this.movieMap = new HashMap<String , Movie>();
      this.directorMap = new HashMap<String , Director>();
      this.directorMovieMapping = new HashMap<String , List<String>>();
  }

  public void saveMovie(Movie movie){
      movieMap.put(movie.getName() , movie);
  }

  public void saveDirector(Director director){
      directorMap.put(director.getName() , director);
  }

  public void saveMovieDirectorPair(String movie , String director){
      if(movieMap.containsKey(movie)  && directorMap.containsKey(director)){
          movieMap.put(movie , movieMap.get(movie));
          directorMap.put(director , directorMap.get(director));

          List<String> currMovies = new ArrayList<String>();
          if(directorMovieMapping.containsKey(director))
              currMovies = directorMovieMapping.get(director);
          currMovies.add(movie);
          directorMovieMapping.put(director , currMovies);
      }
  }
 public Movie findMovie(String movie){
      return movieMap.get(movie);
 }

 public Director findDirector(String director){
      return directorMap.get(director);
 }

 public List<String> findMoviesFromDirector(String director){
      List<String> moviesList = new ArrayList<String>();
      if(directorMovieMapping.containsKey(director))
          moviesList = directorMovieMapping.get(director);
      return moviesList;
 }

 public List<String> findAllMovies(){
      return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
      List<String> movies = new ArrayList<String>();
      if(directorMovieMapping.containsKey(director)){
          movies = directorMovieMapping.get(director);
          for(String movie : movies){
              if(movieMap.containsKey(movie)) {
                  movieMap.remove(movie);
              }
          }
          directorMovieMapping.remove(director);
      }
     if(directorMap.containsKey(director)){
        directorMap.remove(director);
     }

    }

    public void deleteAllDirectors(){
      HashSet<String> movieSet = new HashSet<String>();

      for(String director : directorMovieMapping.keySet()){
          for(String movie : directorMovieMapping.get(director)){
              movieSet.add(movie);
          }
      }

      for(String movie : movieSet){
          if(movieMap.containsKey(movie)){
              movieMap.remove(movie);
          }
      }
    }

}
