import { useEffect, useState } from "react";
import api from "../services/api";

function Admin() {
  const [products, setProducts] = useState([]);

  const loadProducts = async () => {
    try {
      const res = await api.get("/api/products");
      setProducts(res.data);
    } catch {
      setProducts([
        { productId: 1, name: "Pizza" },
        { productId: 2, name: "Burger" }
      ]);
    }
  };

  useEffect(() => {
    loadProducts();
  }, []);

  return (
    <div className="container">
      <h1>Admin Dashboard</h1>

      <div className="admin-box">
        {products.map((p) => (
          <div className="admin-row" key={p.productId}>
            <span>{p.name}</span>
            <button>Delete</button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Admin;