// src/pages/BookDetail.js
import React, { useState } from 'react';
import CoverImage from '../components/BookDetail/CoverImage';
import BookSummary from '../components/BookDetail/BookSummary';
import SubscribeButton from '../components/BookDetail/SubscribeButton';
import ReviewForm from '../components/BookDetail/ReviewForm';
import ReviewList from '../components/BookDetail/ReviewList';

// 예시용 하드코딩. 실제로는 URL 파라미터 또는 props로 전달될 수 있음
const dummyBook = {
  id: 1,
  writingId: 101,
  authorId: 12,
};

const dummyUser = {
  subscriberId: 5,
  userId: 5,
};

function BookDetail() {
  const [canRead, setCanRead] = useState(false);
  const [showForm, setShowForm] = useState(false);
  const [reviewRefreshKey, setReviewRefreshKey] = useState(0); // 리뷰 갱신 트리거

  const handleReviewSubmit = () => {
    setShowForm(false);
    setReviewRefreshKey((prev) => prev + 1); // 리뷰 새로고침 유도
  };

  return (
    <div style={{ maxWidth: '600px', margin: '0 auto', padding: '2rem' }}>
      <h2>📖 도서 상세</h2>

      {/* 표지 이미지 */}
      <CoverImage writingId={dummyBook.writingId} />

      {/* 책 요약 */}
      <BookSummary bookId={dummyBook.id} />

      {/* 구독 or 열람 버튼 */}
      <SubscribeButton
        subscriberId={dummyUser.subscriberId}
        onSubscribed={() => setCanRead(true)}
      />

      {/* 열람 시 전체 본문 보기 (예시용) */}
      {canRead && (
        <div style={{ margin: '1rem 0', backgroundColor: '#eee', padding: '1rem' }}>
          <h4>📚 도서 전체 내용</h4>
          <p>전체 본문 내용이 여기에 출력됩니다.</p>
        </div>
      )}

      {/* 리뷰 작성 버튼 + 폼 */}
      <button
        onClick={() => setShowForm(!showForm)}
        style={{
          marginTop: '1.5rem',
          marginBottom: '1rem',
          padding: '0.5rem 1rem',
          fontWeight: 'bold',
          cursor: 'pointer',
        }}
      >
        ✍️ 리뷰 작성
      </button>

      {showForm && (
        <ReviewForm
          bookId={dummyBook.id}
          userId={dummyUser.userId}
          onReviewSubmitted={handleReviewSubmit}
        />
      )}

      {/* 리뷰 목록 */}
      <ReviewList bookId={dummyBook.id} key={reviewRefreshKey} />
    </div>
  );
}

export default BookDetail;
