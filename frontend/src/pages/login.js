import React from 'react';
import {
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  TextField,
  Button,
} from '@mui/material';

export default function Login({ open, onClose, form, setForm, onSubmit }) {
  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  return (
    <Dialog open={open} onClose={onClose} maxWidth='xs' fullWidth>
      <DialogTitle sx={{ fontWeight: 700, textAlign: 'center' }}>로그인</DialogTitle>
      <DialogContent sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
        <TextField
          label='이메일'
          name='email'
          value={form.email}
          onChange={handleChange}
          fullWidth
        />
        <TextField
          label='비밀번호'
          type='password'
          name='password'
          value={form.password}
          onChange={handleChange}
          fullWidth
        />
      </DialogContent>
      <DialogActions sx={{ justifyContent: 'center', pb: 2 }}>
        <Button variant='contained' fullWidth onClick={onSubmit}>
          로그인
        </Button>
      </DialogActions>
    </Dialog>
  );
}