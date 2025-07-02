import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Typography, Card, CardContent } from '@mui/material';

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
    <Card variant="outlined" sx={{ 
      mt: 2, 
      backgroundColor: '#ffffff',
      minHeight: '250px',
      width: '300%',
      borderRadius: 2,

    }}>
      <CardContent>
        <Typography variant="body1" color="text.secondary">
          {summary || '소개 정보 없음'}
        </Typography>
      </CardContent>
    </Card>
  );
}

export default BookSummary;

