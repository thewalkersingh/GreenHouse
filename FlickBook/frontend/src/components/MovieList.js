// MovieList.js
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../styles/MovieList.css";

const MovieList = ({ movies }) => {
  const [movieList, setMovieList] = useState([]);

  //   useEffect(() => {
  //     const fetchMovies = async () => {
  //       try {
  //         const response = await axios.get("http://localhost:8080/api/movie/all");
  //         setMovies(response.data);
  //       } catch (error) {
  //         console.error("Error fetching movies", error);
  //       }
  //     };
  //     fetchMovies();
  //   }, []);

  // using dummy data
  useEffect(() => {
    setMovieList(movies);
  }, [movies]);

  return (
    <div className="movie-list">
      <h1 className="list-title">Available Movies</h1>
      <ul className="movie-items">
        {movieList.map((movie) => (
          <li key={movie.id} className="movie-item">
            <Link to={`/movies/${movie.id}`} className="movie-link">
              <img
                src={movie.imageUrl}
                alt={movie.movieTitle}
                className="movie-image"
              />
              <span className="movie-title">{movie.movieTitle}</span>
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default MovieList;
