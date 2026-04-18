import { useState } from "react";
import {
  useNavigate
} from "react-router-dom";

function Cart() {
  const navigate =
    useNavigate();

  const [cart, setCart] =
    useState(
      JSON.parse(
        localStorage.getItem(
        "cart"
        )
      ) || []
    );

  const removeItem = (
    id
  ) => {
    const updated =
      cart.filter(
        (item) =>
          item.productId !==
          id
      );

    setCart(updated);

    localStorage.setItem(
      "cart",
      JSON.stringify(
        updated
      )
    );
  };

  const total =
    cart.reduce(
      (sum, item) =>
        sum +
        item.price *
          item.quantity,
      0
    );

  const buyNow = () => {
    const orders =
      JSON.parse(
        localStorage.getItem(
          "orders"
        )
      ) || [];

    const newOrder = {
      id: Date.now(),
      items: cart,
      total
    };

    orders.push(
      newOrder
    );

    localStorage.setItem(
      "orders",
      JSON.stringify(
        orders
      )
    );

    localStorage.removeItem(
      "cart"
    );

    navigate(
      "/orders"
    );
  };

  return (
    <div className="container">
      <h1>Cart</h1>

      {cart.map(
        (item) => (
          <div
            key={
              item.productId
            }
            className="row"
          >
            <span>
              {item.name} x{" "}
              {
                item.quantity
              }
            </span>

            <span>
              ₹
              {item.price *
                item.quantity}
            </span>

            <button
              className="danger-btn"
              onClick={() =>
                removeItem(
                  item.productId
                )
              }
            >
              Remove
            </button>
          </div>
        )
      )}

      <h2>
        Total: ₹ {total}
      </h2>

      {cart.length >
        0 && (
        <button
          className="primary-btn"
          onClick={
            buyNow
          }
        >
          Buy Now
        </button>
      )}
    </div>
  );
}

export default Cart;