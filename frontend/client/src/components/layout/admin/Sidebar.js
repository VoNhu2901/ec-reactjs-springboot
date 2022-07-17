import React from "react";
import { NavLink } from 'react-router-dom';

const Sidebar = () => {
  return (
    <>
      

        <aside className="flex flex-col items-center  px-0 sm:px-3 bg-sidebar shadow sm:w-sidebar w-small_sidebar h-[850px] transition-all">
          {/* <!-- Side Nav Bar--> */}

          <div className="py-9 justify-center flex items-center w-full text-3xl border border-secondary rounded-2xl m-5">
            Admin
          </div>

          <div className="flex items-center justify-center flex-col gap-y-5 h-full">
            <NavLink
              to="/admin"
              className={({ isActive }) => (isActive ? "text-primary" : "")}
            >
              Product
            </NavLink>
            <NavLink
              to="/admin/category"
              className={({ isActive }) => (isActive ? "text-primary" : "")}
            >
              Category
            </NavLink>
            <NavLink
              to="/admin/order"
              className={({ isActive }) => (isActive ? "text-primary" : "")}
            >
              Order
            </NavLink>
            <NavLink
              to="/admin/account"
              className={({ isActive }) => (isActive ? "text-primary" : "")}
            >
              Account
            </NavLink>
          </div>
        </aside>
        {/* <div className="app flex-1 bg-gray-400 p-6">haha</div> */}
    </>
  );
};

export default Sidebar;
