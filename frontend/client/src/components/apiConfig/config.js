export const fetcher = (...args) => fetch(...args).then((res) => res.json());
export const apiKey = "43730f5bb9f1852e5e560e74083b21d4";
const tmdEndPoint = "https://api.themoviedb.org/3/movie";
export const tmdbAPI = {
  getMovieList: (type = "popular") => `${tmdEndPoint}/${type}?api_key=${apiKey}`,
  getMovieListPage: (type = "popular", page = 1) => `${tmdEndPoint}/${type}?api_key=${apiKey}&page=${page}`,
  getMovieSearch: (query = "", page=1) => `${tmdEndPoint}/search/movie?api_key=${apiKey}&query=${query}&page=${page}`,
  getMoiveDetails: (id) => `${tmdEndPoint}/${id}?api_key=${apiKey}`,
  getMoiveMeta: (id, type) => `${tmdEndPoint}/${id}/${type}?api_key=${apiKey}`,
  imgOriginal: (path) => `https://image.tmdb.org/t/p/original/${path}`,
  img500: (path) => `https://image.tmdb.org/t/p/w500/${path}`,
}