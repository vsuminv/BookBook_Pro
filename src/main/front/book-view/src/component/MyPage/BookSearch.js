import React,{useState,useEffect} from 'react';
import styles from './BookSearch.module.css';
import axios from 'axios';
import Books from './Books'

const BookSearch = () =>{


const [ data, setData ] = useState([]);

     useEffect(() => {
            putSpringData();
        },[])

  async function putSpringData() {
        await axios
        .get("http://localhost:8080/books/books")
        .then((res)=>{
            console.log(res.data);
            setData(res.data);
        })
        .catch((err)=>{
            console.log(err);
        })
    }


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

export default BookSearch;