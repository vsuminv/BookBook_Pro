import React from 'react';
import styles from './Header.module.css';
import Logobar from './Logobar';
import { Routes , Route, Link } from "react-router-dom";



import SignUp from '../Auth/SignUp';
import Login from '../Auth/Login';
import Home from './Home';
import Main from '../MyPage/Main';


const Header = () => {
  return (
     <div className={styles.background}>
     <div className = {styles.header}>
                   <Logobar />
                 <button> <Link to = '/signUp' > 회원가입 </Link></button>
                 <button> <Link to = '/loginForm' > 로그인 </Link></button>
                <button> <Link to = '/mypageMain' > 마이페이지 </Link></button>
     </div>

    </div>


  );
}

export default Header;