import { useEffect, useState } from 'react'
import axios from 'axios'

function App() {
    const [orders, setOrders] = useState([])

    useEffect(() => {
        axios.get('/api/orders').then((response) => {
            const { data } = response
            setOrders(data)
        })
    }, [])

    return (
        <div>
            <div>Orders</div>
            {orders.map((order) => {
                return (
                    <div key={order.id}>
                        <div>ID: {order.id}</div>
                        <div>TOTAL PRICE: {order.totalPrice}</div>
                    </div>
                )
            })}
        </div>
    )
}

export default App
