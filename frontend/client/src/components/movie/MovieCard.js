import React from 'react';

const MovieCard = () => {
  return (
    <>
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
    </>
  );
};

export default MovieCard;