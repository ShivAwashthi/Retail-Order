import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../services/api";

function Login() {
  const navigate = useNavigate();

  const [username, setUsername] =
    useState("");

  const [password, setPassword] =
    useState("");

  const [loading, setLoading] =
    useState(false);

  const loginUser = async () => {
    try {
      setLoading(true);

      const res = await api.post(
        "/api/auth/login",
        {
          username,
          password
        }
      );

      const data = res.data;

      localStorage.setItem(
        "token",
        data.jwtToken
      );

      localStorage.setItem(
        "role",
        data.roles[0]
      );

      if (
        data.roles.includes(
          "ROLE_ADMIN"
        )
      ) {
        navigate("/admin");
      } else {
        navigate("/products");
      }
    } catch {
      alert(
        "Invalid username or password"
      );
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="auth-wrapper">
      <div className="auth-box">
        <h1>Login</h1>

        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) =>
            setUsername(
              e.target.value
            )
          }
        />

        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) =>
            setPassword(
              e.target.value
            )
          }
        />

        <button
          className="primary-btn"
          onClick={loginUser}
          disabled={loading}
        >
          {loading
            ? "Please wait..."
            : "Login"}
        </button>
      </div>
    </div>
  );
}

export default Login;