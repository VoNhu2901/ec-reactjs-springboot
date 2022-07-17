import request from "./../utils/request";
import { API_ROUTES } from "utils/ApiRouteConstants";

const OrderService = {
  getAllOrders: async () => {
    const response = await request.get(API_ROUTES.GET_ALL_ORDERS, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("token")}`,
      },
    });
    return response;
  }
}

export default OrderService;