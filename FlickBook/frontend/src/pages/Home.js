import { movies } from "../api/movieData";
import MovieList from "../components/MovieList";

const Home = () => {
  return (
    <div>
      {" "}
      <h1>Welcome to the Movie Booking App</h1> <MovieList movies={movies} />{" "}
    </div>
  );
};
export default Home;
