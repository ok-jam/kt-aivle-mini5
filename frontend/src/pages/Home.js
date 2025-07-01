import { Link } from 'react-router-dom';

export default function Home() {
  const linkStyle = {
    display: 'inline-block',
    margin: '20px',
    padding: '20px',
    border: '2px solid #ccc',
    borderRadius: '12px',
    textAlign: 'center',
    width: '120px',
    textDecoration: 'none',
    color: '#333',
    fontWeight: 'bold',
    backgroundColor: '#f0f0f0'
  };

  const containerStyle = {
    display: 'flex',
    flexWrap: 'wrap',
    justifyContent: 'center',
    alignItems: 'center',
    minHeight: '100vh',
    backgroundColor: '#fafafa'
  };

  return (
    <div style={containerStyle}>
      <Link to="/authors" style={linkStyle}>👥 작가 목록</Link>
      <Link to="/author/register" style={linkStyle}>✍ 작가 등록</Link>
      <Link to="/mypage" style={linkStyle}>✍ 마이 페이지</Link>
      <Link to="/books" style={linkStyle}>📚 도서 목록</Link>
      <Link to="/book/write" style={linkStyle}>📝 책 작성</Link>
      <Link to="/subscribe" style={linkStyle}>💳 구독자</Link>
      <Link to="/admin" style={linkStyle}>🛠 관리자</Link>
    </div>
  );
}
