import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import MyPage from './pages/MyPage';
import Admin from './pages/Admin';
import BookSample from './pages/BookSample';
import BookDetail from './pages/BookDetail';
import Subscribe from './pages/Subscribe';
import AuthorPage from './pages/AuthorPage';
import BookList from './pages/BookList';
import BookWrite from './pages/BookWrite';
import Layout from './layout/Layout';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Layout />} >
          <Route path="/" element={<Home/>}/>
          <Route path="/mypage" element={<MyPage />} />
          <Route path="/admin" element={<Admin />} />
          <Route path="/book/sample/:id" element={<BookSample />} />
          <Route path="/book/detail/:id" element={<BookDetail />} />
          <Route path="/subscribe" element={<Subscribe />} />
          <Route path="/author/:id" element={<AuthorPage />} />
          <Route path="/books" element={<BookList />} />
          <Route path="/book/write" element={<BookWrite />} />
        </Route>
        
      </Routes>
    </Router>
  );
}

export default App;
