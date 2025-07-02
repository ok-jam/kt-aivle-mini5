import HomeButton from '../components/HomeButton';
import { ReChargeModal } from './ReChargeModal';
import React, { useState } from 'react';
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
  innerContainer: {
    backgroundColor: '#F5F7FA',  // 전체 컨테이너 연회색
    borderRadius: '16px',
    padding: '0',                 // 헤더와 섹션 사이 여백 직접 조절
  },
  header: {
    display: 'flex',
    alignItems: 'center',
    backgroundColor: '#FFF',      // 헤더만 흰색
    padding: '16px 24px',
    borderTopLeftRadius: '16px',
    borderTopRightRadius: '16px',
  },
  logo: { height: '32px' },
  navWrapper: {
    flex: 1,
    display: 'flex',
    justifyContent: 'center',
  },
  navButton: {
    background: 'none',
    border: 'none',
    color: '#3566A2',
    cursor: 'pointer',
    fontSize: '16px',
    margin: '0 20px',
  },
  logout: {
    backgroundColor: '#3566A2',
    color: '#FFF',
    border: 'none',
    borderRadius: '4px',
    padding: '6px 12px',
    cursor: 'pointer',
    fontSize: '14px',
  },

  // “라이트 버튼” 스타일 (포인트 충전, 작가 등록)
  lightButton: {
    backgroundColor: '#E6F0FF',
    color: '#3566A2',
    border: 'none',
    borderRadius: '20px',
    padding: '6px 16px',
    cursor: 'pointer',
    fontSize: '14px',
  },

  separator: {
    height: '1px',
    backgroundColor: '#D1D5DB',
    margin: '0 24px',
  },
  contentGrid: {
    display: 'grid',
    gridTemplateColumns: '1fr 2fr',
    gap: '20px',
    padding: '24px',
  },
  section: {
    backgroundColor: '#FFF',
    borderRadius: '12px',
    padding: '20px',
  },
  sectionHeader: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: '12px',
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
};

export default function MyPage() {
  const [showRecharge, setShowRecharge] = useState(false);
  const [showAuthorModal, setShowAuthorModal] = useState(false);
  const [showSubscribeModal, setShowSubscribeModal] = useState(false);

  const user = { email: '', password: '' };
  const subscriptions = [
    { id: 1, title: '리액트로 웹사이트 만들기', date: '2025-06-15' },
    { id: 2, title: '자바스크립트 완전 정복', date: '2025-05-20' },
  ];
  const points = [
    '포인트 로그인 내역',
  ];

  return (
    <div style={styles.pageBackground}>
      <div style={styles.innerContainer}>
        {/* 헤더 */}
        <header style={styles.header}>
          <HomeButton />

          <div style={styles.navWrapper}>
            <button style={styles.navButton}>도서 등록</button>
          </div>
          <button style={styles.logout}>로그아웃</button>
        </header>

        {/* 구분선 */}
        <div style={styles.separator} />

        {/* 본문 그리드 */}
        <div style={styles.contentGrid}>
          {/* 왼쪽: 회원정보 + 포인트 */}
          <div style={{ display: 'grid', gap: '20px' }}>
            {/* 회원정보 섹션 */}
            <section style={styles.section}>
              <div style={styles.sectionHeader}>
                <h2>회원정보</h2>
                <button
                  style={styles.lightButton}
                  onClick={() => setShowAuthorModal(true)}   // ← 여기
                >
                  작가 등록
                </button>

              </div>
              <p>이메일: {user.email}</p>
              <p>비밀번호: {user.password}</p>
            </section>

            {/* 포인트 섹션 */}
            <section style={styles.section}>
              <div style={styles.sectionHeader}>
                <h2>포인트</h2>
                <button style={styles.lightButton}
                 onClick={() => setShowRecharge(true)}
                 >
                  포인트 충전
                </button>
              </div>
              <ul>
                {points.map((log, i) => <li key={i}>{log}</li>)}
              </ul>
            </section>
          </div>

          {/* 오른쪽: 구독한 도서 */}
          <section style={styles.section}>
            <div style={styles.sectionHeader}>
              <h2>구독한 도서 목록</h2>
              <button
              style={styles.lightButton}
              onClick={() => setShowSubscribeModal(true)}  // ← 클릭 시 모달 열기
            >
              월 구독권 구매
            </button>
            </div>
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
      {/* 포인트 충전 모달 */}
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
          // TODO: API 호출 등 실제 등록 로직 연결
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
          // TODO: 실제 구독 API 호출
        }}
      />
    </div>
  );
}