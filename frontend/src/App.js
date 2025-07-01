import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import AuthorList from './pages/AuthorList';
import AuthorRegister from './pages/AuthorRegister';
import BookList from './pages/BookList';
import BookWrite from './pages/BookWrite';
import Admin from './pages/Admin';
import Subscribe from './pages/Subscribe';
import MyPage from './pages/MyPage';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/authors" element={<AuthorList />} />
        <Route path="/author/register" element={<AuthorRegister />} />
        <Route path="/books" element={<BookList />} />
        <Route path="/mypage" element={<MyPage />} />
        <Route path="/book/write" element={<BookWrite />} />
        <Route path="/admin" element={<Admin />} />
        <Route path="/subscribe" element={<Subscribe />} />
      </Routes>
    </Router>
  );
}

export default App;
