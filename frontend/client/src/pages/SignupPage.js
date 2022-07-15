import SignUp from 'components/form/Signup';
import { FormLoginSignup } from 'components/layout/Header';
import React from 'react';

const SignUpPage = () => {
  return (
    <>
      <FormLoginSignup
        heading="Signup to create an account"
        paragraph="Already have an account? "
        linkName="Login"
        linkUrl="/login"
      ></FormLoginSignup>
      <SignUp></SignUp>
    </>
  );
};

export default SignUpPage;