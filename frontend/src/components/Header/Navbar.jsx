import MenuBookIcon from '@mui/icons-material/MenuBook';
import LoginIcon from '@mui/icons-material/Login';
import PersonAddAltIcon from '@mui/icons-material/PersonAddAlt';
import { getCurrentUser, logoutUser } from '../../router/Authutil';
import { useNavigate } from 'react-router-dom';
import { useState } from 'react';
import Register from './register'; // ✅ 우리가 만든 버전으로 사용
import Login from './login';      // ✅ 우리가 만든 버전으로 사용

export default function Navbar() {
  const navigate = useNavigate();
  const user = getCurrentUser();

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
    setRegisterOpen(true);
    setLoginOpen(false);
  }

  const handleLogout = () => {
    logoutUser();
    navigate('/');
  };

  return (
    <div
  className="header"
  style={{
    padding: '16px 0',
    backgroundColor: '#ffffff',
    boxShadow: '0 2px 8px rgba(0,0,0,0.05)',
    position: 'sticky',
    top: 0,
    zIndex: 1000,
  }}
>
  <div
    className="headerchild"
    style={{
      display: 'flex',
      justifyContent: 'space-between',
      alignItems: 'center',
      padding: '0 40px',
      maxWidth: '1200px',
      margin: '0 auto',
    }}
  >
    {/* 로고 */}
    <div
      className="logo-title"
      onClick={() => navigate('/')}
      style={{
        display: 'flex',
        alignItems: 'center',
        cursor: 'pointer',
      }}
    >
      <MenuBookIcon fontSize="large" style={{ color: '#1976d2', marginRight: '10px' }} />
      <span
        className="logo-text"
        style={{
          fontWeight: 800,
          fontSize: '22px',
          color: '#1976d2',
          letterSpacing: '0.5px',
        }}
      >
        BookAdmin
      </span>
    </div>

    {/* 네비게이션 (로그인 유저만) */}
    {user && (
      <nav
        style={{
          display: 'flex',
          gap: '40px',
          alignItems: 'center',
        }}
      >
        <a
          href="/books/register"
          style={{
            textDecoration: 'none',
            color: '#333',
            fontWeight: 500,
            transition: 'color 0.2s',
          }}
          onMouseEnter={(e) => (e.target.style.color = '#1976d2')}
          onMouseLeave={(e) => (e.target.style.color = '#333')}
        >
          도서 등록
        </a>
        <a
          href="/mypage"
          style={{
            textDecoration: 'none',
            color: '#333',
            fontWeight: 500,
            transition: 'color 0.2s',
          }}
          onMouseEnter={(e) => (e.target.style.color = '#1976d2')}
          onMouseLeave={(e) => (e.target.style.color = '#333')}
        >
          마이페이지
        </a>
      </nav>
    )}

    {/* 인증 버튼들 */}
    <div className="auth-buttons" style={{ display: 'flex', gap: '12px' }}>
      {user ? (
        <button
          onClick={handleLogout}
          style={{
            backgroundColor: '#1976d2',
            color: '#fff',
            border: 'none',
            padding: '10px 18px',
            borderRadius: '8px',
            display: 'flex',
            alignItems: 'center',
            gap: '6px',
            fontSize: '15px',
            fontWeight: 600,
            cursor: 'pointer',
          }}
        >
          <LoginIcon /> 로그아웃
        </button>
      ) : (
        <>
          <button
            onClick={() => setLoginOpen(true)}
            style={{
              backgroundColor: '#1976d2',
              color: '#fff',
              border: 'none',
              padding: '10px 18px',
              borderRadius: '8px',
              display: 'flex',
              alignItems: 'center',
              gap: '6px',
              fontSize: '15px',
              fontWeight: 600,
              cursor: 'pointer',
            }}
          >
            <LoginIcon /> 로그인
          </button>
          <button
            onClick={() => setRegisterOpen(true)}
            style={{
              backgroundColor: '#fff',
              color: '#1976d2',
              border: '2px solid #1976d2',
              padding: '10px 18px',
              borderRadius: '8px',
              display: 'flex',
              alignItems: 'center',
              gap: '6px',
              fontSize: '15px',
              fontWeight: 600,
              cursor: 'pointer',
            }}
          >
            <PersonAddAltIcon /> 회원가입
          </button>
        </>
      )}
    </div>

    {/* 로그인 모달 */}
    <Login
      open={loginOpen}
      onClose={() => setLoginOpen(false)}
      onSubmit={handleLoginSubmit}
      switchToRegister={switchToRegister}
    />

    {/* 회원가입 모달 */}
    <Register
      open={registerOpen}
      onClose={() => setRegisterOpen(false)}
      onSubmit={handleRegisterSubmit}
      switchToLogin={switchToLogin}
    />
  </div>
</div>
  );
}