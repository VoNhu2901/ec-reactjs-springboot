import React, { useEffect, useState } from "react";
import useSWR from "swr";
import { fetcher } from "../apiConfig/config";
import { SwiperSlide } from "swiper/react";
import { Swiper } from "swiper/react";
import { useNavigate } from "react-router-dom";
import Button from "./../button/Button";
import ProductService from "./../../services/ProductService";

const Banner = () => {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    (async () => {
      try {
        const response = await ProductService.getAllProducts();
        // console.log(response.data);
        setMovies(response.data);
      } catch (error) {
        console.log(error.message);
      }
    })();
  }, []);

  // const { data } = useSWR(
  //   `https://api.themoviedb.org/3/movie/upcoming?api_key=43730f5bb9f1852e5e560e74083b21d4`,
  //   fetcher
  // );
  // const movies = data?.results || [];

  return (
    <>
      <section className="banner h-[500px] page-container mb-20 select-none overflow-hidden">
        <Swiper grabCursor="true" slidesPerView={"auto"}>
          {movies.length > 0 &&
            movies.map((item) => (
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
  const { id, name, productImages, category } = item;
  const navigate = useNavigate();

  return (
    <>
      <div className="w-full h-full relative">
        <div className="overplay absolute inset-0 bg-gradient-to-t from-black rounded-lg"></div>
        <img
          src={productImages[0].imgUrl}
          alt="img"
          className="w-full h-full object-fill rounded-lg"
        />
        <div className="absolute left-5 bottom-5 w-full text-white">
          <h2 className="font-bold text-3xl mb-3">{name}</h2>
          <div className="flex items-center gap-3 mb-8">
            <span className="border border-white px-4 py-2 rounded-md">
              {category.name}
            </span>
          </div>
          <Button
            onClick={() => {
              navigate(`/movie/${id}`);
            }}
          >
            Buy now
          </Button>
        </div>
      </div>
    </>
  );
}

export default Banner;
