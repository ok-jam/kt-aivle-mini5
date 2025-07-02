const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
  app.use(
    '/authors',
    createProxyMiddleware({
      target: 'http://localhost:8082',
      changeOrigin: true,
    })
  );
//   app.use(
//     '/books',
//     createProxyMiddleware({
//       target: 'http://localhost:8083',
//       changeOrigin: true,
//     })
//   );
//   app.use(
//     '/subscriptions',
//     createProxyMiddleware({
//       target: 'http://localhost:8084',
//       changeOrigin: true,
//     })
//   );
};