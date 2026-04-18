import { useEffect, useState } from "react";
import api from "../services/api";

function Orders() {
  const [orders, setOrders] = useState([]);

  const loadOrders = async () => {
    try {
      const res = await api.get("/api/orders/user/1");
      setOrders(res.data);
    } catch {
      setOrders([
        { orderId: 101, totalAmount: 499, status: "PENDING" },
        { orderId: 102, totalAmount: 299, status: "DELIVERED" }
      ]);
    }
  };

  useEffect(() => {
    loadOrders();
  }, []);

  return (
    <div className="container">
      <h1>My Orders</h1>

      {orders.map((o) => (
        <div className="order-box" key={o.orderId}>
          <h3>Order #{o.orderId}</h3>
          <p>₹ {o.totalAmount}</p>
          <p>{o.status}</p>
        </div>
      ))}
    </div>
  );
}

export default Orders;