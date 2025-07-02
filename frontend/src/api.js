import axios from "axios";

const api = axios.create({
  baseURL: import.meta.env.PROD
    ? 'http://49.168.40.100:8080'  // 배포용
    : 'http://localhost:8080',     // 로컬 개발용
});

export default api;
