import React, { useEffect, useState } from 'react';
import axios from 'axios';
import ReviewCard from './ReviewCard';
import ReviewModal from './ReviewModal'; // 모달 import
import { Card, CardContent, Typography, Button } from '@mui/material';

function ReviewList({ bookId }) {
  const [reviews, setReviews] = useState([]);
  const [showAll, setShowAll] = useState(false);
  const [isModalOpen, setIsModalOpen] = useState(false); // 모달 상태

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

  const visibleReviews = reviews.slice(0, 2); // 앞 2개만 보여줌

  return (
    <>
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
              onClick={() => setIsModalOpen(true)} // 전체보기 → 모달 열기
              sx={{ mt: 2 }}
              size="small"
              variant="outlined"
            >
              전체보기
            </Button>
          )}
        </CardContent>
      </Card>

      {/* 전체보기 모달 */}
      <ReviewModal
        isOpen={isModalOpen}
        onClose={() => setIsModalOpen(false)}
        reviews={reviews}
      />
    </>
  );
}

export default ReviewList;

