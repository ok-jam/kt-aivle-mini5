// src/components/AuthorPage/BookTable.jsx
import React from 'react';
import BookRow from './BookRow';

function BookTable({ title, books, type }) {
  return (
    <div style={{ marginBottom: '2rem' }}>
      <h3>{title}</h3>
      {books.length === 0 ? (
        <p style={{ color: '#777' }}>도서가 없습니다.</p>
      ) : (
        <table style={{ width: '100%', borderCollapse: 'collapse' }}>
          <thead>
            <tr>
              <th style={{ textAlign: 'left', padding: '0.5rem', borderBottom: '1px solid #ddd' }}>제목</th>
              {type === 'published' && (
                <th style={{ textAlign: 'left', padding: '0.5rem', borderBottom: '1px solid #ddd' }}>출간일</th>
              )}
              <th style={{ textAlign: 'left', padding: '0.5rem', borderBottom: '1px solid #ddd' }}>동작</th>
            </tr>
          </thead>
          <tbody>
            {books.map((book) => (
              <BookRow key={book.id} book={book} type={type} />
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default BookTable;
