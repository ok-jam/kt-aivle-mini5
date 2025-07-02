import React from 'react';
import axios from 'axios';
import './Admin.css'; 


// const AuthorCard = ({ name, bio, portfolio }) => {
//   return (
//     <div className="card">
//       <div className="card-info">
//         <p><strong>작가 이름 :</strong> {name}</p>
//         <p><strong>작가 소개 :</strong> {bio}</p>
//         <p><strong>포트폴리오 :</strong> <a href={portfolio}>{portfolio}</a></p>
//       </div>
//       <div className="card-buttons">
//         <button className="btn">승인</button>
//         <button className="btn">반려</button>
//       </div>
//     </div>
//   );
// };

// export default AuthorCard;

export default function AuthorCard({ id, name, bio, portfolioUrl, onStatusChange }) {
  const handleApprove = async () => {
    try {
      await axios.put(`/authors/${id}/approve`);
      onStatusChange(); // 상태 갱신
    } catch (error) {
      console.error('승인 실패', error);
    }
  };

  const handleReject = async () => {
    try {
      await axios.put(`/authors/${id}/reject`);
      onStatusChange();
    } catch (error) {
      console.error('반려 실패', error);
    }
  };

  return (
    <div className="card">
      <div className="card-info">
        <p><strong>작가 이름 :</strong> {name}</p>
        <p><strong>작가 소개 :</strong> {bio}</p>
        <p><strong>포트폴리오 :</strong> <a href={portfolioUrl}>{portfolioUrl}</a></p>
      </div>
      <div className="card-buttons">
        <button className="btn" onClick={handleApprove}>승인</button>
        <button className="btn" onClick={handleReject}>반려</button>
      </div>
    </div>
  );
}