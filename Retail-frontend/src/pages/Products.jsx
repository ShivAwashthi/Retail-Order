import { useEffect, useState } from "react";
import api from "../services/api";

function Products() {
  const [products, setProducts] = useState([]);

  const loadProducts = async () => {
    try {
      const res = await api.get("/api/products");
      setProducts(res.data);
    } catch {
      setProducts([
        { productId: 1, name: "Pizza", price: 299 },
        { productId: 2, name: "Burger", price: 199 },
        { productId: 3, name: "Cold Drink", price: 49 }
      ]);
    }
  };

  useEffect(() => {
    loadProducts();
  }, []);

  const addToCart = (item) => {
    let cart = JSON.parse(localStorage.getItem("cart")) || [];
    cart.push(item);
    localStorage.setItem("cart", JSON.stringify(cart));
    alert("Added to cart");
  };

  return (
    <div className="container">
      <h1>Products</h1>

      <div className="product-grid">
        {products.map((p) => (
          <div className="card" key={p.productId}>
            <h3>{p.name}</h3>
            <p className="price">₹ {p.price}</p>
            <button onClick={() => addToCart(p)}>
              Add To Cart
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Products;