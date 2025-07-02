import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const styles = {
  pageBackground: {
    backgroundColor: '#EEF6FF',
    minHeight: '100vh',
    padding: '40px',
    fontFamily: 'Arial, sans-serif',
  },
  pageTitle: {
    fontSize: '24px',
    fontWeight: 'bold',
    color: '#1F3C88',
    marginBottom: '16px',
  },
  separator: {
    height: '1px',
    backgroundColor: '#D1D5DB',
    margin: '16px 0',
  },
  contentGrid: {
    display: 'grid',
    gridTemplateColumns: '1fr 3fr',
    gap: '24px',
    alignItems: 'start', 
  },
    authorBox: {
      backgroundColor: '#fff',
      padding: '16px',
      borderRadius: '12px',
      boxShadow: '0 0 8px rgba(0,0,0,0.05)',
      width: '100%',
      maxWidth: '300px',   // ❗ 작게 제한
      marginTop: '8px',
    },
  sectionTitle: {
    fontSize: '18px',
    fontWeight: 'bold',
    marginBottom: '12px',
    color: '#111827',
  },
  button: {
    backgroundColor: '#3566A2',
    color: '#fff',
    padding: '8px 16px',
    border: 'none',
    borderRadius: '8px',
    cursor: 'pointer',
    marginLeft: '8px',
  },
  table: {
    width: '100%',
    backgroundColor: '#fff',
    borderCollapse: 'collapse',
    borderRadius: '12px',
    overflow: 'hidden',
  },
  td: {
    padding: '12px',
    borderBottom: '1px solid #eee',
  },
};

export default function AuthorPage() {
  const navigate = useNavigate();

  const author = {
    email: 'sosschs9@aivle.com',
    password: 'asdf1234',
  };

  const publishedBooks = [
    { id: 1, title: '출간 도서 1', date: '2025-06-30' },
    { id: 2, title: '출간 도서 2', date: '2025-06-28' },
  ];

  const drafts = [
    { id: 3, title: '임시 도서 1' },
    { id: 4, title: '임시 도서 2' },
  ];

  const handleDelete = (bookId) => {
    const confirmed = window.confirm('정말 삭제하시겠습니까?');
    if (confirmed) {
      console.log(`${bookId}번 도서 삭제 요청`);
    }
  };

  return (
    <div style={styles.pageBackground}>
      <h1 style={styles.pageTitle}>작가페이지</h1>
      <div style={styles.separator} />

      <div style={styles.contentGrid}>
        {/* 왼쪽 작가 정보 */}
        <div style={styles.authorBox}>
          <h2 style={styles.sectionTitle}>작가정</h2>
          <p><strong>비밀번호:</strong> {author.password}</p>
          <p><strong>이메일:</strong> {author.email}</p>
          <button style={styles.button}>작가 삭제</button>
        </div>

        {/* 오른쪽 도서 목록 */}
        <div>
          <h2 style={styles.sectionTitle}>등록한 도서 목록</h2>
          <table style={styles.table}>
            <thead>
              <tr>
                <th style={styles.th}>제목</th>
                <th style={styles.th}>출간일</th>
              </tr>
            </thead>
            <tbody>
              {publishedBooks.map((book) => (
                <tr key={book.id}>
                  <td style={styles.td}>{book.title}</td>
                  <td style={styles.td}>{book.date}</td>
                  <td style={styles.td}>
                    <button style={styles.button} onClick={() => navigate(`/book/${book.id}`)}>상세 보기</button>
                    <button style={styles.button} onClick={() => handleDelete(book.id)}>삭제</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>

          <h2 style={{ ...styles.sectionTitle, marginTop: '32px' }}>임시저장한 도서 목록</h2>
          <table style={styles.table}>
            <thead>
              <tr>
                <th>제목</th>
              </tr>
            </thead>
            <tbody>
              {drafts.map((draft) => (
                <tr key={draft.id}>
                  <td style={styles.td}>{draft.title}</td>
                  <td style={styles.td}>
                    <button style={styles.button} onClick={() => navigate(`/book/edit/${draft.id}`)}>작성</button>
                    <button style={styles.button} onClick={() => handleDelete(draft.id)}>삭제</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

