// src/components/AuthorPage/BookRow.jsx
import React from 'react';
import { useNavigate } from 'react-router-dom';

function BookRow({ book, type }) {
  const navigate = useNavigate();

  const handleView = () => {
    navigate(`/books/${book.id}`);
  };

  const handleWrite = () => {
    navigate('/bookWrite');
  };

  const handleDelete = () => {
    if (window.confirm('정말 삭제하시겠습니까?')) {
      // DELETE API 호출 예정
      alert(`도서 ID ${book.id} 삭제됨 (API 연결 필요)`);
    }
  };

  return (
    <tr>
      <td style={{ padding: '0.5rem' }}>{book.title}</td>
      {type === 'published' && (
        <td style={{ padding: '0.5rem' }}>{book.publishedAt || '-'}</td>
      )}
      <td style={{ padding: '0.5rem' }}>
        {type === 'published' ? (
          <>
            <button onClick={handleView} style={buttonStyle}>상세 보기</button>
            <button onClick={handleDelete} style={buttonStyle}>삭제</button>
          </>
        ) : (
          <>
            <button onClick={handleWrite} style={buttonStyle}>작성</button>
            <button onClick={handleDelete} style={buttonStyle}>삭제</button>
          </>
        )}
      </td>
    </tr>
  );
}

const buttonStyle = {
  marginRight: '0.5rem',
  padding: '0.3rem 0.7rem',
  border: '1px solid #aaa',
  borderRadius: '4px',
  backgroundColor: '#f8f8f8',
  cursor: 'pointer'
};

export default BookRow;