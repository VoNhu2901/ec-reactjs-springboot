import CartItem from "components/cart/CartItem";
import React, { useState } from "react";
import { useEffect } from "react";
import { Navigate, NavLink } from "react-router-dom";
import CartService from "services/CartService";
import ProductService from "./../services/ProductService";

const CartPage = () => {
  const [cartItems, setCartItems] = useState([]);
  const [isLogOut, setIsLogOut] = useState(false);
  const [totalPrice, setTotalPrice] = useState(0);

  useEffect(() => {
    let accId = localStorage.getItem("accId");
    CartService.getCartByAccId(accId)
      .then((res) => {
        setCartItems(res.data.cartItems);
      })
      .catch((err) => {
        console.log(err);
        setIsLogOut(true);
      });
  }, []);

  const checkOut = () => {
    alert(
      "Chức năng đang phát triển, tạm tính " + cartItems.length + " sản phẩm"
    );
  };

  if (!cartItems) {
    return (
      <div>
        <img
          src={process.env.PUBLIC_URL + "/assets/empty_cart.png"}
          alt="empty_cart"
        />
      </div>
    );
  }

  return (
    <>
      {isLogOut && <Navigate to={"/login"}></Navigate>}

      {/* isLogOut=false: đã đăng nhập */}
      <div className="container mx-auto mt-10 ">
        <div className="flex shadow-md my-10 text-black ">
          <div className="w-3/4 bg-white px-10 py-10 border rounded-l-2xl">
            {/* title */}
            <div className="flex justify-between border-b pb-8">
              <h1 className="font-semibold text-2xl">Shopping Cart</h1>
              <h2 className="font-semibold text-2xl">
                {cartItems.length} Items
              </h2>
            </div>

            {/* product list */}
            {/* title list */}
            <div className="flex mt-10 mb-5">
              <h3 className="font-semibold text-gray-600 text-xs uppercase w-2/5">
                Product Details
              </h3>
              <h3 className="font-semibold text-center text-gray-600 text-xs uppercase w-1/5 text-center">
                Quantity
              </h3>
              <h3 className="font-semibold text-center text-gray-600 text-xs uppercase w-1/5 text-center">
                Price
              </h3>
              <h3 className="font-semibold text-center text-gray-600 text-xs uppercase w-1/5 text-center">
                Total
              </h3>
            </div>

            {/* product item */}
            {cartItems?.map((item, index) => {
              return <CartItem key={index} item={item} />;
            })}

            {/* end product item */}

            {/* back to homepage */}
            <NavLink
              to="/product"
              className="flex font-semibold text-indigo-600 text-sm mt-10"
            >
              <svg
                className="fill-current mr-2 text-indigo-600 w-4"
                viewBox="0 0 448 512"
              >
                <path d="M134.059 296H436c6.627 0 12-5.373 12-12v-56c0-6.627-5.373-12-12-12H134.059v-46.059c0-21.382-25.851-32.09-40.971-16.971L7.029 239.029c-9.373 9.373-9.373 24.569 0 33.941l86.059 86.059c15.119 15.119 40.971 4.411 40.971-16.971V296z" />
              </svg>
              Continue Shopping
            </NavLink>
          </div>

          {/* Order */}
          <div
            id="summary"
            className="w-1/4 px-8 py-10 bg-gray-200 border rounded-r-2xl"
          >
            <h1 className="font-semibold text-2xl border-b pb-8">
              Order Summary
            </h1>
            <div className="flex justify-between mt-10 mb-5">
              <span className="font-semibold text-sm uppercase">
                Items {cartItems.length}
              </span>
            </div>

            <div className="border-t mt-8">
              <div className="flex font-semibold justify-between py-6 text-sm uppercase">
                <span>Total cost</span>
                <span>$600</span>
              </div>
              <button
                className="bg-indigo-500 font-semibold hover:bg-indigo-600 py-3 text-sm text-white uppercase w-full"
                onClick={checkOut}
              >
                Checkout
              </button>
            </div>
          </div>
          {/* End order */}
        </div>
      </div>
    </>
  );
};

export default CartPage;
