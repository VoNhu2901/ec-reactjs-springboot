import { API_ROUTES } from "utils/ApiRouteConstants";
import request from "./../utils/request";

const CartService = {
  getCartByAccId: async (accId) => {
    const response = await request.get(API_ROUTES.GET_CART_BY_ACC_ID + accId, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("token")}`,
      },
    });
    return response;
  },
  addProductToCart: async (cart) => {
    const response = await request.post(API_ROUTES.ADD_PRODUCT_TO_CART, cart, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("token")}`,
      },
    });
    return response;
  }
};

export default CartService;
