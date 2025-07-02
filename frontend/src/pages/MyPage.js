import React, { useState } from 'react';
import HomeButton from '../components/HomeButton';
import { ReChargeModal } from './ReChargeModal';
import { AuthorRegisterModal } from './AuthorRegisterModal';
import { SubscriptionModal } from './SubscriptionModal';

import axios from 'axios';

const styles = {
  pageBackground: {
    backgroundColor: '#EEF6FF',
    minHeight: '100vh',
    padding: '40px',
    fontFamily: 'Arial, sans-serif',
  },
  topHeader: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: '24px',
  },
  pageTitle: {
    fontSize: '24px',
    fontWeight: 'bold',
    color: '#1F3C88',
  },
  moveAuthorPageBtn: {
    backgroundColor: '#3566A2',
    color: '#FFF',
    border: 'none',
    borderRadius: '6px',
    padding: '8px 16px',
    fontSize: '14px',
    cursor: 'pointer',
  },
  contentGrid: {
    display: 'grid',
    gridTemplateColumns: '1fr 2fr',
    gap: '20px',
  },
  sectionWrapper: {
    display: 'grid',
    gap: '24px',
  },
  sectionHeader: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: '8px',
  },
  sectionTitle: {
    fontSize: '18px',
    fontWeight: 'bold',
    color: '#111827',
  },
  lightButton: {
    backgroundColor: '#E6F0FF',
    color: '#3566A2',
    border: 'none',
    borderRadius: '20px',
    padding: '6px 16px',
    cursor: 'pointer',
    fontSize: '14px',
  },
  section: {
    backgroundColor: '#FFF',
    borderRadius: '12px',
    padding: '20px',
  },
  table: {
    width: '100%',
    borderCollapse: 'collapse',
  },
  th: {
    textAlign: 'left',
    padding: '8px 0',
    borderBottom: '1px solid #D1D5DB',
    color: '#333',
  },
  td: {
    padding: '12px 0',
    borderBottom: '1px solid #E5E7EB',
    color: '#555',
  },
  smallButton: {
    backgroundColor: '#3566A2',
    color: '#FFF',
    border: 'none',
    borderRadius: '12px',
    padding: '6px 12px',
    cursor: 'pointer',
    fontSize: '12px',
    marginLeft: '8px',
  },
  separator: {
  height: '1px',
  backgroundColor: '#D1D5DB',
  margin: '16px 0',
}
};


export default function MyPage() {
  const [showRecharge, setShowRecharge] = useState(false);
  const [showAuthorModal, setShowAuthorModal] = useState(false);
  const [showSubscribeModal, setShowSubscribeModal] = useState(false);

  const user = { email: 'asdf@1234', password: 'asdf1234' };
  const subscriptions = [
    { id: 1, title: '리액트로 웹사이트 만들기', date: '2025-06-15' },
    { id: 2, title: '자바스크립트 완전 정복', date: '2025-05-20' },
  ];
  const points = ['포인트 로그인 내역', '포인트 로그인 내역', '포인트 로그인 내역'];

  return (
    <div style={styles.pageBackground}>
      {/* 상단 헤더 */}
      <div style={styles.topHeader}>
        <h1 style={styles.pageTitle}>마이페이지</h1>
        <button style={styles.moveAuthorPageBtn}>작가 페이지로 이동</button>
      </div>
      <div style={styles.separator}></div>
      {/* 본문 그리드 */}
      <div style={styles.contentGrid}>
        {/* 왼쪽 컬럼 */}
        <div style={styles.sectionWrapper}>

          {/* 회원정보 섹션 */}
          <div>
            <div style={styles.sectionHeader}>
              <h2 style={styles.sectionTitle}>회원정보</h2>
              <button style={styles.lightButton} onClick={() => setShowAuthorModal(true)}>작가 등록</button>
            </div>
            <section style={styles.section}>
              <p>이메일 : {user.email}</p>
              <p>비밀번호 : {user.password}</p>
            </section>
          </div>

          {/* 포인트 섹션 */}
          <div>
            <div style={styles.sectionHeader}>
              <h2 style={styles.sectionTitle}>포인트</h2>
              <button style={styles.lightButton} onClick={() => setShowRecharge(true)}>포인트 충전</button>
            </div>
            <section style={styles.section}>
              <ul>
                {points.map((log, i) => (
                  <li key={i}>{log}</li>
                ))}
              </ul>
            </section>
          </div>
        </div>

        {/* 오른쪽: 구독한 도서 목록 */}
        <div>
          <div style={styles.sectionHeader}>
            <h2 style={styles.sectionTitle}>구독한 도서 목록</h2>
            <button style={styles.lightButton} onClick={() => setShowSubscribeModal(true)}>월 구독권 구매</button>
          </div>
          <section style={styles.section}>
            <table style={styles.table}>
              <thead>
                <tr>
                  <th style={styles.th}>No</th>
                  <th style={styles.th}>도서 제목</th>
                  <th style={styles.th}>출간 일자</th>
                  <th style={styles.th}></th>
                </tr>
              </thead>
              <tbody>
                {subscriptions.map((sub, idx) => (
                  <tr key={sub.id}>
                    <td style={styles.td}>{idx + 1}</td>
                    <td style={styles.td}>{sub.title}</td>
                    <td style={styles.td}>{sub.date}</td>
                    <td style={styles.td}>
                      <button style={styles.smallButton}>상세 보기</button>
                      <button style={styles.smallButton}>삭제</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </section>
        </div>
      </div>

      {/* 모달들 */}
      <ReChargeModal
        visible={showRecharge}
        onCancel={() => setShowRecharge(false)}
        onConfirm={(amount) => {
          console.log(`${amount}원 충전 요청`);
          setShowRecharge(false);
        }}
      />

      {/* 작가 등록 모달 */}
      {/* <AuthorRegisterModal
        visible={showAuthorModal}
        onCancel={() => setShowAuthorModal(false)}
        onConfirm={({ name, intro, portfolio }) => {
          console.log('작가 등록 요청:', name, intro, portfolio);
          setShowAuthorModal(false);
        }}
      /> */}
      <AuthorRegisterModal
        visible={showAuthorModal}
        onCancel={() => setShowAuthorModal(false)}
        onConfirm={async ({ name, intro, portfolio }) => {
          try {
            const response = await axios.post('/authors', {
              name,
              introduction: intro,
              portfolioUrl: portfolio,
            });

            console.log('작가 등록 성공:', response.data);
            alert('작가 등록 요청이 전송되었습니다!');
          } catch (error) {
            console.error('작가 등록 실패:', error);
            alert('작가 등록 중 오류가 발생했습니다.');
          } finally {
            setShowAuthorModal(false);
          }
        }}
      />
      

      {/* 월 구독권 구매 모달 */}
      <SubscriptionModal
        visible={showSubscribeModal}
        onCancel={() => setShowSubscribeModal(false)}
        onConfirm={() => {
          console.log('월 구독권 구매 요청');
          setShowSubscribeModal(false);
        }}
      />
    </div>
  );
}
 