import { API_ROUTES } from "utils/ApiRouteConstants";
import request from "utils/request";


const AccountService = {
  getAllUsers: async () => {
    const response = await request.get(API_ROUTES.GET_ALL_USERS);
    return response;
  },
  getUserById: async (id) => {
    const response = await request.get(API_ROUTES.GET_USER_BY_ID + id);
    return response;
  },
  updateUser: async (user) => {
    const response = await request.put(API_ROUTES.UPDATE_USER, user);
    return response;
  },
  createUser: async (user) => {
    const response = await request.post(API_ROUTES.CREATE_USER, user);
    return response;
  },
  deleteUser: async (id) => {
    const response = await request.delete(API_ROUTES.DELETE_USER + id);
    return response;
  }
}

export default AccountService;