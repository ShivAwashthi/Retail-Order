import {
  Link,
  useNavigate
} from "react-router-dom";

function Navbar() {
  const navigate =
    useNavigate();

  const token =
    localStorage.getItem("token");

  const role =
    localStorage.getItem("role");

  const username =
    localStorage.getItem(
      "username"
    );

  const logout = () => {
    localStorage.clear();
    navigate("/login");
  };

  return (
    <nav>
      {!token && (
        <>
          <Link to="/login">
            Login
          </Link>

          <Link to="/signup">
            Signup
          </Link>
        </>
      )}

      {token &&
        role ===
          "ROLE_USER" && (
          <>
            <Link to="/products">
              Products
            </Link>

            <Link to="/cart">
              Cart
            </Link>

            <Link to="/orders">
              Orders
            </Link>
          </>
        )}

      {token &&
        role ===
          "ROLE_ADMIN" && (
          <Link to="/admin">
            Dashboard
          </Link>
        )}

      {token && (
        <span className="nav-user">
          {username}
        </span>
      )}

      {token && (
        <button
          onClick={logout}
        >
          Logout
        </button>
      )}
    </nav>
  );
}

export default Navbar;