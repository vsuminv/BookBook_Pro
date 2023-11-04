 import axios from 'axios';

 const  duplicationEmailCheck = (email) => {
 let return_value;
 axios.post('http://localhost:8080/auth/join',
       {

          email : email,

       })
       .then((response) => {
          return_value = response.data;
        })
       .catch((error) => {
          console.log("error : ", error.response);
          return_value = true;
       })
       return return_value;


 }

export default duplicationEmailCheck;