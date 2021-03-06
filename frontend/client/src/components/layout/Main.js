import React from 'react';
import { Outlet } from 'react-router-dom';
import Header from './Header';
import Footer from './Footer';

//Page dùng chung cho các Route
const Main = () => {
  return (
    <>
      <Header></Header>

      {/* Outlet dùng để nested những cái nằm trong Main (để muốn Route nào cũng có Header nên phải dùng Outlet như này) */}
      <Outlet></Outlet>
      <Footer></Footer>
    </>
  );
};

export default Main;