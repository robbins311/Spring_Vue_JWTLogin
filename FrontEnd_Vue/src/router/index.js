import VueRouter from "vue-router";
import SignUp from "../pages/member/SignUp";
import Login from "../pages/member/Login";
import Index from "../pages/Index";
import Me from "../pages/member/Me";
import Check from "../pages/member/Check";


// 로그인 인증
const requireAuth = () => (to, from, next) => {
    console.log('HSTEST:: requireAuth')
    let token = localStorage.getItem('access_token');
  if(token) {
      return next();
  } else {
      window.alert("로그인이 필요합니다.")
      return next('/')
  }
};

const routes = [
    {path:'/', component:Index},
    {path: '/member/signup', component: SignUp},
    {path: '/member/login', component: Login},
    // 인증이 필요한 페이지는 decorating
    {path: '/member/me', component: Me, beforeEnter: requireAuth()},
    {path: '/member/check', component: Check},

]
const options = {routes, mode:'history', base: process.env.BASE_URL}
const router = new VueRouter(options)

export default router;