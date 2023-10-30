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
        <div className={styles.btn_Container}>
            <button className = {styles.sign} > <Link to = '/signUp' > 회원가입 </Link></button>
            <button className = {styles.login}> <Link to = '/loginForm' > 로그인 </Link></button>
            <button className = {styles.mypage}> <Link to = '/mypageMain' > 마이페이지 </Link></button>
        </div>


     </div>

    </div>


  );
}

export default Header;