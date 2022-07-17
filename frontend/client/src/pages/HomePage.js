import CategoryCard from "components/category/CategoryCard";
import React from "react";
import ProductList from "../components/product/ProductList";
// import Banner from './../components/banner/Banner';

const HomePage = () => {
  return (
    <>
      <div className="gap-16">
       

        <div>
          <section className="movies-layout page-container pb-20">
            <h2 className="capitalize text-white mb-10 text-3xl font-bold">
              Now playing
            </h2>
            <ProductList></ProductList>
          </section>
          <section className="movies-layout page-container pb-20">
            <h2 className="capitalize text-white mb-10 text-3xl font-bold">
              Top rated
            </h2>
            <ProductList></ProductList>
          </section>
        </div>
      </div>
    </>
  );
};

export default HomePage;
