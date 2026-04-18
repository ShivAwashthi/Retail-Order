function Orders() {
  const orders =
    JSON.parse(
      localStorage.getItem(
        "orders"
      )
    ) || [];

  return (
    <div className="container">
      <h1>Orders</h1>

      {orders.map(
        (o) => (
          <div
            key={o.id}
            className="card"
          >
            <h3>
              Order #
              {o.id}
            </h3>

            <p>
              Total ₹
              {
                o.total
              }
            </p>

            <p>
              Status:
              Pending
            </p>
          </div>
        )
      )}
    </div>
  );
}

export default Orders;