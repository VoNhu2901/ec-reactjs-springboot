// https://www.loginradius.com/blog/engineering/guest-post/modern-login-signup-form-tailwindcss-react/
import { API_ROUTES } from 'utils/ApiRouteConstants';
import request from 'utils/request';

const AuthService = {
  login: async (loginFields) => {
    const response = await request.post(API_ROUTES.LOGIN, loginFields);
    return response;
  },
  register: async (registerFields) => {
    const response = await request.post(API_ROUTES.REGISTER, registerFields);
    return response;
  }
}

export default AuthService;