// src/components/BookDetail/CoverImage.jsx
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function CoverImage({ writingId }) {
  const [imageUrl, setImageUrl] = useState(null);

  useEffect(() => {
    const fetchAIImage = async () => {
      try {
        const res = await axios.get('/ai/all');
        const matched = res.data.find(
          item => item.writingId === writingId && item.taskType === '표지 생성'
        );
        if (matched) setImageUrl(matched.resultImage);
      } catch (err) {
        console.error('AI 이미지 불러오기 실패:', err);
      }
    };

    fetchAIImage();
  }, [writingId]);

  return (
    <div style={{ width: '200px', height: '300px', border: '1px solid #ccc' }}>
      {imageUrl ? (
        <img src={imageUrl} alt="표지 이미지" style={{ width: '100%', height: '100%', objectFit: 'cover' }} />
      ) : (
        <p>AI 생성 표지 없음</p>
      )}
    </div>
  );
}

export default CoverImage;
