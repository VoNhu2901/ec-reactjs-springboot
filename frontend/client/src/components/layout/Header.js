import React from 'react';
import { NavLink } from 'react-router-dom';
import CategoryService from './../../services/CategoryService';

const Header = () => {
  return (
    <>
      <header className="header flex items-center justify-center gap-x-5 text-white py-10 mb-5">
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
          to="/category"
          className={({ isActive }) => (isActive ? "text-primary" : "")}
        >
          CategoryService
        </NavLink>
      </header>
    </>
  );
};

export default Header;