import axios from "axios";

const api = axios.create({
  baseURL: process.env.NODE_ENV === 'production'
    ? 'http://49.168.40.100:8080'  // 배포 서버 주소
    : 'http://localhost:8080',     // 로컬 서버 주소
});

export default api;
