// src/components/BookDetail/ReviewList.jsx
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import ReviewCard from './ReviewCard';

function ReviewList({ bookId }) {
  const [reviews, setReviews] = useState([]);
  const [showAll, setShowAll] = useState(false);

  useEffect(() => {
    const fetchReviews = async () => {
      try {
        const res = await axios.get('/bookServices');
        const bookReviews = res.data.filter((r) => r.bookId === bookId);
        setReviews(bookReviews);
      } catch (err) {
        console.error('리뷰 불러오기 실패:', err);
      }
    };

    fetchReviews();
  }, [bookId]);

  const visibleReviews = showAll ? reviews : reviews.slice(0, 2);

  return (
    <div style={{ marginTop: '2rem' }}>
      <h3> 사용자 리뷰</h3>
      {visibleReviews.length === 0 && <p>리뷰가 아직 없습니다.</p>}
      {visibleReviews.map((review) => (
        <ReviewCard key={review.bookServiceId} review={review} />
      ))}
      {reviews.length > 2 && (
        <button
          onClick={() => setShowAll(!showAll)}
          style={{
            marginTop: '1rem',
            cursor: 'pointer',
            border: 'none',
            backgroundColor: '#f0f0f0',
            padding: '0.5rem 1rem',
            borderRadius: '5px',
          }}
        >
          {showAll ? '접기' : '전체보기'}
        </button>
      )}
    </div>
  );
}

export default ReviewList;
