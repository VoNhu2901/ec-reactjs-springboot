import Button from "components/button/Button";
import React, { useEffect, useState } from "react";
import { NavLink, useParams } from "react-router-dom";
import ProductService from "services/ProductService";
import RateService from "services/RateService";
import CartService from "./../services/CartService";

const ProductDetailPage = () => {
  let { id } = useParams();
  const [product, setProduct] = useState();
  const [newRate, setNewRate] = useState(10);
  const [newComment, setNewComment] = useState("");
  const [isLogin, setIsLogin] = useState(false);
  const [quantity, setQuantity] = useState(1);
  const [success, setSuccess] = useState();

  useEffect(() => {
    if (id) {
      ProductService.getProductById(id).then((res) => {
        setProduct(res.data);
        // console.log(res.data);
      });
    }

    if (localStorage.getItem("accId") !== null) {
      setIsLogin(true);
    }
  }, []);

  const postComment = () => {
    const data = {
      accId: localStorage.getItem("accId"),
      proId: id,
      rate: newRate,
      comment: newComment,
    };

    RateService.addNewRate(data)
      .then((res) => {
        setSuccess(res.data.message);
        console.log(res.data);
      })
      .catch((error) => {
        setSuccess("You have reviewed this book before");
        console.log(error);
      });
  };

  const addToCart = (e, id) => {
    e.preventDefault();
    let cartId = localStorage.getItem("cartId");
    let accId = localStorage.getItem("accId");
    if (!accId) {
      alert("Please login to add to cart");
    }

    if (!cartId) {
      CartService.getCartByAccId(accId)
        .then((res) => {
          localStorage.setItem("cartId", res.data.id);
        })
        .catch((error) => {
          console.log(error);
        });
    }

    if (quantity === 0) {
      alert("Quantity must not be 0");
    }

    const data = {
      proId: id,
      cartId: localStorage.getItem("cartId"),
      quantity: quantity,
    };

    CartService.addProductToCart(data)
      .then((res) => {
        alert(res.data.message);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  if (!product) {
    return (
      <div>
        <img
          src={process.env.PUBLIC_URL + "/assets/empty_cart.png"}
          alt="empty_cart"
        />
      </div>
    );
  }

  const {
    productImages,
    price,
    category,
    name,
    rate,
    productRates,
    description,
    proId,
  } = product;
  const priceFormat = price
    .toString()
    .replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");

  //display rate
  const totalStar = [];
  for (let i = 1; i <= rate; i++) {
    totalStar.push(
      <svg
        key={i}
        fill="currentColor"
        stroke="currentColor"
        strokeLinecap="round"
        strokeLinejoin="round"
        strokeWidth="2"
        className="w-4 h-4 text-red-500"
        viewBox="0 0 24 24"
      >
        <path d="M12 2l3.09 6.26L22 9.27l-5 4.87 1.18 6.88L12 17.77l-6.18 3.25L7 14.14 2 9.27l6.91-1.01L12 2z"></path>
      </svg>
    );
  }
  // end display rate

  return (
    <>
      {/* <!-- detail --> */}
      <section className=" body-font overflow-hidden text-white">
        <div className="container px-5 py-24 mx-auto">
          <div className="lg:w-4/5 mx-auto flex flex-wrap">
            {(productImages || []).map((image, index) => {
              return (
                <img
                  key={index}
                  alt="ecommerce"
                  className="lg:w-1/2 w-full object-cover object-center rounded border border-gray-200"
                  src={image.imgUrl}
                />
              );
            })}

            <div className="lg:w-1/2 w-full lg:pl-10 lg:py-6 mt-6 lg:mt-0">
              <h2 className="text-sm title-font text-secondary tracking-widest uppercase">
                {category.name}
              </h2>
              <h1 className="text-3xl title-font font-medium mb-1">{name}</h1>
              <div className="flex mb-4">
                <span className="flex items-center">
                  {totalStar}
                  <span className="text-gray-600 ml-3">
                    {productRates.length} Reviews
                  </span>
                </span>
              </div>
              <p className="leading-relaxed">{description}</p>

              <div className="flex">
                <span className="title-font font-medium text-2xl text-primary inline-block mt-5">
                  {priceFormat} VND
                </span>
                {/* quantity */}
                <div className="ml-auto">
                  <label
                    for="quantity"
                    class="form-label inline-block mb-2 text-gray-400"
                  >
                    Quantity
                  </label>
                  <input
                    type="number"
                    min="1"
                    className="form-control block px-3 py-1.5 text-base font-normal text-gray-700 border border-solid border-gray-300 rounded selection:focus:border-blue-600 focus:outline-none"
                    id="quantity"
                    placeholder="Number input"
                    value={quantity}
                    onChange={(e) => setQuantity(e.target.value)}
                  />
                </div>
              </div>

              <div className="flex mt-20">
                <button
                  className="flex ml-auto text-white h-10 bg-red-500 border-0 py-2 px-6 focus:outline-none hover:bg-red-600 rounded"
                  onClick={(e) => {
                    addToCart(e, proId);
                  }}
                >
                  Add to cart
                </button>
                <button className="rounded-full w-10 h-10 bg-gray-200 p-0 border-0 inline-flex items-center justify-center text-gray-500 ml-4">
                  <svg
                    fill="currentColor"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth="2"
                    className="w-5 h-5"
                    viewBox="0 0 24 24"
                  >
                    <path d="M20.84 4.61a5.5 5.5 0 00-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 00-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 000-7.78z"></path>
                  </svg>
                </button>
              </div>
            </div>
          </div>
        </div>
      </section>
      {/* end detail */}

      {/* comment */}
      <section className="flex items-center justify-center">
        <div className="container mx-auto px-5 rounded-lg shadow-md shadow-blue-600/100 mb-10 pt-5 text-black">
          {/* display comment */}
          {(productRates || []).map((item, index) => {
            return (
              <>
                <span className="flex items-center gap-3">
                  <span className="text-gray-400 ml-auto">{item.rate}</span>
                  <svg
                    key={index}
                    fill="currentColor"
                    stroke="currentColor"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth="2"
                    className="w-4 h-4 text-red-500 mr-3"
                    viewBox="0 0 24 24"
                  >
                    <path d="M12 2l3.09 6.26L22 9.27l-5 4.87 1.18 6.88L12 17.77l-6.18 3.25L7 14.14 2 9.27l6.91-1.01L12 2z"></path>
                  </svg>
                </span>
                <div className="bg-blue-200 p-2 m-4 rounded-md ">
                  {item.comment}
                </div>
              </>
            );
          })}

          {/* form comment */}
          {isLogin ? (
            <>
              <form action="" className="w-full p-4 ">
                <div className="mb-2 ">
                  {/* Comment */}
                  <label htmlFor="comment" className="text-lg text-white">
                    Add a comment
                  </label>
                  <textarea
                    className="w-full h-20 p-2 border rounded focus:outline-none focus:ring-gray-300 focus:ring-1 "
                    name="comment"
                    placeholder="Good product..."
                    value={newComment}
                    onChange={(e) => setNewComment(e.target.value)}
                  ></textarea>
                  {/* Vote */}
                  <div className="ml-auto">
                    <label
                      for="quantity"
                      class="form-label inline-block mb-2 text-gray-400"
                    >
                      Star (between 1 and 10)
                    </label>
                    <input
                      type="number"
                      min="1"
                      max="10"
                      className="form-control block px-3 py-1.5 text-base font-normal text-gray-700 border border-solid border-gray-300 rounded selection:focus:border-blue-600 focus:outline-none"
                      id="quantity"
                      placeholder="Number input"
                      value={newRate}
                      onChange={(e) => setNewRate(e.target.value)}
                    />
                  </div>

                  <p className="text-red-600 text-sm mt-5">
                    Announce: {success ? success : "You have not commented yet"}
                  </p>
                </div>
                <div>
                  <button
                    className="px-3 py-2 text-sm text-blue-100 bg-blue-600 rounded"
                    onClick={postComment}
                  >
                    Comment
                  </button>
                  <button className="px-3 py-2 text-sm text-blue-600 border border-blue-500 rounded float-right">
                    Cancel
                  </button>
                </div>
              </form>
            </>
          ) : (
            <div className="flex items-center justify-center">
              <p className="text-center text-secondary">
                You need to login to comment
              </p>
              <div className="p-2 m-4">
                <NavLink to="/login">
                  <Button className="text-white">Login now</Button>
                </NavLink>
              </div>
            </div>
          )}
        </div>
      </section>
      {/* end comment */}
    </>
  );
};

export default ProductDetailPage;
