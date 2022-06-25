import React from 'react';
import { Swiper, SwiperSlide } from 'swiper/react';
import "swiper/css";
import MovieCard from './MovieCard';
import useSWR from "swr";
import { fetcher } from '../../config';



// https://api.themoviedb.org/3/movie/now_playing?api_key=<<api_key>>
// https://api.themoviedb.org/3/movie/550?api_key=43730f5bb9f1852e5e560e74083b21d4
const MovieList = () => {
  const { data, error } = useSWR("/api/user/123", fetcher);
  return (
    <>
      <div className="movie-list">
        <Swiper grabCursor={"true"} spaceBetween={40} slidesPerView={"auto"}>
          <SwiperSlide>
            <MovieCard />
          </SwiperSlide>
          <SwiperSlide>
            <MovieCard />
          </SwiperSlide>
          <SwiperSlide>
            <MovieCard />
          </SwiperSlide>
          <SwiperSlide>
            <MovieCard />
          </SwiperSlide>
        </Swiper>
      </div>
    </>
  );
};

export default MovieList;