import React from "react";
import { useParams } from "react-router-dom";
import useSWR from "swr";
import { apiKey, fetcher, tmdbAPI } from "../components/apiConfig/config";
import { Swiper } from "swiper/react";
import { SwiperSlide } from "swiper/react";
import MovieCard from "./../components/movie/MovieCard";

const MovieDetailPage = () => {
  const { movieId } = useParams();
  const { data, error } = useSWR(tmdbAPI.getMoiveDetails(movieId), fetcher);

  if (!data) return null;
  const { backdrop_path, poster_path, title, genres, overview } = data;

  return (
    <>
      <div className="py-10">
        <div className="w-full h-[600px] relative ">
          <div className="overplay absolute inset-0 bg-gradient-to-t from-black rounded-lg"></div>
          <div
            className="w-full h-full bg-cover bg-no-repeat rounded-lg"
            style={{
              backgroundImage: `url(${tmdbAPI.imgOriginal(backdrop_path)})`,
              // backgroundImage: `url(https://image.tmdb.org/t/p/original/${backdrop_path})`,
            }}
          ></div>
        </div>
        <div className="w-full h-[400px] max-w-[800px] mx-auto -mt-[200px] relative z-10 mb-10">
          <img
            src={tmdbAPI.imgOriginal(poster_path)}
            // src={`https://image.tmdb.org/t/p/original/${poster_path}`}
            alt=""
            className="w-full h-full object-cover rounded-xl"
          />
        </div>
        <h1 className="font-bold text-center text-4xl mb-10">{title}</h1>
        {genres.length > 0 && (
          <div className="flex items-center justify-center gap-x-5 mb-10">
            {genres.map((item) => (
              <span
                key={item.id}
                className="border border-primary text-primary py-2 px-4 rounded"
              >
                {item.name}
              </span>
            ))}
          </div>
        )}
        <p className="text-center leading-relaxed max-w-[600px] mx-auto mb-10">
          {overview}
        </p>
        <MovieCredits></MovieCredits>
        <MovieVideos></MovieVideos>
        <MovieSimilar></MovieSimilar>
      </div>
    </>
  );
};

// Utils function

// function MovieMeta({type="videos"}) {
//   const { movieId } = useParams();
//   const { data, error } = useSWR(
//     tmdbAPI.getMoiveMeta(movieId, type),
//     fetcher
//   );

//   if (!data) return null;
//   const { results } = data;
//   if (!results || results.length === 0) return null;
//   if (type === "credits") return (

//   )
      
// }

function MovieCredits() {
  return (
    <>
      <h2 className="text-center text-3xl mb-10 font-bold">Casts</h2>
      <div className="grid grid-cols-4 gap-5">
        <CastItems></CastItems>
      </div>
    </>
  );
}

function CastItems() {
  const { movieId } = useParams();
  const { data, error } = useSWR(
    tmdbAPI.getMoiveMeta(movieId, "credits"),
    fetcher
  );

  if (!data) return null;
  const { cast } = data;
  if (!cast || cast.length === 0) return null;
  return (
    <>
      {cast.slice(0, 4).map((item) => (
        <div className="cast-item" key={item.id}>
          <img
            src={tmdbAPI.imgOriginal(item.profile_path)}
            // src={`https://image.tmdb.org/t/p/original/${item.profile_path}`}
            alt=""
            className="w-full h-[350px] object-cover rounded-lg mb-3"
          />
          <h3 className="text-xl font-medium">{item.name}</h3>
        </div>
      ))}
    </>
  );
}

function MovieVideos() {
  const { movieId } = useParams();
  const { data, error } = useSWR(
    tmdbAPI.getMoiveMeta(movieId, "videos"),
    fetcher
  );

  if (!data) return null;
  const { results } = data;
  if (!results || results.length === 0) return null;
  return (
    <>
      <h2 className="text-3xl font-medium mb-2 mt-10 text-center">Trailers</h2>
      <div className="py-10 flex items-center justify-center">
        <div className="flex flex-col gap-10">
          {results.slice(0, 2).map((item) => (
            <div key={item.id}>
              <h3 className="text-xl font-medium bg-secondary inline-block p-3 mb-5 rounded-lg">
                {item.name}
              </h3>
              <div key={item.id} className="w-full aspect-video">
                <iframe
                  width="894"
                  height="511"
                  src={`https://www.youtube.com/embed/${item.key}`}
                  title={item.title}
                  frameBorder="0"
                  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                  allowFullScreen
                  className="w-[900px] h-[500px] object-fill"
                ></iframe>
              </div>
            </div>
          ))}
        </div>
      </div>
    </>
  );
}

function MovieSimilar() {
  const { movieId } = useParams();
  const { data, error } = useSWR(
    tmdbAPI.getMoiveMeta(movieId, "similar"),
    fetcher
  );

  if (!data) return null;
  const { results } = data;
  if (!results || results.length === 0) return null;
  return (
    <>
      <div className="py-10">
        <h2 className="text-3xl font-medium mb-10">Similar Movies</h2>
        <div className="movie-list">
          <Swiper grabCursor={"true"} spaceBetween={40} slidesPerView={"auto"}>
            {results.length > 0 &&
              results.map((item) => (
                <SwiperSlide key={item.id}>
                  <MovieCard item={item} />
                </SwiperSlide>
              ))}
          </Swiper>
        </div>
      </div>
    </>
  );
}

export default MovieDetailPage;
