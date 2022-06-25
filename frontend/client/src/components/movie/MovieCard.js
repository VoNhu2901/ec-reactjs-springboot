import React from 'react';
import { useNavigate } from 'react-router-dom';

const MovieCard = ({ item }) => {
  const { id, title, release_date, poster_path, vote_average } = item;
  const navigate = useNavigate();
  return (
    <>
      <div className="movie-card flex flex-col rounded-lg p-3 bg-slate-800 h-full select-none" key={id}>
        <img
          src={`https://image.tmdb.org/t/p/w500/${poster_path}`}
          alt="img"
          className="w-full h-[250px] object-cover rounded-lg mb-5"
        />
        <div className="flex flex-col flex-1">

        <h3 className="font-bold text-xl mb-3">{title}</h3>
        <div className="flex items-center justify-between opacity-50 mb-10 ">
          <span>{new Date(release_date).getFullYear()}</span>
          <span>{vote_average}</span>
        </div>
          <button className="bg-primary px-6 py-4 rounded-md w-full mt-auto" onClick={() => {
            navigate(`/movie/${id}`)
        }}>
          Wacth Now
        </button>
        </div>
      </div>
    </>
  );
};

export default MovieCard;