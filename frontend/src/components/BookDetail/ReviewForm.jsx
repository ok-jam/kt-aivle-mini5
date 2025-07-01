import React, { useState } from 'react';
import StarRating from './StarRating';
import axios from 'axios';

function ReviewForm({ bookId, userId, onReviewSubmitted }) {
  const [rating, setRating] = useState(0);
  const [comment, setComment] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (rating === 0) return alert('별점을 선택해주세요!');
    try {
      await axios.post('/bookServices', {
        bookId,
        userId,
        rating,
        review: comment,
      });
      alert('리뷰가 등록되었습니다!');
      setRating(0);
      setComment('');
      onReviewSubmitted(); // 리뷰 목록 새로고침
    } catch (err) {
      alert('리뷰 등록 실패!');
      console.error(err);
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginTop: '2rem' }}>
      <h3>📝 리뷰 작성</h3>
      <StarRating rating={rating} setRating={setRating} />
      <textarea
        value={comment}
        onChange={(e) => setComment(e.target.value)}
        placeholder="리뷰를 작성해주세요"
        rows={4}
        style={{ width: '100%', marginTop: '1rem' }}
      />
      <button type="submit" style={{ marginTop: '1rem' }}>
        등록
      </button>
    </form>
  );
}

export default ReviewForm;
