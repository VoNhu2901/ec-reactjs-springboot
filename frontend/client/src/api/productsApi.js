import axiosClient from "./axiosClient";

const productsApi = {
  getAll(params) {
    const url = "/product/all";

    return axiosClient.get(url, {
      params,
    });
  },
  getBookHomePage(params) {
    const url = "/books";
    console.log("page", params.filter);
    return axiosClient.get(url, {
      params,
    });
  },
};
export default productsApi;
