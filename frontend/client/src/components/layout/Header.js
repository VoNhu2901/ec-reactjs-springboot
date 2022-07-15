import React from "react";
import { NavLink } from "react-router-dom";

const Header = () => {
  return (
    <>
      <header className="header flex justify-between gap-x-5 flex-nowrap text-white py-10 mb-5">
        <div className="flex items-center justify-center gap-x-5">
          <NavLink to="/" className="text-white">
            <img
              src={process.env.PUBLIC_URL + "/assets/logo.jpg"}
              alt="logo"
              className="w-20 h-16 rounded-xl"
            />
          </NavLink>
          <NavLink
            to="/"
            className={({ isActive }) => (isActive ? "text-primary" : "")}
          >
            Home
          </NavLink>
          <NavLink
            to="/movies"
            className={({ isActive }) => (isActive ? "text-primary" : "")}
          >
            Sản phẩm
          </NavLink>
          <NavLink
            to="/product/id"
            className={({ isActive }) => (isActive ? "text-primary" : "")}
          >
            Chi tiet
          </NavLink>
          <NavLink
            to="/cart"
            className={({ isActive }) => (isActive ? "text-primary" : "")}
          >
            Cart
          </NavLink>
        </div>
        <div className="flex items-center justify-center gap-x-5">
          <NavLink
            to="/login"
            className={({ isActive }) => (isActive ? "text-primary" : "")}
          >
            Log In
          </NavLink>
          <NavLink
            to="/signup"
            className={({ isActive }) => (isActive ? "text-primary" : "")}
          >
            Sign Up
          </NavLink>
        </div>
      </header>
    </>
  );
};

export function FormLoginSignup({
  heading,
  paragraph,
  linkName,
  linkUrl = "/login",
}) {
  return (
    <>
      <div className="mb-10">
        <div className="flex justify-center items-center">
          <img
            alt=""
            className="h-14 w-14"
            src="https://ik.imagekit.io/pibjyepn7p9/Lilac_Navy_Simple_Line_Business_Logo_CGktk8RHK.png?ik-sdk-version=javascript-1.4.3&updatedAt=1649962071315"
          />
        </div>
        <h2 className="mt-6 text-center text-3xl font-extrabold text-gray-900">
          {heading}
        </h2>
        <p className="mt-2 text-center text-sm text-gray-400 mt-5">
          {paragraph}{" "}
          <NavLink
            to={linkUrl}
            className="font-medium text-purple-600 hover:text-purple-500"
          >
            {linkName}
          </NavLink>
        </p>
      </div>
    </>
  );
}

export default Header;
