import React, { useEffect, useState } from "react";
import { NavLink, useNavigate } from "react-router-dom";

const Header = () => {
  const [username, setUsername] = useState();
   const navigate = useNavigate();

  useEffect(() => {
    const isExistUsername = localStorage.getItem("username");
    if (isExistUsername) {
      setUsername(isExistUsername);
    }
  }
    , []);
  
  const handleLogout = () => {
    localStorage.removeItem("username");
    setUsername(null);
      navigate("/login", { replace: true });

  }

  return (
    <>
      <header className="header flex justify-between gap-x-5 flex-nowrap text-white py-10 mb-5 ">
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
            to="/product"
            className={({ isActive }) => (isActive ? "text-primary" : "")}
          >
            Product
          </NavLink>
        </div>

        {username ? (
          <>
            <div className="flex items-center justify-center gap-5">
              <div className="flex items-center justify-center border border-primary px-4 py-2 rounded-full">
                {username}
              </div>

              <NavLink
                to="/cart"
                className={({ isActive }) => (isActive ? "text-primary" : "")}
              >
                <img
                  src={process.env.PUBLIC_URL + "/assets/cart.png"}
                  alt="logo"
                  className="w-10"
                />
              </NavLink>

              <img
                src={process.env.PUBLIC_URL + "/assets/logout.png"}
                alt="logo"
                className="w-8 cursor-pointer"
                onClick={handleLogout}
              />
            </div>
          </>
        ) : (
          <>
            <div className="flex items-center justify-center gap-x-2 border border-primary px-5 rounded-full">
              <NavLink
                to="/login"
                className={({ isActive }) => (isActive ? "text-primary" : "")}
              >
                Log In
              </NavLink>
              /
              <NavLink
                to="/signup"
                className={({ isActive }) => (isActive ? "text-primary" : "")}
              >
                Sign Up
              </NavLink>
            </div>
          </>
        )}
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
