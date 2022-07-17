import moment from "moment";
import React from "react";

const ProductCard = ({ item }) => {
  const {
    proId,
    name,
    price,
    amount,
    description,
    rate,
    productImages,
    category,
    updateDate,
    createDate,
  } = item;
  const priceFormat = price.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
  
function toggleModal() {
  document.getElementById("modal").classList.toggle("hidden");
}

  return (
    <>
      <div className="flex items-center bg-white rounded-lg border shadow-md flex-row hover:bg-gray-200 text-black w-[900px]">
        <img
          className="object-cover w-52 "
          src={productImages[0].imgUrl}
          alt=""
        />
        <div className="flex flex-col justify-between p-4 leading-normal">
          <h2 className="text-gray-500 uppercase">{category.name}</h2>
          <h5 className="mb-2 text-2xl font-bold tracking-tight text-gray-900">
            {name} - {rate} Star
          </h5>

          <p className="mb-3 font-normal text-gray-500">{description}</p>
          <div className="flex flex-row text-lg font-medium">
            <p>{priceFormat} VDN</p>
            <p className="ml-auto">{amount} pieces</p>
          </div>
          <div className="flex-row text-sm opacity-50">
            <p>Create date {moment(createDate).format("LLL")}</p>
            <p className="ml-auto">
              Last update {moment(updateDate).format("LLL")}
            </p>
          </div>

          <button className="ml-auto bg-blue-600 p-3 rounded-lg mt-4">
            Read more
          </button>

          {/* modal */}
          <div class="flex items-center justify-center h-full">
            <button
              class="py-2 px-4 bg-blue-500 text-white rounded hover:bg-blue-700"
              onclick="toggleModal()"
            >
              Show Modal
            </button>
          </div>
          <div
            class="fixed z-10 overflow-y-auto top-0 w-full left-0 hidden"
            id="modal"
          >
            <div class="flex items-center justify-center min-height-100vh pt-4 px-4 pb-20 text-center sm:block sm:p-0">
              <div class="fixed inset-0 transition-opacity">
                <div class="absolute inset-0 bg-gray-900 opacity-75" />
              </div>
              <span class="hidden sm:inline-block sm:align-middle sm:h-screen">
                &#8203;
              </span>
              <div
                class="inline-block align-center bg-white rounded-lg text-left overflow-hidden shadow-xl transform transition-all sm:my-8 sm:align-middle sm:max-w-lg sm:w-full"
                role="dialog"
                aria-modal="true"
                aria-labelledby="modal-headline"
              >
                <div class="bg-white px-4 pt-5 pb-4 sm:p-6 sm:pb-4">
                  <label>Name</label>
                  <input type="text" class="w-full bg-gray-100 p-2 mt-2 mb-3" />
                  <label>Url</label>
                  <input type="text" class="w-full bg-gray-100 p-2 mt-2 mb-3" />
                </div>
                <div class="bg-gray-200 px-4 py-3 text-right">
                  <button
                    type="button"
                    class="py-2 px-4 bg-gray-500 text-white rounded hover:bg-gray-700 mr-2"
                    onclick="toggleModal()"
                  >
                    <i class="fas fa-times"></i> Cancel
                  </button>
                  <button
                    type="button"
                    class="py-2 px-4 bg-blue-500 text-white rounded hover:bg-blue-700 mr-2"
                  >
                    <i class="fas fa-plus"></i> Create
                  </button>
                </div>
              </div>
            </div>
          </div>

          {/* end modal */}
        </div>
      </div>
    </>
  );
};

export default ProductCard;
