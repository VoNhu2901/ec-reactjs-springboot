import React, { useEffect, useState } from "react";
import { Swiper, SwiperSlide } from "swiper/react";
import ProductCard, { ProductCardSkeleton } from "./ProductCard";
import CategoryService from "services/CategoryService";
import ProductService from "services/ProductService";

const ProductList = ({ type = "now_playing" }) => {
  const [cate, setCate] = useState([]);
  const [selected, setSelected] = useState(0);
  const [product, setProduct] = useState([]);


  const isLoading = !product;


const getData = async () => {
  CategoryService.getAllCategories().then((res) => {
    setCate(res.data);
  });

  const id = selected === 0 ? "all" : selected;
  ProductService.getAllProductTradingByCateId(id).then((res) => {
    setProduct(res.data);
  });
};

useEffect(() => {
  getData();
}, [selected]);



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
          {product.length > 0 &&
            product.map((item, index) => (
              <SwiperSlide key={index}>
                <ProductCard item={item} />
              </SwiperSlide>
            ))}
        </Swiper>
      </div>
    </>
  );
};

export default ProductList;
