function Cart() {
  const cart = JSON.parse(localStorage.getItem("cart")) || [];

  return (
    <div className="container">
      <h1>Cart</h1>

      <div className="cart-box">
        {cart.map((item, i) => (
          <div className="cart-item" key={i}>
            <span>{item.name}</span>
            <span>₹ {item.price}</span>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Cart;