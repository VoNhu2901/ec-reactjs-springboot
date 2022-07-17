export const API_URL = "http://localhost:8080/api/v1";
export const API_ROUTES = {
  //product
  GET_ALL_PRODUCTS: "/product/all", //use
  GET_ALL_PRODUCT_TRADING_BY_CATE_ID: "/product/category/",  //use
  GET_PRODUCT_BY_ID: "/product/", //use
  GET_PRODUCT_BY_CATEGORY: "/product/category/:categoryId",
  UPDATE_PRODUCT: "/product/update",
  CREATE_PRODUCT: "/product/create",
  DELETE_PRODUCT: "/product/delete/:id",
  //category
  GET_ALL_CATEGORIES: "/category", //use
  GET_CATEGORY_BY_ID: "/category/:id",
  UPDATE_CATEGORY: "/category/update",
  CREATE_CATEGORY: "/category/create",
  DELETE_CATEGORY: "/category/delete/:id",
  //rate
  GET_ALL_RATES: "/rate/all",
  ADD_NEW_RATE: "/rate",
  // cart
  GET_CART_BY_ACC_ID: "/cart/", //use
  ADD_PRODUCT_TO_CART: "/cart", //use
  //image
  DELETE_PRODUCT_IMAGE: "/product-image/delete/:id",
  //user
  GET_ALL_USERS: "/user/all",
  GET_USER_BY_ID: "/user/:id",
  UPDATE_USER: "/user/update",
  CREATE_USER: "/user/create",
  DELETE_USER: "/user/delete/:id",
  //order
  GET_ALL_ORDERS: "/order/all",
  GET_ORDER_BY_ID: "/order/:id",
  UPDATE_ORDER: "/order/update",
  CREATE_ORDER: "/order/create",
  DELETE_ORDER: "/order/delete/:id",
  //order-detail
  GET_ALL_ORDER_DETAILS: "/order-detail/all",
  GET_ORDER_DETAIL_BY_ID: "/order-detail/:id",
  UPDATE_ORDER_DETAIL: "/order-detail/update",
  CREATE_ORDER_DETAIL: "/order-detail/create",
  DELETE_ORDER_DETAIL: "/order-detail/delete/:id",
  //cart
  GET_ALL_CARTS: "/cart/all",
  GET_CART_BY_ID: "/cart/:id",
  UPDATE_CART: "/cart/update",
  CREATE_CART: "/cart/create",
  DELETE_CART: "/cart/delete/:id",
  //cart-detail
  GET_ALL_CART_DETAILS: "/cart-detail/all",
  GET_CART_DETAIL_BY_ID: "/cart-detail/:id",
  UPDATE_CART_DETAIL: "/cart-detail/update",
  CREATE_CART_DETAIL: "/cart-detail/create",
  DELETE_CART_DETAIL: "/cart-detail/delete/:id",
  //order-status
  GET_ALL_ORDER_STATUS: "/order-status/all",

  //login
  LOGIN: "/auth/signin", //use
  //logout
  LOGOUT: "/auth/logout",
  //register
  REGISTER: "/auth/register", //use
  //user-role
  GET_ALL_USER_ROLES: "/user-role/all",
  GET_USER_ROLE_BY_ID: "/user-role/:id",
  UPDATE_USER_ROLE: "/user-role/update",
  CREATE_USER_ROLE: "/user-role/create",
  DELETE_USER_ROLE: "/user-role/delete/:id",
};