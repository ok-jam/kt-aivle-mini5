// src/components/BookDetail/ReviewForm.jsx
import React, { useState } from 'react';
import {
  Card,
  CardContent,
  Typography,
  TextField,
  Button,
  Box,
  Rating
} from '@mui/material';
import axios from 'axios';

function ReviewForm({ bookId, userId, onReviewSubmitted }) {
  const [rating, setRating] = useState(0);
  const [body, setBody] = useState('');
  const [title, setTitle] = useState('');

  const handleSubmit = async () => {
    try {
  await axios.post(`/reviews`, {
    bookId,
    userId,
    rating,
    title,
    body,
  });
  alert('리뷰가 성공적으로 등록되었습니다!');
  onReviewSubmitted();  // 폼 닫기 및 목록 새로고침
} catch (err) {
  console.error('리뷰 등록 실패:', err);
  alert('리뷰 등록에 실패했습니다. 다시 시도해주세요.');
}
  };

  return (
    <Card sx={{ maxWidth: 400, boxShadow: 3 }}>
      <CardContent>
        <Typography variant="h6" sx={{ mb: 1 }}>
          리뷰 작성
        </Typography>

        {/* 별점 */}
        <Box sx={{ display: 'flex', alignItems: 'center', mb: 1 }}>
          <Rating
            name="rating"
            value={rating}
            onChange={(e, newValue) => setRating(newValue)}
          />
          <Typography sx={{ ml: 1 }}>{rating}점</Typography>
        </Box>

        {/* 제목 */}
        <TextField
          label="제목"
          fullWidth
          size="small"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          sx={{ mb: 1 }}
        />

        {/* 본문 */}
        <TextField
          label="리뷰 내용"
          multiline
          rows={3}
          fullWidth
          size="small"
          value={body}
          onChange={(e) => setBody(e.target.value)}
          sx={{ mb: 2 }}
        />

        {/* 등록 버튼 */}
        <Button
          variant="contained"
          fullWidth
          onClick={handleSubmit}
          sx={{ fontWeight: 600 }}
        >
          등록
        </Button>
      </CardContent>
    </Card>
  );
}

export default ReviewForm;
