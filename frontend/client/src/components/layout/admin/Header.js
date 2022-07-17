import React, { useState } from "react";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const Header = () => {
  const [username, setUsername] = useState();
  const navigate = useNavigate();
  
  useEffect(() => {
    const isExistUsername = localStorage.getItem("username");
    if (isExistUsername) {
      setUsername(isExistUsername);
    }
  }, []);
  const handleLogout = () => {
    
    localStorage.removeItem("username");
    setUsername(null);
    navigate("/login", { replace: true });
  };

  return (
    <>
      <section
        className="flex bg-gray-900 text-gray-100 p-4 flex-shrink-0 w-full"
        id="left-side-panel"
      >
        <p>Hello, Wellcome back to admin page</p>

        <div className="flex ml-auto gap-x-4">
          <div className="border border-primary rounded-full px-3 py-1">
            {username}
            </div>
          <img
            src={process.env.PUBLIC_URL + "/assets/logout.png"}
            alt="logo"
            className="w-8 cursor-pointer"
            onClick={handleLogout}
          />
        </div>
      </section>
    </>
  );
};

export default Header;
