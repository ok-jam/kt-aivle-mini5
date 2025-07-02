import React, { useEffect, useState } from 'react';
import axios from 'axios';
import ReviewCard from './ReviewCard';
import { Card, CardContent, Typography, Button } from '@mui/material';

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
    <Card sx={{ mt: 5, bgcolor: '#fff' }}>
      <CardContent>
        <Typography variant="h6" fontWeight="bold" gutterBottom>
          사용자 리뷰
        </Typography>

        {visibleReviews.length === 0 ? (
          <Typography variant="body2" color="text.secondary">
            리뷰가 아직 없습니다.
          </Typography>
        ) : (
          visibleReviews.map((review) => (
            <ReviewCard key={review.bookServiceId} review={review} />
          ))
        )}

        {reviews.length > 2 && (
          <Button
            onClick={() => setShowAll(!showAll)}
            sx={{ mt: 2 }}
            size="small"
            variant="outlined"
          >
            {showAll ? '접기' : '전체보기'}
          </Button>
        )}
      </CardContent>
    </Card>
  );
}

export default ReviewList;

