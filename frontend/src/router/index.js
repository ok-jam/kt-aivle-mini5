import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/authors',
      component: () => import('../components/ui/AuthorGrid.vue'),
    },
    {
      path: '/subscribers',
      component: () => import('../components/ui/SubscriberGrid.vue'),
    },
    {
      path: '/subscribes',
      component: () => import('../components/ui/SubscribeGrid.vue'),
    },
    {
      path: '/subscribeViews',
      component: () => import('../components/SubscribeViewView.vue'),
    },
    {
      path: '/writings',
      component: () => import('../components/ui/WritingGrid.vue'),
    },
    {
      path: '/포인트',
      component: () => import('../components/ui/포인트Grid.vue'),
    },
    {
      path: '/bookServices',
      component: () => import('../components/ui/BookServiceGrid.vue'),
    },
    {
      path: '/ais',
      component: () => import('../components/ui/AiGrid.vue'),
    },
    {
      path: '/books',
      component: () => import('../components/ui/BookGrid.vue'),
    },
    {
      path: '/mypages',
      component: () => import('../components/MypageView.vue'),
    },
  ],
})

export default router;
