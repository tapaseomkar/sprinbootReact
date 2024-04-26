import './App.css';
import { Routes, Route } from 'react-router-dom';
import Navbar from './Components/navbar';
import Sidebar from './Components/sidebar';
import Footer from './Components/footer';
import ListEmployeeComponent from "./Components/complist";
import ListEmployee from './Components/emplist';
import CountCard from './Components/compcard';
import AddCompetencyForm from './Components/compcreate';



function App() {
  return (
    // <div className="mainbody">
    // <Navbar/>
    //      <div className="app-container">
    //      <Sidebar/>
    //      <div className="content-container">
    //      <Routes>
    //      <Route path="/home" element={<CountCard/>} /> 
    //       <Route path="/complist" element={<ListEmployeeComponent/>} /> 
    //       <Route path="/view/:id" element={<ListEmployee/>} />
    //      </Routes>
    //      </div>
    //      <Footer/>  
    //      </div>
          
        
    //   </div>

    <div className="mainbody">
    <Navbar />
    <div className="app-container">
      <Sidebar />
      <div className="content-container">
        <Routes>
          <Route path="/home" element={<CountCard />} />
          <Route path="/complist" element={<ListEmployeeComponent />} />
          <Route path="/view/:id" element={<ListEmployee />} />
          <Route path="/compcreate" element={<AddCompetencyForm />} />
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
