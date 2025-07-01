// src/components/AuthorPage/AuthorInfoCard.jsx
import React from 'react';

function AuthorInfoCard({ author }) {
  return (
    <div style={{
      border: '1px solid #ccc',
      borderRadius: '10px',
      padding: '1.5rem',
      backgroundColor: '#f9f9f9'
    }}>
      <h3>작가정보</h3>
      <p><strong>비밀번호:</strong> {author.password}</p>
      <p><strong>이메일:</strong> {author.email}</p>
      <button style={{
        backgroundColor: '#4169e1',
        color: '#fff',
        border: 'none',
        padding: '0.5rem 1rem',
        borderRadius: '5px',
        cursor: 'pointer',
        marginTop: '1rem'
      }}>
        작가 삭제
      </button>
    </div>
  );
}

export default AuthorInfoCard;
