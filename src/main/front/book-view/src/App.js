//import './App.css';
import SignUp from './component/Auth/SignUp';
import Header from './component/Layout/Header';
import Login from './component/Auth/Login';
import Home from './component/Layout/Home';
import Main from './component/MyPage/Main';
import Logobar from './component/Layout/Logobar';
import { BrowserRouter } from "react-router-dom";

import { Routes , Route, Link } from "react-router-dom";


function App() {
     return(
        <div className="App">

            <Header />

                    <Routes>
                      <Route path="/" element={<Home />} />
                      <Route path="/mypageMain/*" element={<Main />} />
                      <Route path="/loginForm" element={<Login />} />
                      <Route path="/signUp" element={<SignUp />} />
                    </Routes>


        </div>
     );

}



export default App;