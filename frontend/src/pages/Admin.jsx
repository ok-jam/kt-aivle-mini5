
import AuthorCard from '../components/Admin/AuthorCard';
import '../components/Admin/Admin.css';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import MenuBookIcon from '@mui/icons-material/MenuBook';
import { useNavigate } from 'react-router-dom';

export default function Admin() {
  const [authors, setAuthors] = useState([]);
  const navigate = useNavigate();

  const fetchAuthors = async () => {
    try {
      const response = await axios.get('/authors');
      setAuthors(response.data);
    } catch (error) {
      console.error('작가 목록 가져오기 실패', error);
    }
  };

  useEffect(() => {
    fetchAuthors();
  }, []);

  return (
    <div className="admin-container">
      {/* 🔵 상단 로고 영역 */}
      <div
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
          style={{
            display: 'flex',
            alignItems: 'center',
            padding: '0 40px',
            maxWidth: '1200px',
            margin: '0 auto',
            cursor: 'pointer',
          }}
          onClick={() => navigate('/')}
        >
          <MenuBookIcon fontSize="large" style={{ color: '#1976d2', marginRight: '10px' }} />
          <span
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
      </div>

      {/* 🔵 관리자 메인 콘텐츠 */}
      <div className="admin-header">
        <h1>관리자 페이지</h1>
        <button className="btn logout">로그아웃</button>
      </div>

      <div className="author-list">
        {authors.map((author) => (
          <AuthorCard
            key={author.id}
            {...author}
            onStatusChange={fetchAuthors}
          />
        ))}
      </div>
    </div>
  );
}
// export default function Admin() {
//   const navigate = useNavigate();

//   return (
//     <div
//       style={{
//         padding: '16px 0',
//         backgroundColor: '#ffffff',
//         boxShadow: '0 2px 8px rgba(0,0,0,0.05)',
//         position: 'sticky',
//         top: 0,
//         zIndex: 1000,
//       }}
//     >
//       <div
//         style={{
//           display: 'flex',
//           alignItems: 'center',
//           padding: '0 40px',
//           maxWidth: '1200px',
//           margin: '0 auto',
//           cursor: 'pointer',
//         }}
//         onClick={() => navigate('/')}
//       >
//         <MenuBookIcon fontSize="large" style={{ color: '#1976d2', marginRight: '10px' }} />
//         <span
//           style={{
//             fontWeight: 800,
//             fontSize: '22px',
//             color: '#1976d2',
//             letterSpacing: '0.5px',
//           }}
//         >
//           BookAdmin
//         </span>
//       </div>
//     </div>
//   );
// }

// export default function Admin() {
//   const [authors, setAuthors] = useState([]);

//   const fetchAuthors = async () => {
//     try {
//       const response = await axios.get('/authors');
//       setAuthors(response.data);
//     } catch (error) {
//       console.error('작가 목록 가져오기 실패', error);
//     }
//   };

//   useEffect(() => {
//     fetchAuthors();
//   }, []);

//   return (
//     <div className="admin-container">
//       <div className="admin-header">
//         <div className="logo-title">
//           <img src="/logo.png" alt="logo" className="logo" />
//           <h1>관리자 페이지</h1>
//         </div>
//         <button className="btn logout">로그아웃</button>
//       </div>

//       <div className="author-list">
//         {authors.map((author) => (
//           <AuthorCard
//             key={author.id}
//             {...author}
//             onStatusChange={fetchAuthors}
//           />
//         ))}
//       </div>
//     </div>
//   );
// }