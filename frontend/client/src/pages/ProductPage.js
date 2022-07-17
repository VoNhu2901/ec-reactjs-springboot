import React, { useEffect, useState } from "react";
import useSWR from "swr";
import { apiKey, fetcher, tmdbAPI } from "../components/apiConfig/config";
import ProductCard, {
  ProductCardSkeleton,
} from "../components/movie/ProductCard";
import useDebounce from "../hooks/useDebounce";
import ReactPaginate from "react-paginate";
import { Navigate, useParams } from "react-router-dom";
import CategoryService from "services/CategoryService";
import ProductService from "services/ProductService";

const itemsPerPage = 10;

const ProductPage = () => {
  const [cate, setCate] = useState([]);
  const [selected, setSelected] = useState(0);
  const [product, setProduct] = useState([]);
  const [proId, setProId] = useState();
  const [sortBy, setSortBy] = useState(0);
  const [activePage, setActivePage] = useState(1);
  
  // ===============pagination=====================
  const [pageCount, setPageCount] = useState(0);
  const [itemOffset, setItemOffset] = useState(0);

  const [nextPage, setNextPage] = useState(1);
  const [filter, setFilter] = useState("");
  const handleFilterChange = (e) => {
    setFilter(e.target.value);
  };

  //  let { type } = useParams();
  //  if (!type) {
  //    type = "None";
  //  }

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

  const loading = !product; //false khi co data
  useEffect(() => {
    if (!product || !product.length) return;
    // Fetch items from another resources.
    setPageCount(Math.ceil(product.length / itemsPerPage)); // so trang =7
  }, [product, itemOffset]);

  // Invoke when user click to request another page.
  const handlePageClick = (event) => {
    const newOffset = (event.selected * itemsPerPage) % product.total_pages;
    setItemOffset(newOffset);
    setNextPage(event.selected + 1);
  };

  return (
    <>
      {/* filter */}
      <div className="">
        {proId && <Navigate to={`/product/${proId}`} />}

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
            htmlFor="sorting"
            className="block mb-2 text-sm font-medium text-gray-400 dark:text-gray-400"
          >
            Select an option
          </label>
          <select
            id="sorting"
            className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            value={sortBy}
            onChange={sort}
          >
            <option defaultValue={0}>All</option>
            <option value={1}>Prices Increase</option>
            <option value={2}>Prices Decrease</option>
            <option value={3}>Stars Increase</option>
            <option value={4}>Stars Decrease</option>
          </select>
          {/* end sort */}
        </div>
      </div>
      {/* end filter */}

      <div className="py-10 page-container">
        {/* Thanh search */}
        <div className="flex mb-10">
          <div className="flex-1 ">
            <input
              type="text"
              className="w-full p-4 bg-transparent bg-slate-700 outline-none rounded-l-lg"
              placeholder="Type here to search..."
              onChange={handleFilterChange}
            />
          </div>
          <button className="bg-primary p-4 rounded-r-lg">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              className="h-6 w-6"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
              strokeWidth="2"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
              />
            </svg>
          </button>
        </div>
        {/* Loading */}
        {loading && (
          <>
            <div className="w-10 h-10 rounded-full border-4 border-primary border-t-transparent border-t-4 mx-auto animate-spin"></div>
            <div className="grid grid-cols-4 gap-10 page-container">
              {new Array(itemsPerPage).fill(0).map((_, index) => (
                <ProductCardSkeleton key={index} />
              ))}
            </div>
          </>
        )}

        {/* Content */}
        <div className="grid grid-cols-4 gap-10 page-container">
          {!loading &&
            product.length > 0 &&
            product.map((item, index) => (
              <ProductCard key={index} item={item}></ProductCard>
            ))}
        </div>

        {/* Pagination */}
        <div className="mt-10">
          <ReactPaginate
            breakLabel="..."
            nextLabel="next >"
            onPageChange={handlePageClick}
            pageRangeDisplayed={5}
            pageCount={pageCount}
            previousLabel="< previous"
            renderOnZeroPageCount={null}
            className="pagination"
          />
        </div>
      </div>
    </>
  );
};

export default ProductPage;
