import { useEffect, useState } from "react";
import api from "../services/api";

function Admin() {
  const [products, setProducts] = useState([]);
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [stock, setStock] = useState("");

  async function fetchProducts() {
    try {
      const res = await api.get("/api/products");
      setProducts(res.data);
    } catch {
      console.log("Failed to load");
    }
  }

  useEffect(() => {
    fetchProducts();
  }, []);

  async function addProduct() {
    try {
      await api.post("/api/products/1", {
        name: name,
        price: Number(price),
        stockQuantity: Number(stock),
        description: "Food Item"
      });

      setName("");
      setPrice("");
      setStock("");

      fetchProducts();
    } catch {
      alert("Add failed");
    }
  }

  async function deleteProduct(id) {
    try {
      await api.delete(`/api/products/${id}`);
      fetchProducts();
    } catch {
      alert("Delete failed");
    }
  }

  return (
    <div className="container">
      <h1>Admin Dashboard</h1>

      <div className="auth-box">
        <h2>Add Product</h2>

        <input
          type="text"
          placeholder="Product Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />

        <input
          type="number"
          placeholder="Price"
          value={price}
          onChange={(e) => setPrice(e.target.value)}
        />

        <input
          type="number"
          placeholder="Stock"
          value={stock}
          onChange={(e) => setStock(e.target.value)}
        />

        <button
          className="primary-btn"
          onClick={addProduct}
        >
          Add Product
        </button>
      </div>

      <div className="grid">
        {products.map((item) => (
          <div
            key={item.productId}
            className="card"
          >
            <h3>{item.name}</h3>

            <p>₹ {item.price}</p>

            <p>
              Stock:
              {item.stockQuantity}
            </p>

            <button
              className="danger-btn"
              onClick={() =>
                deleteProduct(
                  item.productId
                )
              }
            >
              Delete
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Admin;