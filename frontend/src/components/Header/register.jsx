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

export default function Register({ open, onClose }) {
  const navigate = useNavigate();
  const [form, setForm] = useState({
    id: '',
    password: '',
    confirm: '',
    name: '',
    email: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async () => {
    const { id, password, confirm, name, email } = form;

    if (!id || !password || !name || !email) {
      alert('아이디, 비밀번호, 이름, 이메일은 모두 필수입니다.');
      return;
    }

    if (password !== confirm) {
      alert('비밀번호가 일치하지 않습니다.');
      return;
    }

    try {
      const response = await api.post('/users/signIn', { id, password, name, email });
      console.log('서버 응답:', response.data);
      alert('회원가입 성공!');
      onClose();
      navigate('/');
    } catch (error) {
      console.error('회원가입 실패:', error);
      alert('오류가 발생했습니다.');
    }
  };

  return (
    <Dialog open={open} onClose={onClose} maxWidth="xs" fullWidth>
      <DialogTitle sx={{ fontWeight: 700, textAlign: 'center' }}>회원가입</DialogTitle>

      <DialogContent sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
        <TextField
          label="이름"
          name="name"
          value={form.name}
          onChange={handleChange}
          fullWidth
          autoFocus
        />
        <TextField
          label="이메일"
          name="email"
          type="email"
          value={form.email}
          onChange={handleChange}
          fullWidth
        />
        <TextField
          label="아이디"
          name="id"
          value={form.id}
          onChange={handleChange}
          fullWidth
        />
        <TextField
          label="비밀번호"
          name="password"
          type="password"
          value={form.password}
          onChange={handleChange}
          fullWidth
        />
        <TextField
          label="비밀번호 확인"
          name="confirm"
          type="password"
          value={form.confirm}
          onChange={handleChange}
          fullWidth
        />
      </DialogContent>

      <DialogActions sx={{ justifyContent: 'center', pb: 2 }}>
        <Button variant="contained" fullWidth onClick={handleSubmit}>
          회원가입
        </Button>
      </DialogActions>
    </Dialog>
  );
}