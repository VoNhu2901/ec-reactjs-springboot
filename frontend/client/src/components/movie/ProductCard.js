import React from "react";
import { useNavigate } from "react-router-dom";
import Button from "../button/Button";
import { tmdbAPI } from '../apiConfig/config';
import PropTypes from "prop-types";
import { withErrorBoundary } from "react-error-boundary";
import LoadingSkeleton from '../../loading/LoadingSkeleton';

const ProductCard = ({ item }) => {
  // const { id, title, release_date, poster_path, vote_average } = item;
  const { proId, name, price, thumbnail, rate } = item; 
  // Format VND JavaScript
  const priceFormat = price.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
  const rateFormat = Math.floor(rate * 10) / 10;
  // end format
  const navigate = useNavigate();
  return (
    <>
      <div
        className="movie-card flex flex-col rounded-lg p-3 bg-slate-800 h-full select-none"
        key={proId}
      >
        <img
          src={thumbnail}
          alt="img"
          className="w-full h-[250px] object-cover rounded-lg mb-5"
        />
        <div className="flex flex-col flex-1">
          <h3 className="font-bold text-xl mb-3">{name}</h3>
          <div className="flex items-center justify-between opacity-50 mb-10 ">
            <span>{priceFormat} VND</span>
            <span>{rateFormat}</span>
          </div>

          <Button
            onClick={() => {
              navigate(`/product/${proId}`);
            }}
          >
            But Now
          </Button>
        </div>
      </div>
    </>
  );
};


// Bổ sung thêm cho biết 
ProductCard.propTypes = {
  item: PropTypes.shape({
    id: PropTypes.number,
    title: PropTypes.string,
    release_date: PropTypes.string,
    poster_path: PropTypes.string,
    vote_average: PropTypes.number,
  }),
};

// Để báo lỗi component nếu xảy ra lỗi thì sẽ chạy FallbackComponent()
function FallbackComponent() {
  return <p className="bg-red-50 text-red-50">Something went wrong with this components</p>
}

export default withErrorBoundary(ProductCard, FallbackComponent);

export const ProductCardSkeleton = () => {
return (
  <>
    <div className="movie-card flex flex-col rounded-lg p-3 bg-slate-800 h-full select-none">
      <LoadingSkeleton
        width="100%"
        height="250px"
        radius="8px"
        className="mb-5"
      ></LoadingSkeleton>
      <div className="flex flex-col flex-1">
        <h3 className="font-bold text-xl mb-3">
          <LoadingSkeleton width="100%" height="20px"></LoadingSkeleton>
        </h3>
        <div className="flex items-center justify-between opacity-50 mb-10 ">
          <span>
            <LoadingSkeleton width="50px" height="10px"></LoadingSkeleton>
          </span>
          <span>
            <LoadingSkeleton width="30px" height="10px"></LoadingSkeleton>
          </span>
        </div>
        <LoadingSkeleton width="100%" height="40px"></LoadingSkeleton>
      </div>
    </div>
  </>
);

}