import React from "react";
import { signupFields } from "utils/formFields";
import { useState } from "react";
import FormAction from "./FormAction";
import Input from "components/input/Input";
import { useForm } from 'react-hook-form';
import AuthService from "services/AuthService";
import { Navigate } from 'react-router-dom';

const fixedInputClass =
  "mb-15 rounded-md appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 focus:outline-none focus:ring-purple-500 focus:border-purple-500 focus:z-10 sm:text-sm";
const submitClass =
  "group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-purple-600 hover:bg-purple-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500 mt-10";



const SignUp = () => {
const { register, handleSubmit } = useForm();
const [error, setError] = useState("");
const [role, setRole] = useState();
const onSubmit = (data) => {
  console.log(data);
  AuthService.register(data)
    .then((res) => {
      sessionStorage.clear();
      localStorage.setItem("token", res.data.accessToken);
      localStorage.setItem("accId", res.data.accId);
      localStorage.setItem("username", res.data.username);
      setRole(res.data.role);
    })
    .catch((error) => {
      setError("Register failed");
      console.log(error);
    });
};

  
 
  return (
    <>
      {role === "USER" && <Navigate to={"/product"}></Navigate>}
      {role === "ADMIN" && <Navigate to={"/admin"}></Navigate>}
      <div className="flex justify-center mb-16">
        {error && <div className="text-primary">{error}</div>}
        <form
          className="mt-2 space-y-6 w-[500px]"
          onSubmit={handleSubmit(onSubmit)}
        >
          <div className="">
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

            <label htmlFor="username">Email address</label>
            <input
              {...register("email", {
                required: true,
                maxLength: 20,
              })}
              type="email"
              placeholder="Email address"
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

            <label htmlFor="password">Confirm Password</label>
            <input
              {...register("confirmPassword", {
                required: true,
                maxLength: 20,
              })}
              type="password"
              placeholder="Confirm Password"
              className={fixedInputClass}
            />

            <label htmlFor="password">Phone Number</label>
            <input
              {...register("phoneNumber", {
                required: true,
                maxLength: 20,
              })}
              type="text"
              placeholder="Phone Number"
              className={fixedInputClass}
            />

            <label htmlFor="password">Address</label>
            <input
              {...register("address", {
                required: true,
                maxLength: 20,
              })}
              type="text"
              placeholder="Address"
              className={fixedInputClass}
            />

            <input
              type="submit"
              className={submitClass}
              value={"Sign Up"}
            />
          </div>
        </form>
      </div>
    </>
  );
};

export default SignUp;
