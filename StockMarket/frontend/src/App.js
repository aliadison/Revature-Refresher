import { useState, useEffect } from "react";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import CancelIcon from '@mui/icons-material/Cancel';
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
    } else if (quantity < 1) {
      setMessage("Quantity has to be greater than 0");
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
  }, [stock]);

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
                      {item.stock_name} {item.symbol} {item.price}
                    </li>
                  );
                }
                return null;
              })}
            </ul>
          </div>
          {stock && (
          <div className="stocksDetail">
              <CancelIcon id="closeBtn" onClick={()=> setStock(null)}/>
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
                <TextField
                  id="outlined-basic"
                  label="Price"
                  variant="outlined"
                  value={price}
                  onChange={(e) => setPrice(e.target.value)}
                />
        
                <TextField
                  id="outlined-basic"
                  label="Quantity"
                  variant="outlined"
                  value={quantity}
                  onChange={(e) => setQuantity(e.target.value)}
                />
              
                <Button
                  variant="contained"
                  color="success"
                  onClick={handleSubmit}
                >
                  Buy
                </Button>
                <div className="message">
                  {message ? <p>{message}</p> : null}
                </div>
              </div>
          </div>
          )}
        </div>
      </div>
    );
  }
}

export default App;
