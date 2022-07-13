import CategoryCard from 'components/category/CategoryCard';
import React from 'react';
import MovieList from './../components/movie/MovieList';
// import Banner from './../components/banner/Banner';

const HomePage = () => {
  return (
    <>
      <div className="flex gap-16">
        <CategoryCard></CategoryCard>
        <div>
          <section className="movies-layout page-container pb-20">
            <h2 className="capitalize text-white mb-10 text-3xl font-bold">
              Now playing
            </h2>
            <MovieList></MovieList>
          </section>
          <section className="movies-layout page-container pb-20">
            <h2 className="capitalize text-white mb-10 text-3xl font-bold">
              Top rated
            </h2>
            <MovieList type="top_rated"></MovieList>
          </section>
          <section className="movies-layout page-container pb-10">
            <h2 className="capitalize text-white mb-10 text-3xl font-bold">
              Treding
            </h2>
            <MovieList type="popular"></MovieList>
          </section>
        </div>
      </div>
    </>
  );
};

export default HomePage;