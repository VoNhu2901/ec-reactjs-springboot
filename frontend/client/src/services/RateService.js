import { API_ROUTES } from "utils/ApiRouteConstants";
import request from "./../utils/request";

const RateService = {
  getAllRates: async () => {
    const response = await request.get(API_ROUTES.GET_ALL_RATES,
      {
        headers: {
          Authorization: `Bearer ${localStorage.getItem('token')}`,
        },
      }
    );
    return response;
  },
  addNewRate: async (data) => {
    const response = await request.post(API_ROUTES.ADD_NEW_RATE, data);
    return response;
  }
}

export default RateService;