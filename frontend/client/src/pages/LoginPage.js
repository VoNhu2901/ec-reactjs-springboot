import Login from 'components/form/Login';
import { FormLoginSignup } from 'components/layout/Header';
import React from 'react';
import { NavLink } from 'react-router-dom';

const LoginPage = () => {
  return (
    <>
      <FormLoginSignup
        heading="Login to your account"
        paragraph="Don't have an account yet? "
        linkName="Signup"
        linkUrl="/signup"
      ></FormLoginSignup>
      <Login></Login>
    </>
  );
};

export default LoginPage;