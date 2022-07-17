import { Fragment, lazy, Suspense } from "react";
import "swiper/css";
import { Route, Routes } from "react-router-dom";
import Main from "./components/layout/Main";
import Banner from "./components/banner/Banner";
import ProductDetailPage from "pages/ProductDetailPage";
import Dashboard from "components/layout/admin/Dashboard";
import ProductManagementPage from "pages/admin/ProductManagementPage";
import CategoryManagementPage from "pages/admin/CategoryManagementPage";
import AccountManagementPage from "pages/admin/AccountManagementPage";
import OrderManagementPage from "pages/admin/OrderManagementPage";

const HomePage = lazy(() => import("./pages/HomePage"));
const ProductPage = lazy(() => import("./pages/ProductPage"));
const CartPage = lazy(() => import("./pages/CartPage"));
const LoginPage = lazy(() => import("./pages/LoginPage"));
const SignUpPage = lazy(() => import("./pages/SignupPage"));

function App() {
  return (
    <Fragment>
      <Suspense fallback={<></>}>
        <Routes>
          <Route element={<Main></Main>}>
            <Route
              path="/"
              element={
                <>
                  <Banner></Banner>
                  <HomePage></HomePage>
                </>
              }
            ></Route>
            <Route
              path="/product"
              element={<ProductPage></ProductPage>}
            ></Route>
            <Route
              path="/product/:id"
              element={<ProductDetailPage></ProductDetailPage>}
            ></Route>
            <Route path="/cart" element={<CartPage></CartPage>}></Route>
            <Route path="/login" element={<LoginPage></LoginPage>}></Route>
            <Route path="/signup" element={<SignUpPage></SignUpPage>}></Route>
            <Route path="*" element={<>Not Found 404</>}></Route>
          </Route>

          <Route element={<Dashboard></Dashboard>}>
            <Route
              path="/admin"
              element={<ProductManagementPage></ProductManagementPage>}
            ></Route>
            {/* <Route
              path="/admin/product"
              element={<ProductManagementPage></ProductManagementPage>}
            ></Route> */}
            <Route
              path="/admin/category"
              element={<CategoryManagementPage></CategoryManagementPage>}
            ></Route>
            <Route
              path="/admin/account"
              element={<AccountManagementPage></AccountManagementPage>}
            ></Route>
            <Route
              path="/admin/order"
              element={<OrderManagementPage></OrderManagementPage>}
            ></Route>
          </Route>
        </Routes>
      </Suspense>
    </Fragment>
  );
}

export default App;
