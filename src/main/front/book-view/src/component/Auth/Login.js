import React,{useState} from 'react';
import styles from './Login.module.css';
import Header from '../Layout/Header';
import axios from 'axios';
import {  useNavigate} from "react-router-dom";
const Login = () =>{

const navigate = useNavigate();

       const [email,setEmail] = useState("");
       const [pw, setPw] = useState("");

       //오류메세지 전달
       const [emailMessage, setEmailMessage] = React.useState("");
       const [pwMessage, setPwMessage] = React.useState("");


       const [isemail, setIsEmail] = React.useState(false);
       const [ispw, setIsPw] = React.useState(false);

  const onChangeEmail = (e) => {
    e.preventDefault();
    setEmail(e.currentTarget.value);
  };

  const onChangePw = (e) => {
    e.preventDefault();
    setPw(e.currentTarget.value);
  };

      const handleSubmit =   (e) =>{
      e.preventDefault();
        axios.get('http://localhost:8080/auth/login',
        {
        headers: { "Access-Control-Allow-Credentials" : true },

                                email : email,
                                 password : pw,
                             }
                              )
                             .then((response) => {
                                 console.log(response);
                                 alert("로그인 성공");
                                 if ((response.status = 200)){
                                    return navigate('/signUp')
                                 }

                             })
                             .catch((error) => {
                                 console.log("error : ", error.response);
                             })

        }


  return (
    <div className="App">
      <div className = {styles.pageContainer}>
      <div className = {styles.imgContainer}>
       <img className = {styles.logImg} src={require('./image.png')}  />

      </div>
      <div className={styles.container}>
      <form className ={styles.form_Container}  onSubmit = {handleSubmit}>
        <input className ={styles.text} id = "email" value={email} placeholder='이메일' onChange={onChangeEmail}></input>
        <input className ={styles.text} id = "pw"  type = "password" value={pw} placeholder='비밀번호' onChange={onChangePw}></input>
        <button className ={styles.log_btn} type="submit">로그인</button>
       </form>
       <div className = {styles.searchContainer}>
            <button className ={styles.join_btn}>회원가입</button> <span>|</span> <button className ={styles.logfile_btn}>아이디</button><button className = {styles.pw_btn}>비밀번호 찾기</button>
       </div>
      </div>

    </div>
    </div>
  );
}

export default Login;