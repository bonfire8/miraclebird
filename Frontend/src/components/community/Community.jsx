import React,{useEffect, useState} from "react";
import styles from './Community.module.css'
import PostMain from "./PostMain";

function Community () {

    return (
        <>
        <div className={styles.header}>
            <button className={styles.backbtn} onClick={()=>{document.location.href="/Challenge"}}><img alt="back" src="/back.png" className={styles.backicon} /></button>
            커뮤니티
            <button className={styles.createbtn} onClick={()=>{document.location.href="/Challenge/Community/Create"}}><img alt="pencil" src="/pencil.png" className={styles.pencilicon} /></button>
        </div>
        <PostMain />
        </>
    )
};

export default Community;