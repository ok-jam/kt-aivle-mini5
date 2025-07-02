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
import Login from './login';
import Register from './register';
import { useState } from 'react';

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
  const [loginOpen, setLoginOpen] = useState(false);
  const [registerOpen, setRegisterOpen] = useState(false);

  const handleLoginSubmit = (formData) => {
    console.log('로그인 정보:', formData);
    setLoginOpen(false);
  };

  const handleRegisterSubmit = (formData) => {
    console.log('회원가입 정보:', formData);
    setRegisterOpen(false);
  };

  const switchToLogin = () => {
    setRegisterOpen(false);
    setLoginOpen(true);
  };

  const switchToRegister = () => {
    setLoginOpen(false);
    setRegisterOpen(true);
  };

  return (
    <ThemeProvider theme={theme}>
      <Box sx={{ bgcolor: '#e9f1ff', minHeight: '100vh' }}>
        <AppBar position="static" color="transparent" elevation={0}>
          <Toolbar sx={{ justifyContent: 'space-between' }}>
            <Stack direction="row" alignItems="center" spacing={1}>
              <MenuBookIcon sx={{ fontSize: 32, color: 'primary.main' }} />
            </Stack>
            <Stack direction="row" spacing={4}>
              <Button color="primary">도서 등록</Button>
            </Stack>
            <Stack direction="row" spacing={2}>
              <Button
                variant="contained"
                color="primary"
                onClick={() => setLoginOpen(true)}
              >
                로그인
              </Button>
              <Button
                variant="outlined"
                color="primary"
                onClick={() => setRegisterOpen(true)}
              >
                회원가입
              </Button>
            </Stack>
            {/* 로그인 다이얼로그 */}
            <Login
              open={loginOpen}
              onClose={() => setLoginOpen(false)}
              onSubmit={handleLoginSubmit}
            />
            {/* 회원가입 다이얼로그 */}
            <Register
              open={registerOpen}
              onClose={() => setRegisterOpen(false)}
              onSubmit={handleRegisterSubmit}
              switchToLogin={switchToLogin}
            />
          </Toolbar>
        </AppBar>

        <Container maxWidth="md" sx={{ py: 8, textAlign: 'center' }}>
          <Typography variant="h3" fontWeight={700} gutterBottom>
            작가의 산책
          </Typography>
          <Typography variant="h6" color="text.secondary" gutterBottom>
            국내 최대 독서 플랫폼, “걷다가 서재” 입니다.
          </Typography>

          <TextField
            fullWidth
            placeholder="검색어를 입력해주세요."
            sx={{
              bgcolor: '#fff',
              borderRadius: 5,
              mt: 4,
              maxWidth: 600,
              mx: 'auto',
            }}
            InputProps={{
              endAdornment: (
                <InputAdornment position="end">
                  <IconButton edge="end">
                    <SearchIcon />
                  </IconButton>
                </InputAdornment>
              ),
            }}
          />
        </Container>

        <Container maxWidth="lg" sx={{ pb: 8 }}>
          <Stack direction="row" spacing={4} justifyContent="center">
            {sampleBooks.map((book, idx) => (
              <BookCard key={book.id} book={book} bestseller={idx === 0} />
            ))}
          </Stack>
        </Container>
      </Box>
    </ThemeProvider>
  );
}