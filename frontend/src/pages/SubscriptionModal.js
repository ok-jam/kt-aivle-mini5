// pages/SubscriptionModal.js
import React from 'react';
import { createPortal } from 'react-dom';

export function SubscriptionModal({ visible, onCancel, onConfirm }) {
  if (!visible) return null;

  const overlayStyle = {
    position: 'fixed',
    top: 0, left: 0, right: 0, bottom: 0,
    backgroundColor: 'rgba(0,0,0,0.3)',
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
    textAlign: 'center',
  };

  const titleStyle = { margin: 0, fontSize: '16px', fontWeight: 500, color: '#555' };
  const priceWrapper = {
    display: 'flex',
    alignItems: 'baseline',
    justifyContent: 'center',
    margin: '8px 0',
  };
  const dollarStyle = { fontSize: '24px', fontWeight: 600 };
  const perMoStyle = { fontSize: '14px', marginLeft: 4, color: '#888' };
  const listStyle = {
    textAlign: 'left',
    margin: '16px 0',
    paddingLeft: '20px',
    color: '#444',
  };

  // 버튼 그룹 & 스타일 통일
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
  const confirmBtn = { ...baseBtn, backgroundColor: '#e0e0e0', color: '#888' }; // 구독하기
  const cancelBtn  = { ...baseBtn, backgroundColor: '#333',   color: '#fff' };  // 아니요

  return createPortal(
    <div style={overlayStyle}>
      <div style={modalStyle}>
        <p style={titleStyle}>MONTH</p>

        <div style={priceWrapper}>
          <span style={dollarStyle}>$7.34</span>
          <span style={perMoStyle}>/mo</span>
        </div>

        <ul style={listStyle}>
          <li>무제한 열람 가능</li>
          <li>광고 없이 쾌적한 이용</li>
          <li>언제든 해지 가능</li>
          <li>개인 맞춤 콘텐츠 추천</li>
        </ul>

        <div style={btnGroup}>
          <button
            style={confirmBtn}
            onClick={() => {
              onConfirm();
            }}
          >
            구독하기
          </button>
          <button
            style={cancelBtn}
            onClick={() => {
              onCancel();
            }}
          >
            아니요
          </button>
        </div>
      </div>
    </div>,
    document.body
  );
}