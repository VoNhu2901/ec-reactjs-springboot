import { initializeApp } from "firebase/app";
import { getFirestore } from "firebase/firestore";
import { getAuth } from "firebase/auth";
const firebaseConfig = {
  apiKey: "AIzaSyC9qP_NkIrx8-4Za0qnGmgkLhtP5aP-lJQ",
  authDomain: "movie-management-rookie.firebaseapp.com",
  projectId: "movie-management-rookie",
  storageBucket: "movie-management-rookie.appspot.com",
  messagingSenderId: "163288018563",
  appId: "1:163288018563:web:31c10100704c33bcdd75b6",
};

const app = initializeApp(firebaseConfig);
export const db = getFirestore(app);
export const auth = getAuth(app);
