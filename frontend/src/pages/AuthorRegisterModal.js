// pages/AuthorRegisterModal.js
import React, { useState } from 'react';
import { createPortal } from 'react-dom';

export function AuthorRegisterModal({ visible, onCancel, onConfirm }) {
  const [name, setName] = useState('');
  const [intro, setIntro] = useState('');
  const [portfolio, setPortfolio] = useState('');

  if (!visible) return null;

  const overlayStyle = {
    position: 'fixed',
    top: 0, left: 0, right: 0, bottom: 0,
    backgroundColor: 'rgba(0,0,0,0.4)',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    zIndex: 1000,
  };
  const modalStyle = {
    backgroundColor: '#fff',
    borderRadius: '8px',
    width: '320px',
    padding: '24px',
    boxShadow: '0 2px 12px rgba(0,0,0,0.2)',
  };
  const inputStyle = {
    width: '100%',
    padding: '8px',
    marginBottom: '12px',
    border: '1px solid #ccc',
    borderRadius: '4px',
    fontSize: '14px',
  };
  const btnGroup = {
    display: 'flex',
    justifyContent: 'flex-end',
    gap: '8px',
  };
  const baseBtn = {
    padding: '6px 12px',
    border: 'none',
    borderRadius: '4px',
    fontSize: '14px',
    cursor: 'pointer',
  };
  const cancelBtn = { ...baseBtn, backgroundColor: '#f0f0f0' };
  const confirmBtn = { ...baseBtn, backgroundColor: '#3566A2', color: '#fff' };

  return createPortal(
    <div style={overlayStyle}>
      <div style={modalStyle}>
        <h2 style={{ marginBottom: '16px', fontSize: '18px' }}>작가 등록</h2>
        <input
          type="text"
          placeholder="작가 이름"
          value={name}
          onChange={e => setName(e.target.value)}
          style={inputStyle}
        />
        <textarea
          placeholder="자기소개"
          value={intro}
          onChange={e => setIntro(e.target.value)}
          style={{ ...inputStyle, height: '80px', resize: 'vertical' }}
        />
        <input
          type="text"
          placeholder="포트폴리오 URL"
          value={portfolio}
          onChange={e => setPortfolio(e.target.value)}
          style={inputStyle}
        />
        <div style={btnGroup}>
          <button
            onClick={() => {
              setName(''); setIntro(''); setPortfolio('');
              onCancel();
            }}
            style={cancelBtn}
          >
            취소
          </button>
          <button
            onClick={() => {
              onConfirm({ name, intro, portfolio });
              setName(''); setIntro(''); setPortfolio('');
            }}
            style={confirmBtn}
          >
            작가 승인 요청
          </button>
        </div>
      </div>
    </div>,
    document.body
  );
}
