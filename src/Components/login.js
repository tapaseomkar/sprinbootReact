import React, { useState } from 'react';
import "../CssStyle/login.css";
import CompetencyService from '../Redux/competencyservice';
import { Link } from 'react-router-dom';
//import { useHistory } from 'react-router-dom'; (package problem)
const Login = ({onLogin}) => {

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

 // const history = useHistory();

//  const handleEmailChange = (e) => {
//     setEmail(e.target.value);
//   };

  const handleSubmit = async (e) => 
  {
    e.preventDefault();
    try {
      const response = await CompetencyService.login(email, password); 
      console.log('you have login',response.data);
      // onLogin();
      if(typeof onLogin==='function')
      {
        onLogin();
      }

    } catch (error) {
      console.error('Login error:', error);
    }
  };

  return (
    <div className="login-container"> 
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} required />
        <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} required />
        <button type="submit">Login</button>
        <p>Don't have an account? <Link to="/registration">Register here</Link></p> 
      </form>
    </div>
  );
};

export default Login;
