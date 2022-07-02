import { Route, Routes } from "react-router-dom";
import { AuthProvider, useAuth } from "./contexts/auth-context";
import SignUpPage from './pages/SignUpPage';
import { Suspense } from 'react';
import SignInPage from "pages/SignInPage";
import HomePage from './pages/HomePage';

function App() {
  // const { userInfo } = useAuth();
  return (
    <div>
      <AuthProvider>
        <Suspense fallback={<></>}>
          <Routes>
            <Route path="/" element={<HomePage></HomePage>} />
            <Route path="/sign-up" element={<SignUpPage></SignUpPage>}></Route>
            <Route path="/sign-in" element={<SignInPage></SignInPage>}></Route>
          </Routes>
        </Suspense>
      </AuthProvider>
    </div>
  );
}

export default App;
