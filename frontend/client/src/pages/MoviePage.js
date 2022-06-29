import React, { useEffect, useState } from "react";
import useSWR from "swr";
import { apiKey, fetcher, tmdbAPI } from "../components/apiConfig/config";
import MovieCard, { MovieCardSkeleton } from "../components/movie/MovieCard";
import useDebounce from "./../hooks/useDebounce";
import ReactPaginate from "react-paginate";

// const pageCount = 5;
const itemsPerPage = 16;

const MoviePage = ({ type = "popular" }) => {
  const [pageCount, setPageCount] = useState(0);
  const [itemOffset, setItemOffset] = useState(0);

  const [nextPage, setNextPage] = useState(1);
  const [filter, setFilter] = useState("");
  const filterDebounce = useDebounce(filter, 1000);
  const [url, setUrl] = useState(tmdbAPI.getMovieListPage(type, nextPage));
  const handleFilterChange = (e) => {
    setFilter(e.target.value);
  };
  const { data, error } = useSWR(url, fetcher);
  const loading = !data && !error; //false khi co data
  const movies = data?.results || [];

  useEffect(() => {
    if (!data || !data.total_pages) return;
    // Fetch items from another resources.
    setPageCount(Math.ceil(data.total_pages / itemsPerPage));
  }, [data, itemOffset]);

  // Invoke when user click to request another page.
  const handlePageClick = (event) => {
    const newOffset = (event.selected * itemsPerPage) % data.total_pages;
    setItemOffset(newOffset);
    setNextPage(event.selected + 1);
  };

  useEffect(() => {
    if (filterDebounce) {
      setUrl(
        // tmdbAPI.getMovieSearch(filterDebounce, nextPage)
        `https://api.themoviedb.org/3/search/movie?api_key=${apiKey}&query=${filterDebounce}&page=${nextPage}`
      );
    } else {
      setUrl(tmdbAPI.getMovieListPage(type, nextPage));
    }
  }, [filterDebounce, nextPage, type]);
  if (!data) return null;

  return (
    <>
      <div className="py-10 page-container">
        {/* Thanh search */}
        <div className="flex mb-10">
          <div className="flex-1 ">
            <input
              type="text"
              className="w-full p-4 bg-transparent bg-slate-700 outline-none rounded-l-lg"
              placeholder="Type here to search..."
              onChange={handleFilterChange}
            />
          </div>
          <button className="bg-primary p-4 rounded-r-lg">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              className="h-6 w-6"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
              strokeWidth="2"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
              />
            </svg>
          </button>
        </div>
        {/* Loading */}
        {loading && (
          <>
            <div className="w-10 h-10 rounded-full border-4 border-primary border-t-transparent border-t-4 mx-auto animate-spin"></div>
            <div className="grid grid-cols-4 gap-10 page-container">
              {new Array(itemsPerPage).fill(0).map((_, index) => (
                <MovieCardSkeleton key={index} />
              ))}
            </div>
          </>
        )}

        {/* Content */}
        <div className="grid grid-cols-4 gap-10 page-container">
          {!loading &&
            movies.length > 0 &&
            movies.map((item) => (
              <MovieCard key={item.id} item={item}></MovieCard>
            ))}
        </div>
        {/* Pagination */}
        <div className="mt-10">
          <ReactPaginate
            breakLabel="..."
            nextLabel="next >"
            onPageChange={handlePageClick}
            pageRangeDisplayed={5}
            pageCount={pageCount}
            previousLabel="< previous"
            renderOnZeroPageCount={null}
            className="pagination"
          />
        </div>
      </div>
    </>
  );
};

export default MoviePage;
