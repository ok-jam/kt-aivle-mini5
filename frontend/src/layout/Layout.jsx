import { Outlet } from "react-router-dom";
import Navbar from "../components/Header/Navbar";

//우리가 만드는 앱의 전체 화면 구조를 잡는 역할.. 
const Layout = () => {
    return (
        <>
            <Navbar/>
            {/* router 에 의해 결정된 화면을 출력하는 위치... */}
            <div className="form-box">
            <Outlet />
            </div>
        </>
    )
}
export default Layout