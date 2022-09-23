import React, {useState} from "react";
import styles from './StudyFeed.module.css'
import Modal from 'react-bootstrap/Modal';
import {useNavigate} from 'react-router-dom';

function StudyFeed () {
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const navigate = useNavigate();

    return (
        <>
        <div className={styles.feedHeader}>
            <button className={styles.backbtn} onClick={()=>(navigate('/challenge/study'))}><img alt="back" src="/back.png" className={styles.backicon} /> Study</button>
        </div>
        <div className={styles.feeds}>
            <div className={styles.feed}>
                <img src="/study.jpg" alt="mm" className={styles.picture} onClick={handleShow}/>
            </div>
            <div className={styles.feed}>
                <img src="/study.jpg" alt="mm" className={styles.picture} onClick={handleShow}/>
            </div>
            <div className={styles.feed}>
                <img src="/study.jpg" alt="mm" className={styles.picture} onClick={handleShow}/>
            </div>
            <div className={styles.feed}>
                <img src="/study.jpg" alt="mm" className={styles.picture} onClick={handleShow}/>
            </div>
            <div className={styles.feed}>
                <img src="/study.jpg" alt="mm" className={styles.picture} onClick={handleShow}/>
            </div>
            <div className={styles.feed}>
                <img src="/study.jpg" alt="mm" className={styles.picture} onClick={handleShow}/>
            </div>
        </div>
        
        <Modal
            centered
            show={show}
            onHide={handleClose}
            backdrop="static"
            keyboard={false}
        >
            <Modal.Header className={styles.modalheader} closeButton>
            </Modal.Header>
            <Modal.Body className={styles.modalcontent} closeButton>
                <img src="/study.jpg" alt="mm" className={styles.picture} />
                <button className={styles.reportbtn}><img alt="siren" src="/siren.png" className={styles.sirenicon} />신고하기</button>
                <div className={styles.detail}>
                    <p>닉네임</p>
                    <p>시즌1 스터디</p>
                    <p>2022/09/08</p>
                </div>
            </Modal.Body>
        </Modal>

        </>
    )
}

export default StudyFeed;