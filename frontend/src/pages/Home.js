export default function Home() {
  const books = [
    { title: 'Book Title', date: '2025-05-28', views: '3,125' },
    { title: 'Book Title', date: '2025-05-28', views: '3,125' },
    { title: 'Book Title', date: '2025-05-28', views: '3,125' },
  ];

  return (
    <div style={{ fontFamily: 'sans-serif', padding: '20px' }}>

      {/* 네비게이션 */}
      <nav style={{
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        padding: '10px 20px',
        borderBottom: '1px solid #ddd'
      }}>
        <div><strong>📘 작가의 산책</strong></div>
        <div>
          <a href="book/write" style={{ margin: '0 10px' }}>도서 등록</a>
        </div>
        <div>
          <button>로그인</button>
          <button style={{ marginLeft: '10px' }}>회원가입</button>
        </div>
      </nav>

      {/* 제목 영역 */}
      <section style={{ textAlign: 'center', margin: '50px 0' }}>
        <h1 style={{ fontSize: '2rem', fontWeight: 'bold' }}>작가의 산책</h1>
        <p>국내 최대 독서 플랫폼, "걷다가 서재" 입니다.</p>
      </section>

      {/* 검색창 */}
      <div style={{ display: 'flex', justifyContent: 'center', marginBottom: '40px' }}>
        <input
          type="text"
          placeholder="검색어를 입력해주세요."
          style={{
            padding: '12px 16px',
            width: '300px',
            borderRadius: '20px 0 0 20px',
            border: '1px solid #ccc'
          }}
        />
        <button style={{
          padding: '12px 16px',
          borderRadius: '0 20px 20px 0',
          border: '1px solid #ccc',
          backgroundColor: 'white',
          cursor: 'pointer'
        }}>
          🔍
        </button>
      </div>

      {/* 도서 카드 리스트 */}
      <div style={{ display: 'flex', justifyContent: 'center', gap: '20px' }}>
        {books.map((book, idx) => (
          <div key={idx} style={{
            width: '160px',
            border: '1px solid #ccc',
            borderRadius: '12px',
            overflow: 'hidden',
            backgroundColor: '#f5f5f5',
            textAlign: 'center'
          }}>
            <div style={{
              height: '100px',
              backgroundColor: '#aaa',
              color: 'white',
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
              fontWeight: 'bold'
            }}>
              TEST<br />테스트용 샘플입니다.
            </div>
            <div style={{ backgroundColor: 'white', padding: '10px' }}>
              <strong style={{ display: 'block', marginBottom: '4px' }}>{book.title}</strong>
              <small>{book.date} 조회수: {book.views}</small>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
