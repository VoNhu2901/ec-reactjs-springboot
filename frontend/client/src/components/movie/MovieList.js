import React, { useEffect, useState } from "react";
import { Swiper, SwiperSlide } from "swiper/react";
import ProductCard, { ProductCardSkeleton } from "./ProductCard";
import useSWR from "swr";
import { apiKey, fetcher } from "../apiConfig/config";
import { tmdbAPI } from "../apiConfig/config";

const MovieList = ({ type = "now_playing" }) => {
  const { data, error } = useSWR(tmdbAPI.getMovieList(type), fetcher);
  const isLoading = !data && !error;

  const movies = data?.results || [];

  return (
    <>
      <div className="movie-list">
        {/* skeleton */}
        {isLoading && (
          <>
            <Swiper
              grabCursor={"true"}
              spaceBetween={40}
              slidesPerView={"auto"}
            >
              <SwiperSlide>
                <ProductCardSkeleton></ProductCardSkeleton>
              </SwiperSlide>
              <SwiperSlide>
                <ProductCardSkeleton></ProductCardSkeleton>
              </SwiperSlide>
              <SwiperSlide>
                <ProductCardSkeleton></ProductCardSkeleton>
              </SwiperSlide>
              <SwiperSlide>
                <ProductCardSkeleton></ProductCardSkeleton>
              </SwiperSlide>
            </Swiper>
          </>
        )}
        {/* end skeleton */}

        <Swiper grabCursor={"true"} spaceBetween={40} slidesPerView={"auto"}>
          {movies.length > 0 &&
            movies.map((item) => (
              <SwiperSlide key={item.id}>
                <ProductCard item={item} />
              </SwiperSlide>
            ))}
        </Swiper>
      </div>
    </>
  );
};

export default MovieList;
