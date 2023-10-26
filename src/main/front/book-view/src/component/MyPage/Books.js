import React,{useState,useEffect} from 'react';
import styles from './BookSearch.module.css';
import axios from 'axios';
const Books = ({info}) =>{



    return (
            <>

                <div className={styles.container}>
                 <input className ={styles.text}   placeholder='검색'  ></input>

                <hr />
                    <div>
                       { bookList.map((books) => {
                       <div key={books.book_id} className={styles.book_Container}>
                                                   <div className={styles.left}>
                                                       <img src ={books.book_img} />이미지</div>
//
                                                   <div className={styles.right}>
                                                       <div>{books.book_title} </div>
                                                       <div>{books.book_author} / {books.book_publisher}</div>
                                                   </div>
                                               </div>

                       }) }
                    </div>
                </div>
            </>
    )
}

export default Books;