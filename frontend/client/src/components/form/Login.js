import React from "react";
import { loginFields } from "utils/formFields";
import { useState } from "react";
import Input from "components/input/Input";
import FormExtra from './FormExtra';
import FormAction from "./FormAction";

const fields = loginFields;
let fieldsState = {};
fields.forEach((field) => (fieldsState[field.id] = ""));

const Login = () => {
  const [loginState, setLoginState] = useState(fieldsState);

  const handleChange = (e) => {
    setLoginState({ ...loginState, [e.target.id]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    authenticateUser();
  };

  //Handle Login API Integration here
  const authenticateUser = () => { };
  
  return (
    <div className="h-80 flex justify-center">
      <form className="mt-2 space-y-6 w-[500px]">
        <div className="-space-y-px ">
          {fields.map((field) => (
            <Input
              key={field.id}
              handleChange={handleChange}
              value={loginState[field.id]}
              labelText={field.labelText}
              labelFor={field.labelFor}
              id={field.id}
              name={field.name}
              type={field.type}
              isRequired={field.isRequired}
              placeholder={field.placeholder}
            />
          ))}
        </div>
        <FormExtra />
        <FormAction handleSubmit={handleSubmit} text="Login" />
      </form>
    </div>
  );
};

export default Login;
