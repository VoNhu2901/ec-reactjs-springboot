import React, { useEffect, useState } from "react";
import ProductService from "services/ProductService";
import ProductCard from "./components/ProductCard";

const ProductManagementPage = () => {
  const [data, setData] = useState([]);

  const getData = async () => {
    ProductService.getAllProducts()
      .then((res) => {
        setData(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  useEffect(() => {
    getData();
  }, []);
  return (
    <div className="flex flex-col items-center gap-y-5 overflow-x-auto relative">
      <header className="flex gap-10 uppercase text-black ">
        <h1 className="text-2xl">Product Management</h1>
        <button className="bg-secondary p-2 rounded-lg">
          Add a new product
        </button>
      </header>

      {data.map((item) => (
        <ProductCard key={item.proId} item={item} />
      ))}
    </div>
  );
};

export default ProductManagementPage;
