import React from 'react';
import request from './../utils/request';
import { API_ROUTES } from 'utils/ApiRouteConstants';

const CategoryService = {
  getAllCategories: async () => {
    const response = await request.get(API_ROUTES.GET_ALL_CATEGORIES, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("token")}`,
      },
    });
    return response;
  },
  getCategoryById: async (id) => {
    const response = await request.get(API_ROUTES.GET_CATEGORY_BY_ID);
    return response.data;
  },
  updateCategory: async (category) => {
    const response = await request.put(API_ROUTES.UPDATE_CATEGORY, category);
    return response;
  },
  createCategory: async (category) => {
    const response = await request.post(API_ROUTES.CREATE_CATEGORY, category);
    return response;
  },
};

export default CategoryService;