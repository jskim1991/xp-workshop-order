import { useEffect, useState } from 'react'
import axios from 'axios'

function App() {
    // useState?
    const [orders, setOrders] = useState([])

    // useEffect - 라이프 사이클
    // CORS ?
    useEffect(() => {
        axios.get('/api/orders').then((response) => {
            const { data } = response
            setOrders(data)
        })
    }, [])

    return (
        <div>
            <h1>Orders</h1>
            <table>
                <thead>
                    <tr>
                        <th>주문 번호</th>
                        <th>총 가격</th>
                    </tr>
                </thead>
                <tbody>
                    {orders.map((order) => {
                        return (
                            <tr key={order.id}>
                                <td>{order.id}</td>
                                <td>{order.totalPrice}</td>
                            </tr>
                        )
                    })}
                </tbody>
            </table>
            <div>tkdZ</div>
        </div>
    )
}

export default App
