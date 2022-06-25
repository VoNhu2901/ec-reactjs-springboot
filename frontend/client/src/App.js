import { Fragment } from "react";
import { NavLink } from "react-router-dom";


import MovieList from "./components/movie/MovieList";

function App() {
  return (
    <Fragment>
      <header className="header flex items-center justify-center gap-x-5 text-white py-10 mb-5">
        <span className="text-primary">Home</span>
        <span>Movies</span>
      </header>
      <section className="banner h-[500px] page-container mb-20">
        <div className="w-full h-full relative">
          <div className="overplay absolute inset-0 bg-gradient-to-t from-black rounded-lg"></div>
          <img
            src="https://cdnimg.vietnamplus.vn/t1200/Uploaded/Mtpyelagtpy/2019_04_29/avengersendgame2904.jpg"
            alt="img"
            className="w-full h-full object-cover rounded-lg"
          />
          <div className="absolute left-5 bottom-5 w-full text-white">
            <h2 className="font-bold text-3xl mb-3">Avengers: Endgame</h2>
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
      </section>

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
        <div className="movie-list grid grid-cols-4 gap10">
          <div className="movie-card rounded-lg p-3 bg-slate-800">
            <img
              src="https://cdnimg.vietnamplus.vn/t1200/Uploaded/Mtpyelagtpy/2019_04_29/avengersendgame2904.jpg"
              alt="img"
              className="w-full h-[250px] object-cover rounded-lg mb-5"
            />
            <h3 className="font-bold text-xl mb-3">Spiderman: Homecpming</h3>
            <div className="flex items-center justify-between opacity-50 mb-10">
              <span>2017</span>
              <span>7.4</span>
            </div>
            <button className="bg-primary px-6 py-4 rounded-md w-full">
              Wacth Now
            </button>
          </div>
        </div>
      </section>
      <section className="movies-layout page-container pb-10">
        <h2 className="capitalize text-white mb-10 text-3xl font-bold">
          Treding
        </h2>
        <div className="movie-list grid grid-cols-4 gap10">
          <div className="movie-card rounded-lg p-3 bg-slate-800">
            <img
              src="https://cdnimg.vietnamplus.vn/t1200/Uploaded/Mtpyelagtpy/2019_04_29/avengersendgame2904.jpg"
              alt="img"
              className="w-full h-[250px] object-cover rounded-lg mb-5"
            />
            <h3 className="font-bold text-xl mb-3">Spiderman: Homecpming</h3>
            <div className="flex items-center justify-between opacity-50 mb-10">
              <span>2017</span>
              <span>7.4</span>
            </div>
            <button className="bg-primary px-6 py-4 rounded-md w-full">
              Wacth Now
            </button>
          </div>
        </div>
      </section>
    </Fragment>
  );
}

export default App;
