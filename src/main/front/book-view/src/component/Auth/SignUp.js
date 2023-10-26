import React,{useState,useEffect} from 'react';
import styles from './SignUp.module.css';
import Login from './Login';
import {  useNavigate, Link } from "react-router-dom";
import axios from 'axios';
const SignUp = () => {


const navigate = useNavigate();

    const [name,setName]= useState("");
    const [email,setEmail] = useState("");
    const [pw, setPw] = useState("");
    const [chkpw,setChkpw] =useState("");
    const [birthY, setBirthY] = useState('');
    const [birthM, setBirthM] = useState('');
    const [birthD, setBirthD] = useState('');
    const [registerDate ,setRegisterDate] = useState("");


    //오류메세지 전달
   const [nameMessage, setNameMessage] = React.useState("");
    const [emailMessage, setEmailMessage] = React.useState("");
    const [pwMessage, setPwMessage] = React.useState("");
    const [chkpwMessage, setChkPwMessage] = React.useState("");
    const [birthMessage, setBirthMessage] = React.useState("");



    //유효성 검사
    const [isname, setIsName] = React.useState(false);
    const [isemail, setIsEmail] = React.useState(false);
    const [ispw, setIsPw] = React.useState(false);
    const [ischkpw, setIsChkPw] = React.useState(false);
    const [isbirth, setIsBirth] = React.useState(false);



    const onChangeName = (e) =>{
    e.preventDefault();
        const currentName = e.currentTarget.value;
        setName(currentName);
        const name_regex = /^[가-힣]+.{2,15}$/;
        if(!name_regex.test(currentName)){
             setNameMessage("이름은 3글자 이상 15글자 이하로 공백없이 한글로 입력해주세요!");
            setIsName(false);
        }
        else{
            setNameMessage("사용가능한 이름입니다.");
            setIsName(true);

        }
        console.log(name);
    }

     const onChangeEmail = (e) => {
     e.preventDefault();
       const currentEmail = e.currentTarget.value;
       setEmail(currentEmail);
       const email_regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
       if(!email_regex.test(currentEmail)){
            setIsEmail(false)
            setEmailMessage("이메일의 형식이 올바르지 않습니다!");
       }else{
            setEmailMessage("사용 가능한 이메일 입니다.");
            setIsEmail(true);
       }
     };


    const onChangePw = (e) =>{
    e.preventDefault();
       const currentPw = e.currentTarget.value;
       setPw(currentPw);
       const passwordRegExp = /^(?=.*[a-z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,12}$/;
       if(!passwordRegExp.test(e.target.value)){
            setPwMessage("숫자+영문자+특수문자 조합으로 8자리 이상 12자리 이하 입력해주세요!" );
            setIsPw(false)
       }else{
            setPwMessage("안전한 비밀번호 입니다.");
            setIsPw(true)
       }
    }

    const onChangeChkPw = (e) => {
    e.preventDefault();
            const currentChkPw = e.currentTarget.value;
            setChkpw(currentChkPw);
            if (pw !== currentChkPw) {
               setChkPwMessage("비밀번호가 똑같지 않아요!");
               setIsChkPw(false);
             } else {
               setChkPwMessage("똑같은 비밀번호를 입력했습니다.");
               setIsChkPw(true);
             }
     }

    const YEAR = [];
    const nowYear = new Date().getFullYear();
    for(let i = 1960; i<= nowYear; i++){
        YEAR.push(i);
    }

    const MONTH = [];
    for(let i = 1; i<=12; i++){
        MONTH.push(i);
    }

    const DAY = [];
    for(let i = 1; i<=31; i++){
        let d = String(i).padStart(2,'0');
        DAY.push(d);
    }

    const handleName = (e)=>{
        setName(e.target.value);
    }

    const handleBirthY = (e)=>{
        setBirthY(e.target.value);
    }

    const handleBirthM = (e)=>{
        setBirthM(e.target.value);
    }

    const handleBirthD = (e)=>{
        setBirthD(e.target.value);
    }



    const handleSubmit = (e) =>{
    e.preventDefault();
      axios.post('http://localhost:8080/auth/join',
      {
      headers: { "Access-Control-Allow-Credentials" : true },


                               name : name,
                               email : email,
                               password : pw,
                               passwordCheck : chkpw,
                               birthY:birthY,
                               birthM:birthM,
                               birthD : birthD,
                               register_date : registerDate

                           }
                            )
                           .then((response) => {
                               console.log(response);
                               alert("회원가입성공");
                               if ((response.status = 200)){
                                    return navigate('/loginForm')
                               }


                           })
                           .catch((error) => {
                               console.log("error : ", error.response);
                           })

      }




  return (
    <div className="App">
            <div className={styles.container}>
                <div className={styles.title}>SignUp</div>
                <form className ={styles.form_Container} method = 'post' onSubmit = {handleSubmit}  >
                  <div className = {styles.input_Container}>
                    <input className ={styles.text} id = "name" value={name} placeholder='이름' onChange={onChangeName} ></input>
                    <p className={styles.message}>{nameMessage}</p>

                    <div className={styles.email}>
                        <div className = {styles.email_container}>
                            <input className ={styles.email_text} id = "email" value={email} placeholder='이메일'onChange={onChangeEmail}></input>

                            <button className = {styles.email_Check}>중복확인</button>
                        </div>
                        <p className={styles.message}>{emailMessage}</p>

                    </div>
                      <input className ={styles.text} type = "password" id = "pw" value={pw} placeholder='비밀번호' onChange={onChangePw}></input>

                      <p className={styles.message}>{pwMessage}</p>

                      <input className ={styles.text} type = "password" id = "chkpw" value={chkpw} placeholder='비밀번호 확인'onChange = {onChangeChkPw}></input>
                      <p className={styles.message}>{chkpwMessage}</p>

                     <div className = {styles.birthContainer}>
                            <select className = {styles.birthY} id={birthY} name={birthY} onChange={handleBirthY}>
                              {YEAR.map(y=>{
                                  return <option value={y}>{y}</option>;
                              })}
                            </select>
                            <select className = {styles.birthM} id={birthM} name={birthM} onChange={handleBirthM}>
                               {MONTH.map(m =>{
                                  return <option value={m}>{m}</option>
                               })}
                            </select>
                            <select className = {styles.birthD} id={birthD} name={birthD} onChange={handleBirthD}>
                               {DAY.map(d=>{
                                   return <option value={d}>{d}</option>
                               })}
                            </select>
                       </div>
                      <p className={styles.message}>{birthMessage}</p>

                      <button className ={styles.join_btn} type="submit"  >가입하기</button>
                      <div className = {styles.logContainer}>
                        이미 회원이신가요?&nbsp;&nbsp;
                        <Link  to = '/loginForm' className= {styles.linkLog} > 로그인하러가기</Link>
                      </div>

                  </div>


                </form>

            </div>

    </div>
  );
}

export default SignUp;
