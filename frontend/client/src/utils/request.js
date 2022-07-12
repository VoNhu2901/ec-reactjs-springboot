import { axios } from 'axios';
import { API_URL } from './ApiRouteConstants';

const request = axios.create({
  baseURL: API_URL,
  headers: {
    "Content-Type": "application/json",
  },
});

export default request;