import { useEffect, useState } from "react";
import api from "../services/api";

function Products() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const res = await api.get("/api/products");
        setProducts(res.data);
      } catch {
        alert("Cannot load products");
      }
    };

    fetchProducts();
  }, []);

  return (
    <div className="container">
      <h1>Products</h1>

      <div className="grid">
        {products.map((p) => (
          <div key={p.productId} className="card">
            <h2>{p.name}</h2>
            <p>₹ {p.price}</p>
            <p>Stock: {p.stockQuantity}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Products;