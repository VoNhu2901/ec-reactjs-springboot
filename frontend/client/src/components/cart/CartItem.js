import React, { useEffect, useState } from "react";
import ProductService from "services/ProductService";

const CartItem = ({ item }, props) => {
  const { proId, name, price, quantity } = item;
  const priceFormat = price
    .toString()
    .replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
  const [newQuantity, setNewQuantity] = useState(quantity);
  const [productImages, setProductImages] = useState([]);

  const getTotalPrice = () => {
    let totalPrice = 0;
    totalPrice += price * quantity;
    return totalPrice;
  };

  const totalPriceFormat = getTotalPrice()
    .toString()
    .replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");

  useEffect(() => {
    ProductService.getProductById(proId).then((res) => {
      setProductImages(res.data.productImages);
    });
  }, [proId]);

  return (
    <>
      <div className="flex items-center hover:bg-gray-100 -mx-8 px-6 py-5">
        {/* product */}
        <div className="flex w-2/5">
          {/* image */}
          <div className="w-20">
            {productImages.length > 0 ? (
              <img
                src={productImages[0].imgUrl}
                alt={name}
                className="w-full h-full object-cover"
              />
            ) : (
              <img
                src="https://via.placeholder.com/150"
                alt={name}
                className="w-full h-full object-cover"
              />
            )}
            <img className="h-24" src={productImages.imgUrl} alt="" />
          </div>
          {/* title */}
          <div className="flex flex-col justify-between ml-4 flex-grow">
            <span className="font-bold text-sm">{name}</span>
            <span className="text-red-500 text-xs">Apple</span>
            <a
              href="null"
              className="font-semibold hover:text-red-500 text-gray-500 text-xs"
            >
              Remove
            </a>
          </div>
        </div>

        {/* Quantity */}
        <div className="flex justify-center w-1/5">
          <svg className="fill-current text-gray-600 w-3" viewBox="0 0 448 512">
            <path d="M416 208H32c-17.67 0-32 14.33-32 32v32c0 17.67 14.33 32 32 32h384c17.67 0 32-14.33 32-32v-32c0-17.67-14.33-32-32-32z" />
          </svg>

          <input
            className="mx-2 border text-center w-8"
            type="text"
            value={newQuantity}
            onChange={(e) => setNewQuantity(e.target.value)}
          />

          <svg className="fill-current text-gray-600 w-3" viewBox="0 0 448 512">
            <path d="M416 208H272V64c0-17.67-14.33-32-32-32h-32c-17.67 0-32 14.33-32 32v144H32c-17.67 0-32 14.33-32 32v32c0 17.67 14.33 32 32 32h144v144c0 17.67 14.33 32 32 32h32c17.67 0 32-14.33 32-32V304h144c17.67 0 32-14.33 32-32v-32c0-17.67-14.33-32-32-32z" />
          </svg>
        </div>

        {/* price */}
        <span className="text-center w-1/5 font-semibold text-sm">
          {priceFormat} VND
        </span>

        {/* total */}
        <span className="text-center w-1/5 font-semibold text-sm">
          {totalPriceFormat} VND
        </span>
      </div>
    </>
  );
};

export default CartItem;
