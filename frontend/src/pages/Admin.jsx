import HomeButton from '../components/HomeButton';
import AuthorCard from '../components/Admin/AuthorCard';
import '../components/Admin/Admin.css';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../components/Admin/Admin.css';

//테스트용 
// export default function Admin() {
//   const [authors, setAuthors] = useState([
//     {
//       id: 1,
//       name: '홍길동',
//       bio: '자유로운 작가입니다.',
//       portfolio: 'https://hong.com',
//     },
//     {
//       id: 2,
//       name: '이몽룡',
//       bio: '소설을 씁니다.',
//       portfolio: 'https://lee.com',
//     },
//     {
//       id: 3,
//       name: '성춘향',
//       bio: '에세이스트입니다.',
//       portfolio: 'https://sung.com',
//     },
//     {
//       id: 4,
//       name: '임꺽정',
//       bio: '자연을 사랑하는 작가.',
//       portfolio: 'https://lim.com',
//     },
//   ]);

//   const handleStatusChange = () => {
//     alert("작가 상태가 변경되었습니다 (테스트용)");
//     // setAuthors(...) 로 변경도 가능
//   };

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
//             onStatusChange={handleStatusChange}
//           />
//         ))}
//       </div>
//     </div>
//   );
// }
// -------테스트 후 이 코드로 변경
export default function Admin() {
  const [authors, setAuthors] = useState([]);

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
      <div className="admin-header">
        <div className="logo-title">
          <img src="/logo.png" alt="logo" className="logo" />
          <h1>관리자 페이지</h1>
        </div>
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