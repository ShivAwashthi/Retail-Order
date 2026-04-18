import { Navigate } from "react-router-dom";

function AdminRoute({
  children
}) {
  const token =
    localStorage.getItem("token");

  const role =
    localStorage.getItem("role");

  const isAdmin =
    role === "ROLE_ADMIN";

  return token && isAdmin
    ? children
    : <Navigate to="/login" />;
}

export default AdminRoute;