import { initializeApp } from "firebase/app";
import { getFirestore } from "firebase/firestore";
import { getAuth } from "firebase/auth";

const firebaseConfig = {
  apiKey: "AIzaSyDrViwoT4kGA1kD3B0QoFdaZC4CVTwauWY",
  authDomain: "rental-movie.firebaseapp.com",
  projectId: "rental-movie",
  storageBucket: "rental-movie.appspot.com",
  messagingSenderId: "493596758371",
  appId: "1:493596758371:web:eee29a6db4d63d071d0356",
};

const app = initializeApp(firebaseConfig);
export const db = getFirestore(app);
export const auth = getAuth(app);
