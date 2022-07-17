import Sidebar from "components/layout/admin/Sidebar";
import React from "react";
import { Outlet } from "react-router-dom";
import Header from "./Header";

const Dashboard = () => {
  return (
    <>
      <Header></Header>
      <div className="flex bg-gray-900">
        {/* <!-- container --> */}
        
        <Sidebar></Sidebar>
        <div className="flex-1 bg-gray-400 p-6 flex justify-center">
          <Outlet></Outlet>
        </div>
      </div>
    </>
  );
};

export default Dashboard;
