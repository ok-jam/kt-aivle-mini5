// src/pages/BookDetail.js
import React, { useState } from 'react';
import CoverImage from '../components/BookDetail/CoverImage';
import BookSummary from '../components/BookDetail/BookSummary';
import SubscribeButton from '../components/BookDetail/SubscribeButton';
import ReviewForm from '../components/BookDetail/ReviewForm';
import ReviewList from '../components/BookDetail/ReviewList';
import { Grid, Box, Button, Typography } from '@mui/material';
import EditIcon from '@mui/icons-material/Edit';
import IconButton from '@mui/material/IconButton';
import { Card, CardContent } from '@mui/material';

const dummyBook = {
  id: 1,
  writingId: 101,
  authorId: 12,
};

const dummyUser = {
  subscriberId: 5,
  userId: 5,
};
const bookData = {
  title: 'Sample Title',
  authorName: '예나 작가',
  publishedAt: '2025-05-29T12:00:00',
};


function BookDetail() {
  const [canRead, setCanRead] = useState(false);
  const [showForm, setShowForm] = useState(false);
  const [reviewRefreshKey, setReviewRefreshKey] = useState(0);

  const handleReviewSubmit = () => {
    setShowForm(false);
    setReviewRefreshKey((prev) => prev + 1);
  };

  return (
    <Box sx={{ maxWidth: '900px', margin: '0 auto', padding: '2rem',backgroundColor: '#f5f9ff',borderRadius: 2 }}>
      <Typography variant="h4" sx={{ mb: 1, fontWeight: 700, color: '#1976d2' }}>
        {bookData.title || '제목 없음'}
      </Typography>
      <Typography variant="body2" sx={{ mb: 3, color: 'text.secondary' }}>
        작성자: {bookData.authorName || '○○○'} / 작성일: {bookData.publishedAt?.slice(0, 10) || '작성일 없음'}
      </Typography>
      <hr style={{ marginBottom: '24px', border: '0.5px solid #ccc' }} />

      {/* 상단: 표지 이미지 + 책 소개 */}
      <Grid container spacing={3}>
        <Grid item xs={12} md={4}>
          <Card variant="outlined" sx={{ backgroundColor: '#ffffff', p: 2 }}>
            <CoverImage writingId={dummyBook.writingId} />
          </Card>
        </Grid>
        <Grid item xs={12} md={8}>
          <BookSummary bookId={dummyBook.id} />
          </Grid>
        </Grid>

      {/* 구독 버튼 */}
      <Box sx={{ mt: 3 }}>
        <SubscribeButton
          subscriberId={dummyUser.subscriberId}
          onSubscribed={() => setCanRead(true)}
        />
      </Box>

      {/* 도서 전체 내용 표시 (구독 시) */}
      {canRead && (
        <Box sx={{ mt: 2, p: 2, bgcolor: '#f9f9f9', borderRadius: 2 }}>
          <Typography variant="h6">도서 전체 내용</Typography>
          <Typography>전체 본문 내용이 여기에 출력됩니다.</Typography>
        </Box>
      )}

      {/* 리뷰 작성 */}
      <Button
        variant="contained"
        size="small"
        startIcon={<EditIcon />}
        onClick={() => setShowForm(!showForm)}
        sx={{ mt: 3 }}
      >
        리뷰 작성
      </Button>

      {showForm && (
        <Box sx={{ mt: 2 }}>
          <ReviewForm
            bookId={dummyBook.id}
            userId={dummyUser.userId}
            onReviewSubmitted={handleReviewSubmit}
          />
        </Box>
      )}

      {/* 리뷰 리스트 */}
      <Box sx={{ mt: 4 }}>
        <ReviewList bookId={dummyBook.id} key={reviewRefreshKey} />
      </Box>
    </Box>
  );
}

export default BookDetail;

