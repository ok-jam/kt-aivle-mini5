import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function BookWrite() {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const [category, setCategory] = useState('');
  const navigate = useNavigate();

  const categories = ['소설', '시 / 에세이', '역사/문화', '기술/공학', '자기계발', '인문', '종교', '외국어'];

  const handleImageGenerate = async () => {
    try {
      const response = await axios.post('/ai/create', { title, content });
      alert('표지 이미지 생성 요청 완료!');
    } catch (error) {
      alert('표지 이미지 생성 실패!');
      console.error(error);
    }
  };

  const handleTempSave = async () => {
    try {
      await axios.post('/api/book/temp', { title, content, category });
      alert('임시저장 완료!');
    } catch (error) {
      alert('임시저장 실패!');
    }
  };

  const handleSubmit = async () => {
    try {
      await axios.post('/api/book/complete', { title, content, category });
      const confirmed = window.confirm('도서 등록이 완료되었습니다. 홈으로 이동할까요?');
      if (confirmed) navigate('/');
    } catch (error) {
      alert('도서 등록 실패!');
    }
  };

  return (
    <div style={{ backgroundColor: '#EEF6FF', minHeight: '100vh' }}>
      {/* 상단 네비게이션 바 */}
      <nav style={{
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        padding: '10px 20px',
        borderBottom: '1px solid #ccc',
        backgroundColor: '#ffffff'
      }}>

      </nav>

      {/* 도서 등록 폼 */}
      <div style={{ maxWidth: '1000px', margin: '40px auto', padding: '40px' }}>
        <h2 style={{ fontSize: '28px', marginBottom: '4px', fontWeight: 'bold' }}>신규 도서 등록</h2>
        <p style={{ marginBottom: '24px' }}>신규 도서를 등록할 수 있습니다.</p>
        <div style={{
        borderTop: '2px solid #D1D5DB', // 선 두께 & 색상
        margin: '1rem 0',            // 위아래 여백
        }}></div>
        <div style={{ display: 'flex', gap: '40px' }}>
        
          {/* 왼쪽 입력 폼 */}
          <div style={{ flex: 1 }}>
            <label style={{ marginBottom: '10px', fontWeight: 'bold' }}>도서 제목</label><br />
            <input
              type="text"
              value={title}
              onChange={(e) => setTitle(e.target.value)}
              style={inputStyle}
            />

            <label style={{ marginBottom: '10px', fontWeight: 'bold' }}>도서 내용</label><br />
            <textarea
              rows={7}
              value={content}
              onChange={(e) => setContent(e.target.value)}
              style={textareaStyle}
            />

            <label>카테고리</label><br />
            <div style={{ display: 'flex', flexWrap: 'wrap', gap: '10px', marginTop: '10px' }}>
              {categories.map((cat) => (
                <label key={cat} style={{ marginRight: '10px' }}>
                  <input
                    type="radio"
                    name="category"
                    value={cat}
                    onChange={() => setCategory(cat)}
                  />{' '}
                  {cat}
                </label>
              ))}
            </div>
          </div>

          {/* 오른쪽 썸네일 + 버튼 */}
          <div style={{ 
            width: '260px',
            display:'flex',
            flexDirection: 'column',
            alignSelf: 'flex-start'
            }}>
            <p style={{ marginBottom: '10px', fontWeight: 'bold' }} >표지 생성 이미지</p>
             <div style={thumbnailStyle}>
              TEST<br />테스트용 썸네일입니다.
            </div>

            <button onClick={handleImageGenerate} style={buttonStyle}>표지 이미지 생성</button>
            <button onClick={handleTempSave} style={buttonStyle}>임시저장</button>
            <button onClick={handleSubmit} style={buttonStyle}>작성완료</button>
          </div>
        </div>
      </div>
    </div>
  );
}

// 스타일 객체
const navLinkStyle = {
  marginRight: '16px',
  textDecoration: 'none',
  color: '#333',
  fontWeight: 'bold'
};

const navButtonStyle = {
  marginLeft: '10px',
  padding: '6px 12px',
  backgroundColor: '#005bbb',
  color: '#fff',
  border: 'none',
  borderRadius: '4px',
  cursor: 'pointer'
};

const inputStyle = {
  width: '100%',
  padding: '10px',
  marginBottom: '20px',
  borderRadius: '6px',
  border: '1px solid #ccc'
};

const textareaStyle = {
  width: '100%',
  padding: '10px',
  marginBottom: '20px',
  borderRadius: '6px',
  border: '1px solid #ccc',
  resize: 'vertical'
};

const buttonStyle = {
  width: '100%',
  padding: '10px',
  marginBottom: '10px',
  border: 'none',
  backgroundColor: '#007bff',
  color: 'white',
  fontWeight: 'bold',
  borderRadius: '6px',
  cursor: 'pointer'
};

const thumbnailStyle = {
  width: '100%',
  height: '260px',
  backgroundColor: '#ccc',
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
  fontWeight: 'bold',
  borderRadius: '12px',
  marginBottom: '20px',
  textAlign: 'center'
};
