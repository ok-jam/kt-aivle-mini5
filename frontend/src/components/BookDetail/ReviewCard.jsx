// src/components/BookDetail/ReviewCard.jsx
import React from 'react';

function ReviewCard({ review }) {
  const renderStars = (rating) => {
    return (
      <>
        {[...Array(5)].map((_, idx) => (
          <span
            key={idx}
            style={{
              color: idx < rating ? '#FFD700' : '#ccc',
              fontSize: '1.2rem',
              marginRight: '2px',
            }}
          >
            ★
          </span>
        ))}
      </>
    );
  };

  return (
    <div
      style={{
        border: '1px solid #ddd',
        borderRadius: '8px',
        padding: '1rem',
        marginBottom: '1rem',
        backgroundColor: '#fff',
      }}
    >
      <div>{renderStars(review.rating)}</div>
      <p style={{ margin: '0.5rem 0' }}>{review.review}</p>
      <small style={{ color: '#888' }}>👤 User {review.userId}</small>
    </div>
  );
}

export default ReviewCard;


