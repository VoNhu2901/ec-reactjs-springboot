import React, { useEffect } from "react";
import { useState } from "react";
import { useForm } from "react-hook-form";
import FormExtra from "./FormExtra";
import FormAction from "./FormAction";
import AuthService from "services/AuthService";
import { Navigate } from "react-router-dom";

const fixedInputClass =
  "mb-15 rounded-md appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 focus:outline-none focus:ring-purple-500 focus:border-purple-500 focus:z-10 sm:text-sm";

const submitClass = "group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-purple-600 hover:bg-purple-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500 mt-10";

const Login = () => {
  const {
    register,
    handleSubmit
  } = useForm();
  const [role, setRole] = useState();
  useEffect(() => {
    localStorage.clear();
  }, []);

  const onSubmit = (data) => {
    AuthService.login(data)
      .then((res) => {
        sessionStorage.clear();
        localStorage.setItem("token", res.data.accessToken);
        localStorage.setItem("accId", res.data.accId);
        localStorage.setItem("username", res.data.username);
        setRole(res.data.role);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <>
      <div className="h-80 flex justify-center">
        {role === "USER" && <Navigate to={"/product"}></Navigate>}
        {role === "ADMIN" && <Navigate to={"/admin"}></Navigate>}
        <form
          className="mt-2 space-y-6 w-[500px] "
          onSubmit={handleSubmit(onSubmit)}
        >
          <div className="-space-y-px ">
            <label htmlFor="username">Username</label>
            <input
              {...register("username", {
                required: true,
                maxLength: 20,
              })}
              type="text"
              placeholder="Username"
              className={fixedInputClass}
            />

            <label htmlFor="password">Password</label>
            <input
              {...register("password", {
                required: true,
                maxLength: 20,
              })}
              type="password"
              placeholder="Password"
              className={fixedInputClass}
            />
          </div>

          <FormExtra />
          <input
            type="submit"
            className={submitClass}
            value={"Log In"}
          />
        </form>
      </div>
    </>
  );
};

export default Login;
