// src/components/BookDetail/SubscribeButton.jsx
import React, { useState } from 'react';
import axios from 'axios';

function SubscribeButton({ subscriberId, onSubscribed }) {
  const [isSubscribed, setIsSubscribed] = useState(false);
  const [loading, setLoading] = useState(false);

  const handleSubscribe = async () => {
    if (isSubscribed) {
      onSubscribed(); // 열람하기 눌렀을 때 도서 내용 보여주기
      return;
    }

    setLoading(true);
    try {
      const res = await axios.post(`/subscribers/${subscriberId}/purchase-monthly`);
      if (res.data.subscriptionType === 'Yes') {
        setIsSubscribed(true);
        onSubscribed(); // 열람 가능 상태 전달
      }
    } catch (err) {
      alert('구독에 실패했습니다.');
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <button
      onClick={handleSubscribe}
      disabled={loading}
      style={{
        backgroundColor: isSubscribed ? '#007bff' : '#222',
        color: '#fff',
        padding: '0.5rem 1rem',
        borderRadius: '5px',
        margin: '1rem 0',
        cursor: 'pointer'
      }}
    >
      {loading
        ? '처리 중...'
        : isSubscribed
        ? '열람하기'
        : '구독하기 (1000P)'}
    </button>
  );
}

export default SubscribeButton;
