import React,{useState,useEffect} from 'react';
import styles from './BookSearch.module.css';
import axios from 'axios';
const Books = () =>{



    return (
            <>

                <div className={styles.container}>
                 <input className ={styles.text}   placeholder='검색'  ></input>

                <hr />
                    <div>

                    </div>
                </div>
            </>
    )
}

export default Books;