import { Link } from 'react-router-dom';

const homeButtonStyle = {
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
  width: '40px',            // 정사각형 사이즈
  height: '40px',
  fontSize: '24px',
  textDecoration: 'none',
  backgroundColor: '#fff',
  borderRadius: '8px',
  border: '1px solid #ddd',
  boxShadow: '0 1px 4px rgba(0,0,0,0.1)',
  marginRight: '20px',      // 헤더 내 오른쪽 여백
};

export default function HomeButton() {
  return (
    <Link to="/" style={homeButtonStyle}>
      📘
    </Link>
  );
}