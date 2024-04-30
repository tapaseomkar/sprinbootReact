import './App.css';
import { Routes, Route } from 'react-router-dom';
import Navbar from './Components/navbar';
import Sidebar from './Components/sidebar';
import Footer from './Components/footer';
import ListEmployeeComponent from "./Components/complist";
import ListEmployee from './Components/emplist';
import CountCard from './Components/compcard';
import AddCompetencyForm from './Components/compcreate';
import Login from './Components/login';
import { useState } from 'react';
import { Navigate } from 'react-router';
import Register from './Components/registration';
import EmployeeList from "./Components/employeelist";



function App() {
const[islogedin,setisloggedin]=useState(false);

const handleLogin=()=>
{
  setisloggedin(true);
}
const handleLogout=()=>
{
  setisloggedin(false);
}

return (
  <div className="mainbody">
    <Navbar onLogout={handleLogout}/>
    <div className="app-container">
      <Sidebar />
      <div className="content-container">
        <Routes>
          <Route path="/" element={islogedin? <Navigate to="/home"/>:<Login onLogin={handleLogin}/>} />
          <Route path="/home" element={<CountCard />} />
            <Route path="/complist" element={<ListEmployeeComponent />} />
            <Route path="/emplist" element={<EmployeeList />} />
            <Route path="/view/:id" element={<ListEmployee />} />
            <Route path="/compcreate" element={<AddCompetencyForm />} />
            <Route path="/registration" element={<Register />} />
            <Route path="/logout" element={islogedin? <Navigate to="/home"/>:<Login onLogin={handleLogin}/>} /> 
        </Routes>
      </div>
      <div className="footer-container">
        <Footer />
      </div>
    </div>
  </div>
);
}

export default App;