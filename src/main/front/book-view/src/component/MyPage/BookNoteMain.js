import React,{useState,useEffect} from 'react';

import styles from './BookNoteMain.module.css';
import BookSearch from './BookSearch';
import { RxPlusCircled } from  'react-icons/rx';
import axios from 'axios';
import { BrowserRouter as Router , Routes , Route, Link } from "react-router-dom";
const BookNoteMain = () =>{




    return (

            <>
                <div className = {styles.mainContainer}>
                      <div className = {styles.container}>
                          <div className = {styles.topContainer}>
                              <div className = {styles.title} > 독서 노트 </div>
                               <Link  to = '/mypageMain/bookNoteMain/search' > <RxPlusCircled size = "27"/></Link>

                          </div>
                          <div className = {styles.bookNoteContainer}>

                            <div className = {styles.booklistContainer} >
                                   <div className = {styles.noteContainer} >
                                      <div className = {styles.bookContainer} >
                                          <div className = {styles.imgContainer}>
                                              <img className = {styles.logImg} src={require('../Auth/image.png')}  />
                                          </div>
                                          <div className = {styles.bookContent}>
                                              <div> 책 제목 : ~~~~</div>
                                              <div> 저자 / 출판사 : ~~~~/~~~ </div>
                                              <div> 작성 시기 : 2022/10/22 </div>
                                          </div>
                                      </div>
                                      <div className = {styles.reviewContainer}>
                                           <div> 감상평 </div>
                                           <div> 너무 좋음^^ </div>
                                      </div>
                                   </div>
                               </div>
                          </div>
                          <Routes>

                                <Route path='/search' element={<BookSearch /> }/>
                          </Routes>
                      </div>

                </div>
            </>
    )
}

export default BookNoteMain;