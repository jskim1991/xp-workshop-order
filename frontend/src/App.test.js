import { render, screen, waitFor } from '@testing-library/react'
import App from './App'
import axios from 'axios'

jest.mock('axios')

describe('App', () => {
    it('renders "Orders" title', async () => {
        renderAppWithStub()

        await waitFor(() => {
            expect(screen.getByText('Orders')).toBeInTheDocument()
        })
    })

    it('should fetch orders from backend', async () => {
        renderAppWithStub()

        await waitFor(() => {
            expect(axios.get).toHaveBeenCalledWith('/api/orders')
        })
    })

    it('renders order id and price', async () => {
        renderAppWithStub([{ id: 1, totalPrice: 1000 }])

        await waitFor(() => {
            expect(screen.getByText('1')).toBeInTheDocument()
            expect(screen.getByText('1000')).toBeInTheDocument()
        })
    })
})

const renderAppWithStub = (orders = []) => {
    axios.get.mockResolvedValue({
        data: orders,
    })
    render(<App />)
}
