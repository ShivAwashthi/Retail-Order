import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  const login = () => {
    localStorage.setItem("token", "123");

    if (email === "admin@gmail.com") {
      localStorage.setItem("role", "ADMIN");
    } else {
      localStorage.setItem("role", "USER");
    }

    navigate("/products");
  };

  return (
    <div className="auth-box">
      <h1>Login</h1>

      <input
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />

      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />

      <button onClick={login}>Login</button>
    </div>
  );
}

export default Login;