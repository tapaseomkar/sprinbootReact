import React from "react";
import img from "../Images/favicon.jpg";
import { Link } from "react-router-dom";
import "../CssStyle/navbar.css";

function Navbar() {
    return (
        <div className="navbar">
            <div className="logo">
                <img src={img}  /><span className="logo-text">Competency Management System</span> 
            </div>
            <nav>
                <ul>
                    <li><a href="">DASHBOARD</a></li>
                    <li><a href="./productone.html">LOGOUT</a></li>                   
                </ul>
            </nav>
        </div>
    );
}

export default Navbar;
