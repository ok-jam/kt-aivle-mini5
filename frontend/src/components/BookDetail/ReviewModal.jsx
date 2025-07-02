// src/components/BookDetail/ReviewModal.jsx

import React from 'react';
import {
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  Button,
  Typography,
} from '@mui/material';
import ReviewCard from './ReviewCard';

function ReviewModal({ open, onClose, reviews }) {
  return (
    <Dialog open={open} onClose={onClose} maxWidth="md" fullWidth>
      <DialogTitle>전체 사용자 리뷰</DialogTitle>
      <DialogContent dividers>
        {reviews.length === 0 ? (
          <Typography variant="body2" color="text.secondary">
            아직 작성된 리뷰가 없습니다.
          </Typography>
        ) : (
          reviews.map((review) => (
            <ReviewCard key={review.bookServiceId} review={review} />
          ))
        )}
      </DialogContent>
      <DialogActions>
        <Button onClick={onClose} variant="contained">
          닫기
        </Button>
      </DialogActions>
    </Dialog>
  );
}

export default ReviewModal;

