// src/pages/AuthorPage.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import AuthorInfoCard from '../components/AuthorPage/AuthorlnfoCard';
import BookTable from '../components/AuthorPage/BookTable';

//테스트용 
const dummyAuthor = {
  name: 'sosschs9',
  email: 'sosschs9@aivle.com',
  password: 'asdf1234',
};

const dummyBooks = {
  published: [
    { id: 1, title: '출간 도서 1', publishedAt: '2025-06-30' },
    { id: 2, title: '출간 도서 2', publishedAt: '2025-06-28' },
  ],
  drafts: [
    { id: 3, title: '임시 도서 1' },
    { id: 4, title: '임시 도서 2' },
  ],
};

function AuthorPage() {
  return (
    <div style={{ display: 'flex', padding: '2rem' }}>
      {/* 왼쪽: 작가 정보 */}
      <div style={{ flex: '1', paddingRight: '2rem' }}>
        <AuthorInfoCard author={dummyAuthor} />
      </div>

      {/* 오른쪽: 도서 목록 */}
      <div style={{ flex: '3' }}>
        <BookTable title="등록한 도서 목록" books={dummyBooks.published} type="published" />
        <BookTable title="임시저장한 도서 목록" books={dummyBooks.drafts} type="draft" />
      </div>
    </div>
  );
}

export default AuthorPage;
