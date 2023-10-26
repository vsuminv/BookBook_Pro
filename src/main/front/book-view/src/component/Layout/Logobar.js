import React from 'react';

import styles from './Logobar.module.css';
import {NavLink} from "react-router-dom";
const Logobar = () => {

  return (
    <div className={styles.container}>
      <div className={styles.logo}>
       <NavLink to={"/"}>
          <img src={require('./image.png')} width="150px" alt='logo' />
        </ NavLink>
      </div>
    </div>
  );
};

export default Logobar;