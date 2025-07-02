import React from 'react';
import {
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  TextField,
  Button,
  RadioGroup,
  FormControlLabel,
  Radio,
  FormLabel,
  Stack,
} from '@mui/material';

export default function Register({ open, onClose, form, setForm, onSubmit, switchToLogin }) {
  // 📌 form = { email: '', password: '', telco: 'KT' }

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  return (
    <Dialog open={open} onClose={onClose} maxWidth='xs' fullWidth>
      <DialogTitle sx={{ fontWeight: 700, textAlign: 'center' }}>회원가입</DialogTitle>

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

        <Stack sx={{ mt: 1 }}>
          <FormLabel component='legend' sx={{ fontSize: 14, mb: 1 }}>
            통신사
          </FormLabel>
          <RadioGroup
            row
            name='telco'
            value={form.telco}
            onChange={handleChange}
          >
            <FormControlLabel value='KT' control={<Radio size='small' />} label='KT' />
            <FormControlLabel value='SKT' control={<Radio size='small' />} label='SKT' />
            <FormControlLabel value='LGU+' control={<Radio size='small' />} label='LG U+' />
          </RadioGroup>
        </Stack>
      </DialogContent>

      <DialogActions sx={{ flexDirection: 'column', gap: 1, pb: 2, px: 3 }}>
        <Button variant='contained' fullWidth onClick={onSubmit}>
          회원가입
        </Button>
        {switchToLogin && (
          <Button size='small' onClick={switchToLogin} sx={{ alignSelf: 'flex-end' }}>
            로그인
          </Button>
        )}
      </DialogActions>
    </Dialog>
  );
}