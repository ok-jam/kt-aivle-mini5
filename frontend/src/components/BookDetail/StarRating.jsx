// src/components/common/StarRating.jsx
import React from 'react';

function StarRating({ rating, setRating }) {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
      {/* 별 아이콘 */}
      <div>
        {[1, 2, 3, 4, 5].map((num) => (
          <span
            key={num}
            onClick={() => setRating(num)}
            style={{
              fontSize: '1.8rem',
              cursor: 'pointer',
              color: num <= rating ? '#FFD700' : '#ccc', // 노란색 / 회색
              marginRight: '5px',
              transition: 'transform 0.2s ease',
            }}
            onMouseEnter={(e) => (e.target.style.transform = 'scale(1.2)')}
            onMouseLeave={(e) => (e.target.style.transform = 'scale(1)')}
          >
            ★
          </span>
        ))}
      </div>

      {/* 별 밑 숫자 */}
      <div style={{ marginTop: '0.2rem', fontSize: '0.8rem', color: '#888' }}>
        {[1, 2, 3, 4, 5].map((n) => (
          <span key={n} style={{ marginRight: '1.3rem' }}>{n}</span>
        ))}
      </div>
    </div>
  );
}

export default StarRating;
