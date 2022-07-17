import React, { useEffect, useState } from "react";
import AccountService from "services/AccountService";
import moment from "moment";

const AccountManagementPage = () => {
  const [data, setData] = useState([]);

  const getData = async () => {
    AccountService.getAllUsers()
      .then((res) => {
        setData(res.data);
        console.log(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  useEffect(() => {
    getData();
  }, []);

  return (
    <div>
      <div className="overflow-x-auto relative shadow-md rounded-lg">
        <table className="w-full text-lg text-left text-gray-400">
          <thead className="uppercase bg-gray-700 text-gray-400">
            <tr>
              <th scope="col" className="py-3 px-6">
                Username
              </th>
              <th scope="col" className="py-3 px-6">
                role
              </th>
              <th scope="col" className="py-3 px-6">
                email
              </th>
              <th scope="col" className="py-3 px-6">
                phone
              </th>
              <th scope="col" className="py-3 px-6">
                address
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
                key={item.accId}
                className="border-b bg-gray-800 border-gray-700 hover:bg-gray-600"
              >
                <th
                  scope="row"
                  className="py-4 px-6 font-medium whitespace-nowrap text-white"
                >
                  {item.username}
                </th>
                <td className="py-4 px-6">{item.role}</td>
                <td className="py-4 px-6">{item.email}</td>
                <td className="py-4 px-6">{item.phone}</td>
                <td className="py-4 px-6">{item.address}</td>

                <td className="py-4 px-6">
                  {moment(item.createDate).format("LLL")}
                </td>
                <td className="py-4 px-6 text-right">
                  <a
                    href="null"
                    className="font-medium text-blue-500 hover:underline"
                  >
                    Lock
                  </a>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default AccountManagementPage;
