import React, { useEffect, useState } from "react";
import OrderService from "services/OrderService";
import moment from "moment";
import AccountService from "services/AccountService";

const OrderManagementPage = () => {
  const [data, setData] = useState([]);
  const [account, setAccount] = useState(2);

  const getData = async () => {
    OrderService.getAllOrders()
      .then((res) => {
        setData(res.data);
        // setAccount(res.data.accId);
      })
      .catch((err) => {
        console.log(err);
      });

    // AccountService.getUserById(account)
    //   .then((res) => {
    //     setAccount(res.data);
    //     console.log(res.data);
    //   })
    //   .catch((err) => {
    //     console.log(err);
    //   });
  };

  useEffect(() => {
    getData();
  }, []);

  return (
    <>
      <div className="overflow-x-auto relative shadow-md rounded-lg">
        <table className="w-full text-lg text-left text-gray-400">
          <thead className="uppercase bg-gray-700 text-gray-400">
            <tr>
              <th scope="col" className="py-3 px-6">
                OrderId
              </th>
              <th scope="col" className="py-3 px-6">
                Status
              </th>
              <th scope="col" className="py-3 px-6">
                Create Date
              </th>
              <th scope="col" className="py-3 px-6">
                Action
              </th>
            </tr>
          </thead>

          <tbody>
            {data.map((item) => (
              <tr
                key={item.orderId}
                className="border-b bg-gray-800 border-gray-700 hover:bg-gray-600"
              >
                <th
                  scope="row"
                  className="py-4 px-6 font-medium whitespace-nowrap text-white"
                >
                  {item.orderId}
                </th>
                <td className="py-4 px-6">{item.status}</td>
                <td className="py-4 px-6">
                  {moment(item.createDate).format("LLL")}
                </td>
                <td className="py-4 px-6 text-right">
                  <a
                    href="null"
                    className="font-medium text-blue-500 hover:underline"
                  >
                    Confirm
                  </a>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default OrderManagementPage;
