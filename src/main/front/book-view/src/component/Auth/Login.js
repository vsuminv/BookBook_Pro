import React,{useState} from 'react';
import styles from './Login.module.css';
import Header from '../Layout/Header';
import axios from 'axios';
import {  useNavigate, Link } from "react-router-dom";
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
      const currentEmail = e.currentTarget.value;
           setEmail(currentEmail);
           const email_regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
           if(email != currentEmail){
                setIsEmail(false)
                setEmailMessage("이메일의 형식이 올바르지 않습니다!");
           }else{
                setEmailMessage("사용 가능한 이메일 입니다.");
                setIsEmail(true);
           }
  };

  const onChangePw = (e) => {
      const currentPw = e.currentTarget.value;
           setPw(currentPw);
           if(pw != currentPw){
                setPwMessage("비밀번호가 틀렸습니다" );
                setIsPw(false)
           }else{
                setPwMessage("안전한 비밀번호 입니다.");
                setIsPw(true)
           }
  };


      const handleSubmit =   (e) =>{
      e.preventDefault();
        axios.post('http://localhost:8080/auth/login',
        {
             headers: { "Access-Control-Allow-Origin" : true },
            email : email,
            password : pw,
        })

        .then((response) => {
                if ((response.status = 200)){
                    alert("로그인 성공");
                    return navigate('/')
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
            <Link  to = '/signup' className= {styles.join_btn} > 회원가입 </Link> <span>|</span> <button className ={styles.logfile_btn}>아이디</button><button className = {styles.pw_btn}>비밀번호 찾기</button>
       </div>
      </div>

    </div>
    </div>
  );
}

export default Login;