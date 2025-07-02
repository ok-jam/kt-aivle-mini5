// pages/ReChargeModal.js
import React, { useState } from 'react';
import { createPortal } from 'react-dom';

export function ReChargeModal({ visible, onCancel, onConfirm }) {
  const [amount, setAmount] = useState('');

  if (!visible) return null;

  // 인라인 스타일 정의
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
    marginBottom: '16px',
    border: '1px solid #ccc',
    borderRadius: '4px',
    fontSize: '16px',
  };
  const btnGroupStyle = {
    display: 'flex',
    justifyContent: 'flex-end',
    gap: '8px',
  };
  const btnStyle = {
    padding: '6px 12px',
    borderRadius: '4px',
    fontSize: '14px',
    cursor: 'pointer',
    border: 'none',
  };
  const cancelBtnStyle = {
    ...btnStyle,
    backgroundColor: '#f0f0f0',
  };
  const confirmBtnStyle = {
    ...btnStyle,
    backgroundColor: '#3566A2',
    color: '#fff',
  };

  return createPortal(
    <div style={overlayStyle}>
      <div style={modalStyle}>
        <h2 style={{ marginBottom: '16px', fontSize: '18px' }}>충전할 금액을 입력하세요.</h2>
        <input
          type="number"
          placeholder="금액"
          value={amount}
          onChange={e => setAmount(e.target.value)}
          style={inputStyle}
        />
        <div style={btnGroupStyle}>
          <button
            onClick={() => {
              setAmount('');
              onCancel();
            }}
            style={cancelBtnStyle}
          >
            취소
          </button>
          <button
            onClick={() => {
              onConfirm(amount);
              setAmount('');
            }}
            style={confirmBtnStyle}
          >
            충전
          </button>
        </div>
      </div>
    </div>,
    document.body
  );
}