import { Link } from 'react-router-dom';

const homeButtonStyle = {
  position: 'fixed',
  top: '20px',
  left: '20px',
  fontSize: '24px',
  textDecoration: 'none',
  backgroundColor: '#fff',
  padding: '6px 12px',
  borderRadius: '8px',
  border: '1px solid #ddd',
  boxShadow: '0 1px 4px rgba(0,0,0,0.1)',
  zIndex: 1000,
};

export default function HomeButton() {
  return (
    <Link to="/" style={homeButtonStyle}>
      🏠
    </Link>
  );
}
