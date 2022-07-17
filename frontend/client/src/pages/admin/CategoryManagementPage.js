import React, { useEffect, useState } from "react";
import CategoryService from "services/CategoryService";

const CategoryManagementPage = () => {
  const [data, setData] = useState([]);
  const getData = async () => {
    CategoryService.getAllCategories()
      .then((res) => {
        setData(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }

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
                Category name
              </th>
              <th scope="col" className="py-3 px-6">
                Desc
              </th>
              <th scope="col" className="py-3 px-6">
                Status
              </th>
              <th scope="col" className="py-3 px-6">
               Action
              </th>
            </tr>
          </thead>

          <tbody>
            {data.map((item) => (
              <tr className="border-b bg-gray-800 border-gray-700 hover:bg-gray-600">
                <th
                  scope="row"
                  className="py-4 px-6 font-medium whitespace-nowrap text-white"
                >
                  {item.name}
                </th>
                <td className="py-4 px-6">{item.description}</td>
                <td className="py-4 px-6">{item.status}</td>
                <td className="py-4 px-6 text-right">
                  <a
                    href="null"
                    className="font-medium text-blue-500 hover:underline"
                  >
                    Edit
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

export default CategoryManagementPage;
