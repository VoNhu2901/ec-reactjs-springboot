import { API_ROUTES } from 'utils/ApiRouteConstants';
import request from './../utils/request';

import React from 'react';

const ProductService = {
  getAllProducts: async () => {
    const response = await request.get(API_ROUTES.GET_ALL_PRODUCTS);
    return response;
  },
  getProductById: async (id) => {
    const response = await request.get(API_ROUTES.GET_PRODUCT_BY_ID + id);
    return response;
  },
  getProductByCategory: async (categoryId) => {
    const response = await request.get(API_ROUTES.GET_PRODUCT_BY_CATEGORY + categoryId);
    return response;
  },
  updateProduct: async (product) => {
    const response = await request.put(API_ROUTES.UPDATE_PRODUCT, product);
    return response;
  },
  createProduct: async (product) => {
    const response = await request.post(API_ROUTES.CREATE_PRODUCT, product);
    return response;
  },
  deleteProduct: async (id) => {
    const response = await request.delete(API_ROUTES.DELETE_PRODUCT + id);
    return response;
  }  
}

export default ProductService;