import React from 'react';
import { Box, Grid } from '@mui/material';
import CoverImage from './CoverImage';
import BookSummary from './BookSummary';

function BookDetailSection({ bookId }) {
  return (
    <Box sx={{ p: 3 }}>
      <Grid container spacing={3}>
        <Grid item xs={12} md={4}>
          <CoverImage bookId={bookId} />
        </Grid>
        <Grid item xs={12} md={8}>
          <BookSummary bookId={bookId} />
        </Grid>
      </Grid>
    </Box>
  );
}

export default BookDetailSection;
