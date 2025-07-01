// src/components/BookDetail/BookSummary.jsx
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function BookSummary({ bookId }) {
  const [summary, setSummary] = useState('');

  useEffect(() => {
    const fetchBook = async () => {
      try {
        const res = await axios.get(`/books/${bookId}`); // 엔드포인트 예시
        setSummary(res.data.summary);
      } catch (err) {
        console.error('도서 요약 가져오기 실패:', err);
      }
    };

    fetchBook();
  }, [bookId]);

  return (
    <div className="book-summary-box" style={{ margin: '1rem 0', padding: '1rem', backgroundColor: '#f3f3f3' }}>
      <h3> 책 소개</h3>
      <p>{summary || '소개 정보 없음'}</p>
    </div>
  );
}

export default BookSummary;

