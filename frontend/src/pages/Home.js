<<<<<<< HEAD
import React from 'react';
import {
  AppBar,
  Toolbar,
  Button,
  Typography,
  Box,
  TextField,
  InputAdornment,
  IconButton,
  Card,
  CardMedia,
  CardContent,
  Chip,
  Container,
  Stack,
  ThemeProvider,
  createTheme,
} from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import MenuBookIcon from '@mui/icons-material/MenuBook';
import { Link } from 'react-router-dom'; // ✅ 추가

const sampleBooks = [
  {
    id: 1,
    title: 'Book Title',
    date: '2025-05-28',
    views: 3125,
    thumbnail: '/img/thumbnail1.png',
  },
  {
    id: 2,
    title: 'Book Title',
    date: '2025-05-28',
    views: 3125,
    thumbnail: '/img/thumbnail2.png',
  },
  {
    id: 3,
    title: 'Book Title',
    date: '2025-05-28',
    views: 3125,
    thumbnail: '/img/thumbnail3.png',
  },
];
=======
export default function Home() {
  const books = [
    { title: 'Book Title', date: '2025-05-28', views: '3,125' },
    { title: 'Book Title', date: '2025-05-28', views: '3,125' },
    { title: 'Book Title', date: '2025-05-28', views: '3,125' },
  ];
>>>>>>> d1fd65fccedd7c98c59bf41d5d765454a928eee0

const theme = createTheme({
  typography: {
    fontFamily: 'Pretendard, sans-serif',
  },
  palette: {
    primary: { main: '#0d47a1' },
    secondary: { main: '#FFD700' },
  },
});

function BookCard({ book, bestseller = false }) {
  return (
<<<<<<< HEAD
    <Card
      component={Link} // ✅ 카드 자체를 링크로
      to={`/book/${book.id}`}
      sx={{
        width: 200,
        borderRadius: 3,
        position: 'relative',
        textDecoration: 'none',
        color: 'inherit',
        border: bestseller ? '4px solid #FFD700' : 'none',
        boxShadow: bestseller
          ? '0 4px 12px rgba(255,215,0,0.4)'
          : '0 2px 8px rgba(0,0,0,0.08)',
        transition: 'all 0.2s',
        '&:hover': {
          transform: 'translateY(-4px)',
          boxShadow: '0 6px 16px rgba(0,0,0,0.2)',
        },
      }}
    >
      {bestseller && (
        <Chip
          label='👑 BEST SELLER 👑'
          size='small'
          sx={{
            position: 'absolute',
            top: 8,
            left: 8,
            bgcolor: '#FFD700',
            fontWeight: 700,
=======
    <div style={{ fontFamily: 'sans-serif', padding: '20px' }}>

      {/* 네비게이션 */}
      <nav style={{
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        padding: '10px 20px',
        borderBottom: '1px solid #ddd'
      }}>
        <div><strong>📘 작가의 산책</strong></div>
        <div>
          <a href="book/write" style={{ margin: '0 10px' }}>도서 등록</a>
        </div>
        <div>
          <button>로그인</button>
          <button style={{ marginLeft: '10px' }}>회원가입</button>
        </div>
      </nav>

      {/* 제목 영역 */}
      <section style={{ textAlign: 'center', margin: '50px 0' }}>
        <h1 style={{ fontSize: '2rem', fontWeight: 'bold' }}>작가의 산책</h1>
        <p>국내 최대 독서 플랫폼, "걷다가 서재" 입니다.</p>
      </section>

      {/* 검색창 */}
      <div style={{ display: 'flex', justifyContent: 'center', marginBottom: '40px' }}>
        <input
          type="text"
          placeholder="검색어를 입력해주세요."
          style={{
            padding: '12px 16px',
            width: '300px',
            borderRadius: '20px 0 0 20px',
            border: '1px solid #ccc'
>>>>>>> d1fd65fccedd7c98c59bf41d5d765454a928eee0
          }}
        />
      )}
      <CardMedia
        component='div'
        sx={{
          height: 240,
          bgcolor: '#9e9e9e',
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center',
          color: '#fff',
          fontSize: 32,
          fontWeight: 700,
        }}
      >
        TEST
      </CardMedia>
      <CardContent sx={{ p: 2 }}>
        <Typography variant='subtitle1' sx={{ fontWeight: 700 }}>
          {book.title}
        </Typography>
        <Typography
          variant='caption'
          color='text.secondary'
          display='block'
          gutterBottom
        >
          {book.date}
        </Typography>
        <Typography variant='caption' color='text.secondary'>
          조회수: {book.views.toLocaleString()}
        </Typography>
      </CardContent>
    </Card>
  );
}

export default function Home() {
  return (
    <ThemeProvider theme={theme}>
      <Box sx={{ bgcolor: '#e9f1ff', minHeight: '100vh' }}>
        <AppBar position='static' color='transparent' elevation={0}>
          <Toolbar sx={{ justifyContent: 'space-between' }}>
            <Stack direction='row' alignItems='center' spacing={1}>
              <MenuBookIcon sx={{ fontSize: 32, color: 'primary.main' }} />

            </Stack>
            <Stack direction='row' spacing={4}>
              <Button color='primary'>도서 등록</Button>
            </Stack>
            <Stack direction='row' spacing={2}>
              <Button variant='contained' color='primary'>
                로그인
              </Button>
              <Button variant='outlined' color='primary'>
                회원가입
              </Button>
            </Stack>
          </Toolbar>
        </AppBar>

        <Container maxWidth='md' sx={{ py: 8, textAlign: 'center' }}>
          <Typography variant='h3' fontWeight={700} gutterBottom>
            작가의 산책
          </Typography>
          <Typography variant='h6' color='text.secondary' gutterBottom>
            국내 최대 독서 플랫폼, “걷다가 서재” 입니다.
          </Typography>

          <TextField
            fullWidth
            placeholder='검색어를 입력해주세요.'
            sx={{
              bgcolor: '#fff',
              borderRadius: 5,
              mt: 4,
              maxWidth: 600,
              mx: 'auto',
            }}
            InputProps={{
              endAdornment: (
                <InputAdornment position='end'>
                  <IconButton edge='end'>
                    <SearchIcon />
                  </IconButton>
                </InputAdornment>
              ),
            }}
          />
        </Container>

        <Container maxWidth='lg' sx={{ pb: 8 }}>
          <Stack direction='row' spacing={4} justifyContent='center'>
            {sampleBooks.map((book, idx) => (
              <BookCard key={book.id} book={book} bestseller={idx === 0} />
            ))}
          </Stack>
        </Container>
      </Box>
    </ThemeProvider>
  );
}
