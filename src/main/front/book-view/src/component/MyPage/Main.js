import styles from './Main.module.css';
import { BrowserRouter as Router , Routes , Route, Link } from "react-router-dom";

import React,{useState,useEffect} from 'react';

import axios from 'axios';

import BookNoteMain from './BookNoteMain' ;
import Goal from './Goal';
import BookSearch from './BookSearch'
const Main = (props) =>{









    return (

        <div className = {styles.container} >
            <div className = {styles.menuContainer}>
                <div className = {styles.menuBtn}>
                            <div className = {styles.menu} >
                                 <div className = {styles.linkBtn}><Link  to="/mypageMain/goal">올해 독서 목표</Link></div>
                            </div>
                             <div className = {styles.menu}>
                                  <div className = {styles.linkBtn}><Link to = '/mypageMain/bookNoteMain'>독서 노트</Link></div>
                             </div>

                            <div className = {styles.menu}>
                                 <div className = {styles.linkBtn}><Link to = '/mypageMain'>한줄평</Link></div>
                            </div>
                             <div className = {styles.menu}>
                                  <div className = {styles.linkBtn}><Link to = '/mypageMain/bookNoteMain'>게시판</Link></div>
                             </div>
                              <div className = {styles.menu}>
                                  <div className = {styles.linkBtn}><Link to = '/mypageMain'>회원정보 수정</Link></div>
                              </div>

                    <button className = {styles.secession}> 탈퇴하기 </button>
                </div>

            </div>
              <div className ={styles.contentContainer}>

                            <div className ={styles.content}>


                                        <Routes>

                                         <Route path='/bookNoteMain/*' element={<BookNoteMain /> }/>
                                         <Route path = '/bookNoteMain/search' element = {<BookSearch />} />
                                         <Route path="/goal" element={<Goal />}  />


                                        </Routes>


                            </div>

                        </div>
                        <div>
                                               { bookList.map(function(a, i){
                                                return(
                                                    <div>{bookList[i].book_title} </div>
                                                )
                                               })}

                                        </div>



        </div>

    );
}



export default Main;