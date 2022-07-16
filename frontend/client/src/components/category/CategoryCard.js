import React, { useEffect, useState } from "react";
import { Navigate, useParams } from "react-router-dom";
import CategoryService from "services/CategoryService";
import ProductService from "services/ProductService";
import Button from "./../button/Button";

const CategoryCard = () => {
  const [cate, setCate] = useState([]);
  const [selected, setSelected] = useState(0);
  const [product, setProduct] = useState([]);
  const [proId, setProId] = useState();
  const [sortBy, setSortBy] = useState(0);
  const [activePage, setActivePage] = useState(1);

  let { type } = useParams();
  if (!type) {
    type = "None";
  }

  const getData = async () => {
    CategoryService.getAllCategories().then((res) => {
      setCate(res.data);
    });

    const id = selected === 0 ? "all" : selected;
    ProductService.getAllProductTradingByCateId(id).then((res) => {
      setProduct(res.data);
      // console.log(res.data);
    });
  };

  useEffect(() => {
    getData();
  }, [selected]);

  const sort = (e) => {
    let value = e.target.value;
    if (value === 1) {
      product.sort((a, b) => {
        return a.price - b.price;
      });
    } else if (value === 2) {
      product.sort((a, b) => {
        return b.price - a.price;
      });
    } else if (value === 3) {
      product.sort((a, b) => {
        return a.rate - b.rate;
      });
    } else if (value === 4) {
      product.sort((a, b) => {
        return b.rate - a.rate;
      });
    }
    setSortBy(value);
  };

  return (
    <>
      {proId && <Navigate to={`/home/view/${proId}`} />}

      <div className="float-left text-black">
        {/* category */}
        {cate.map((item, index) => {
          return (
            <div
              key={index}
              className={`${
                selected === item.id ? "bg-secondary text-white " : "bg-white"
              } p-2 m-2 rounded-lg text-center cursor-pointer`}
              onClick={() => {
                setSelected(item.id);
                setActivePage(1);
              }}
            >
              {item.name}
            </div>
          );
        })}
        {/* end category */}
        {/* sort */}
        <label
          htmlFor="countries"
          className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-400"
        >
          Select an option
        </label>
        <select
          id="countries"
          className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
        >
          <option defaultValue={0}>
            All
          </option>
          <option value={1}>Prices Increase</option>
          <option value={2}>Prices Decrease</option>
          <option value={3}>Stars Increase</option>
          <option value={4}>Stars Decrease</option>
        </select>
        {/* end sort */}
      </div>
    </>
  );
};

export default CategoryCard;
