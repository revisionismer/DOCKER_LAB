import { useEffect, useState } from 'react';
import './App.css';
import Card from './components/Card';

function App() {

  const [products, setProducts] = useState([]);

  async function onLoad() {
    // nginx : 미포함
    // let response = await fetch("http://127.0.0.1:8080/api/products");

    // nginx : 포함 : 백엔드단에서는 api라는 RequestMapping을 지웠고 nginx.conf 파일에서 url 요청이 오면 /api/를 제외하는 코드를 넣었놨음
    let response = await fetch("/api/products");
    let responseBody = await response.json();

    console.log("onLoad", responseBody);

    setProducts(responseBody);

  }

  // * useEffect() : 해당 페이지가 열릴 때 한 번 실행된다.
  // [] : 어떤 값이 변경될때 화면을 다시 그릴지 변수를 정해주는 곳(빈 배열을 넣으면 어떤 값이든이라는 뜻)
  useEffect(() => {
    onLoad();
  }, [])

  return (
    <div>
      <h1>상품목록페이지</h1>
      <hr />

      <div>
        {products.map((product, index) => {
          return <Card product={product} key={index} />
        })}

      </div>
    </div>
  );
}

export default App;
