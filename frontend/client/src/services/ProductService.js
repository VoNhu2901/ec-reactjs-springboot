import { API_ROUTES } from 'utils/ApiRouteConstants';
import request from './../utils/request';

export const getAllProducts = async () => {
  try {
    const response = await request.get(API_ROUTES.PRODUCT_ALL);
    // return response.data;
    console.log("🚀 ~ file: ProductService.js ~ line 8 ~ getAllProducts ~ response", response)
  }
  catch (error) {
    console.log(error);
  }
}

// export const getProductById = async (id) => {
//   try {
//     const response = await request.get(API_ROUTES.PRODUCT_BY_ID + id);
//     return response.data;
//   }
//   catch (error) {
//     console.log(error);
//   }
// }

// export const getProductByName = async (name) => {
//   try {
//     const response = await request.get(API_ROUTES.PRODUCT_BY_NAME + name);
//     return response.data;
//   }
//   catch (error) {
//     console.log(error);
//   }
// }