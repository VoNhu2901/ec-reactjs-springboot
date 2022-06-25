import React from "react";
import useSWR from "swr";
import { fetcher } from "../../config";
import { SwiperSlide } from 'swiper/react';
import { Swiper } from 'swiper/react';

const Banner = () => {
  const { data, error } = useSWR(
    `https://api.themoviedb.org/3/movie/upcoming?api_key=43730f5bb9f1852e5e560e74083b21d4`,
    fetcher
  );
  // const movies = data ? data.results : [];
  const movies = data?.results || [];
  console.log("🚀 ~ file: Banner.js ~ line 14 ~ Banner ~ movies", movies)
  return (
    <>
      <section className="banner h-[500px] page-container mb-20 select-none overflow-hidden">
        <Swiper grabCursor="true" slidesPerView={"auto"}>
          {movies.length > 0 && movies.map((item) => (
            <SwiperSlide key={item.id}>
              <BannerItem item={item}></BannerItem>
            </SwiperSlide>
          ))}
        </Swiper>
      </section>
    </>
  );
};

function BannerItem({ item }) {
  const {title, poster_path } = item;
  return (
    <>
      <div className="w-full h-full relative">
        <div className="overplay absolute inset-0 bg-gradient-to-t from-black rounded-lg"></div>
        <img
          src={`https://image.tmdb.org/t/p/w500/${poster_path}`}
          alt="img"
          className="w-full h-full object-cover rounded-lg"
        />
        <div className="absolute left-5 bottom-5 w-full text-white">
          <h2 className="font-bold text-3xl mb-3">{title}</h2>
          <div className="flex items-center gap-3 mb-8">
            <span className="border border-white px-4 py-2 rounded-md">
              Adventure
            </span>
            <span className="border border-white px-4 py-2 rounded-md">
              Adventure
            </span>
            <span className="border border-white px-4 py-2 rounded-md">
              Adventure
            </span>
          </div>
          <button className="font-bold bg-primary px-6 py-3 rounded-lg">
            Wacth Now
          </button>
        </div>
      </div>
    </>
  );
}

export default Banner;
