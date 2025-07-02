import React, { useState } from 'react';
import {
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  TextField,
  Button,
} from '@mui/material';
import { useNavigate } from 'react-router-dom';
import api from '../../api';

export default function Login({ open, onClose }) {
  const navigate = useNavigate();
  const [form, setForm] = useState({ email: '', password: '' });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async () => {
    const { email, password } = form;
    if ( !password || !email) {
      alert('이메일, 이름, 비밀번호 모두 필수입니다.');
      return;
    }

    try {
      const response = await api.post('/subscriber', { email, password });
      console.log('서버 응답:', response.data);
      localStorage.setItem('userId', email);
      alert('로그인 성공!');
      onClose(); // 모달 닫기
      navigate('/');
    } catch (error) {
      console.error('로그인 실패:', error);
      alert('오류가 발생했습니다.');
    }
  };

  return (
    <Dialog open={open} onClose={onClose} maxWidth="xs" fullWidth>
      <DialogTitle sx={{ fontWeight: 700, textAlign: 'center' }}>로그인</DialogTitle>

      <DialogContent sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
        <TextField
          label="이메일"
          name="email"
          value={form.email}
          onChange={handleChange}
          fullWidth
          autoFocus
        />
        <TextField
          label="비밀번호"
          type="password"
          name="password"
          value={form.password}
          onChange={handleChange}
          fullWidth
        />
      </DialogContent>

      <DialogActions sx={{ justifyContent: 'center', pb: 2 }}>
        <Button variant="contained" fullWidth onClick={handleSubmit}>
          로그인
        </Button>
      </DialogActions>
    </Dialog>
  );
}