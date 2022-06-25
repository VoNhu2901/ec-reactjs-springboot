import React from "react";
import MovieList from "./../components/movie/MovieList";
import useSWR from "swr";
import { apiKey, fetcher } from "./../config";
import MovieCard from "../components/movie/MovieCard";

const MoviePage = ({ type = "popular" }) => {
  const { data, error } = useSWR(
    `https://api.themoviedb.org/3/movie/${type}?api_key=${apiKey}`,
    fetcher
  );
  const movies = data?.results || [];

  return (
    <>
      <div className="py-10 page-container">
        {/* Thanh search */}
        <div className="flex mb-10">
          <div className="flex-1 ">
            <input
              type="text"
              className="w-full p-4 bg-transparent bg-slate-700 outline-none rounded-l-lg"
              placeholder="Type here to search..."
            />
          </div>
          <button className="bg-primary p-4 rounded-r-lg">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              className="h-6 w-6"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
              strokeWidth="2"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
              />
            </svg>
          </button>
        </div>
        {/* Content */}
        <div className="grid grid-cols-4 gap-10 page-container">
          {movies.length > 0 &&
            movies.map((item) => (
              <MovieCard key={item.id} item={item}></MovieCard>
            ))}
        </div>
      </div>
    </>
  );
};

export default MoviePage;
