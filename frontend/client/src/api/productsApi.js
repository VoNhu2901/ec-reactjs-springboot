import axiosClient from "./axiosClient";

const productApi = {
  async getAll(params) {
    var qs = require("qs");
    const response = await axiosClient.get("product/all", {
      params: {
        ...params,
      },
      paramsSerializer: (params) => {
        //ví dụ với trường hợp size=[1,2] => &size=1&size=2
        return qs.stringify(params, { arrayFormat: "repeat" });
      },
    });
    return response;
  },

  get(id) {
    const url = `/products/${id}/`;
    return axiosClient.get(url);
  },

  add(data) {
    const url = `/products/`;
    return axiosClient.post(url, data);
  },

  update(data) {
    const url = `/products/${data.id}/`;
    return axiosClient.patch(url, data);
  },

  remove(id) {
    const url = `/products/${id}/`;
    return axiosClient.delete(url);
  },
};

export default productApi;
