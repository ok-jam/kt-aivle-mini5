import React, { useState } from 'react';
import CoverImage from '../components/BookDetail/CoverImage';
import BookSummary from '../components/BookDetail/BookSummary';
import SubscribeButton from '../components/BookDetail/SubscribeButton';
import ReviewForm from '../components/BookDetail/ReviewForm';
import ReviewList from '../components/BookDetail/ReviewList';
import { FaPen } from 'react-icons/fa'; // ✏️ 아이콘

const styles = {
  page: {
    backgroundColor: '#EEF6FF',
    minHeight: '100vh',
    padding: '40px',
    fontFamily: 'Arial, sans-serif',
  },
  header: {
    borderBottom: '2px solid #B0C4DE',
    paddingBottom: '12px',
    marginBottom: '24px',
  },
  title: {
    fontSize: '32px',
    fontWeight: 'bold',
    color: '#1F3C88',
    marginBottom: '8px',
  },
  subInfo: {
    color: '#555',
    fontSize: '16px',
  },
  layout: {
    display: 'flex',
    gap: '24px',
  },
  leftBox: {
    flex: '0 0 180px',
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },
  centerBox: {
    flex: 1,
    backgroundColor: '#FFF',
    padding: '16px',
    borderRadius: '12px',
    maxHeight: '500px',
    overflowY: 'auto',
  },
  rightBox: {
    flex: '0 0 280px',
    display: 'flex',
    flexDirection: 'column',
    gap: '16px',
  },
  sectionTitle: {
    fontWeight: 'bold',
    fontSize: '16px',
    marginBottom: '4px',
  },
  reviewHeader: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  penIcon: {
    cursor: 'pointer',
    fontSize: '16px',
    color: '#333',
  },
  fullViewLink: {
    fontSize: '14px',
    textAlign: 'right',
    color: '#2563eb',
    cursor: 'pointer',
    marginTop: '4px',
  },
};

export default function BookDetailSection() {
  const [showForm, setShowForm] = useState(false); // 리뷰 작성 폼 토글

  return (
    <div style={styles.page}>
      {/* 상단 제목 */}
      <div style={styles.header}>
        <div style={styles.title}>Sample Title</div>
        <div style={styles.subInfo}>작성자: ○○○ / 작성일: 2025-05-29</div>
      </div>

      {/* 전체 본문 영역 */}
      <div style={styles.layout}>
        {/* 왼쪽: 이미지 + 구독 */}
        <div style={styles.leftBox}>
          <CoverImage />
          <SubscribeButton />
        </div>

        {/* 중앙: 본문 내용 */}
        <div style={styles.centerBox}>
          <BookSummary />
        </div>

        {/* 오른쪽: 리뷰 작성 + 리스트 */}
        <div style={styles.rightBox}>
          {/* 평점 및 리뷰 */}
          <div>
            <div style={{ ...styles.sectionTitle, ...styles.reviewHeader }}>
              <span>평점 및 리뷰</span>
              <FaPen
                onClick={() => setShowForm(!showForm)}
                style={styles.penIcon}
              />
            </div>
            {showForm && (
              <div style={{ marginBottom: '16px' }}>
                <ReviewForm />
              </div>
            )}
          </div>

          {/* 리뷰 리스트 */}
          <div>
            <ReviewList bookId={1} />
            <div style={styles.fullViewLink}>전체보기</div>
          </div>
        </div>
      </div>
    </div>
  );
}
