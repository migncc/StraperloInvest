import Header from './components/Header'
import CardStock from './components/CardStock'
import CardStockBack from './components/CardStockBack'
import useFavoritos from './hooks/useFavoritos'
import { useState } from 'react'

// 🔧 Mock temporal
const getMockData = (ticker) => {
  const base = {
    AAPL: { name: 'Apple Inc.', sector: 'Tecnología', score: 82, per: 28.3, price: '$218.40', marketCap: '$2.9T' },
    TSLA: { name: 'Tesla, Inc.', sector: 'Automoción', score: 78, per: 45.1, price: '$697.00', marketCap: '$850B' },
    AMZN: { name: 'Amazon.com, Inc.', sector: 'Consumo', score: 76, per: 36.2, price: '$129.75', marketCap: '$1.5T' },
    MSFT: { name: 'Microsoft Corp.', sector: 'Tecnología', score: 81, per: 34.7, price: '$312.90', marketCap: '$2.8T' },
    NVDA: { name: 'Nvidia Corporation', sector: 'Tecnología', score: 85, per: 62.5, price: '$435.12', marketCap: '$1.1T' },
    CVX: { name: 'Chevron Corporation', sector: 'Energía', score: 70, per: 17.2, price: '$157.40', marketCap: '$300B' }
  }

  return {
    rank: 0,
    ticker,
    ...base[ticker] || {
      name: 'Empresa desconocida',
      sector: '—',
      score: 0,
      per: 0,
      price: '$0.00',
      marketCap: 'N/A',
    },
  }
}

export default function Favoritos() {
  const { favoritos } = useFavoritos()
  const [flippedCards, setFlippedCards] = useState(new Set())

  const handleFlip = (index) => {
    const updated = new Set(flippedCards)
    updated.add(index)
    setFlippedCards(updated)
  }

  const handleFlipBack = (index) => {
    const updated = new Set(flippedCards)
    updated.delete(index)
    setFlippedCards(updated)
  }

  const datos = favoritos.map((ticker, idx) => ({
    ...getMockData(ticker),
    rank: idx + 1,
  }))

  return (
    <div className="min-h-screen bg-[#f7f7f7] text-black font-sans">
      <Header />
      <main className="max-w-7xl mx-auto px-6 py-16">
        {/* Título */}
        <div className="text-center mb-14">
          <h1 className="text-4xl md:text-5xl font-extrabold mb-3">Tus favoritos</h1>
          <p className="text-lg text-gray-500">Acciones que has guardado para revisar más tarde</p>
        </div>

        {/* Tarjetas */}
<div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-8">
  {datos.map((stock, idx) => {
    const isFlipped = flippedCards.has(idx)
    return (
      <div key={idx} className="flip-card relative w-full h-[380px]">
        <div className={`flip-inner w-full h-full ${isFlipped ? 'rotate' : ''}`}>
          <div className="flip-front absolute inset-0">
            <CardStock data={stock} onFlip={() => handleFlip(idx)} />
          </div>
          <div className="flip-back absolute inset-0">
            <CardStockBack data={stock} onFlipBack={() => handleFlipBack(idx)} />
          </div>
        </div>
      </div>
    )
  })}
</div>


      </main>
    </div>
  )
}
