import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../services/api";

function Signup() {
  const navigate = useNavigate();

  const [username, setUsername] =
    useState("");

  const [password, setPassword] =
    useState("");

  const [role, setRole] =
    useState("USER");

  const [loading, setLoading] =
    useState(false);

  const registerUser = async () => {
    try {
      setLoading(true);

      await api.post(
        "/api/auth/signup",
        {
          username,
          password,
          roles: [role]
        }
      );

      alert(
        "Signup Successful"
      );

      navigate("/");
    } catch {
      alert("Signup Failed");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="auth-wrapper">
      <div className="auth-box">
        <h1>Signup</h1>

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

        <select
          value={role}
          onChange={(e) =>
            setRole(
              e.target.value
            )
          }
        >
          <option value="USER">
            User
          </option>

          <option value="ADMIN">
            Admin
          </option>
        </select>

        <button
          className="primary-btn"
          onClick={registerUser}
          disabled={loading}
        >
          {loading
            ? "Please wait..."
            : "Signup"}
        </button>
      </div>
    </div>
  );
}

export default Signup;