import React from "react";
import { Link } from "react-router-dom";
import "../CssStyle/sidebar.css";

function Sidebar() {
  return (
    <div className="container">
      <div className="sidebar" id="sidebar">
        
        <ul className="list">
          <li><Link to={'/home'}>HOME</Link></li>
          <li><Link to={'/complist'}>COMPETENCY</Link></li>
          <li><Link to={'/compcreate'}>CREATE</Link></li>
          <li><Link to={'/compdel'}>SEARCH</Link></li>
          <li><Link to={'/compser'}>MESSAGES</Link></li>
          <li><a href="#">EMPLOYEE</a></li>
        </ul>
      </div>
    </div>
  );
}

export default Sidebar;
