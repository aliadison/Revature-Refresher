import { useState, useEffect } from "react";
import "./App.css";

function App() {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [items, setItems] = useState([]);

  const [stock, setStock] = useState(null);

  const [marketCapFilter, setMarketCapFilter] = useState(0);

  const [price, setPrice] = useState("");
  const [quantity, setQuantity] = useState("");
  const [message, setMessage] = useState("");

  let handleSubmit = async (e) => {
    e.preventDefault();
    if (price < stock.price) {
      setMessage("Price is less than the market price");
    } else if (quantity > stock.available_shares) {
      setMessage("Not enough shares available");
    } else {
      try {
        let formData = new FormData();
        formData.append("id", stock.id);
        formData.append("price", price);
        formData.append("quantity", quantity);
        let res = await fetch("http://localhost:8080/stocks/buy", {
          method: "POST",
          body: formData,
        });
        let resJson = await res.json();
        if (res.status === 200) {
          setPrice("");
          setQuantity("");
          setMessage("Stock bought successfully");
          setStock(resJson);
        } else {
          setMessage("Some error occured");
        }
      } catch (err) {
        console.log(err);
      }
    }
  };
  // Note: the empty deps array [] means
  // this useEffect will run once
  // similar to componentDidMount()
  useEffect(() => {
    fetch("http://localhost:8080/stocks/all")
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setItems(result);
        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          setIsLoaded(true);
          setError(error);
        }
      );
  }, []);

  if (error) {
    return <div>Error: {error.message}</div>;
  } else if (!isLoaded) {
    return <div>Loading...</div>;
  } else {
    return (
      <div className="App">
        <header className="App-header">
          <h1>Stock Market</h1>
        </header>
        <div className="wrapper">
          <div className="stocksList">
            Market Cap Above{" "}
            <input
              type="text"
              onChange={(e) => setMarketCapFilter(e.target.value)}
            ></input>
            <ul>
              {items.map((item) => {
                if (item.market_cap > marketCapFilter) {
                  return (
                    <li key={item.id} onClick={() => setStock(item)}>
                      {item.stock_name} {item.price}
                    </li>
                  );
                }
                return null;
              })}
            </ul>
          </div>
          <div className="stocksDetail">
            {stock && (
              <div>
                <h1>
                  {stock.stock_name} ({stock.symbol})
                </h1>
                <h2>Current Price: ${stock.price}</h2>
                <h3>Market Cap: ${stock.market_cap}</h3>
                <h3>
                  Available Shares: {stock.available_shares} / Total Shares:{" "}
                  {stock.total_supply}
                </h3>
                <form onSubmit={handleSubmit}>
                  <input
                    type="text"
                    value={price}
                    placeholder="Price"
                    onChange={(e) => setPrice(e.target.value)}
                  />
                  <input
                    type="text"
                    value={quantity}
                    placeholder="Quantity"
                    onChange={(e) => setQuantity(e.target.value)}
                  />

                  <button type="submit">Buy</button>

                  <div className="message">
                    {message ? <p>{message}</p> : null}
                  </div>
                </form>
              </div>
            )}
          </div>
        </div>
      </div>
    );
  }
}

export default App;
