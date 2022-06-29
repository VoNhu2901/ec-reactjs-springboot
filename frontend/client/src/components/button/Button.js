import React from "react";

const Button = ({
  onClick,
  className,
  full = false,
  type = "button",
  bgColor = "bg-primary",
  children,
}) => {
  let bgClassName = "bg-primary";
  switch (bgColor) {
    case "primary":
      bgClassName = "bg-primary";
      break;
    case "secondary":
      bgClassName = "bg-secondary";
      break;
    default:
      break;
  }
  return (
    <>
      <button
        type={type}
        className={`bg-primary px-6 py-3 rounded-md ${
          full ? "w-full" : ""
        } mt-auto capitalize ${bgClassName} ${className}`}
        onClick={onClick}
      >
        {children}
      </button>
    </>
  );
};

export default Button;
