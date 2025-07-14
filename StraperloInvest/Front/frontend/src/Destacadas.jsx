import { useState } from 'react'
import Header from './components/Header'
import CardStock from './components/CardStock'
import CardStockBack from './components/CardStockBack'
import Footer from './components/Footer'


export default function Destacadas() {
  const [flippedCards, setFlippedCards] = useState(new Set())

  const destacados = [
    {
      rank: 1,
      name: 'Apple Inc.',
      ticker: 'AAPL',
      sector: 'Tecnología',
      score: 82,
      per: 28.3,
      price: '$218.40',
      marketCap: '$2.9T',
    },
    {
      rank: 2,
      name: 'Tesla, Inc.',
      ticker: 'TSLA',
      sector: 'Automoción',
      score: 78,
      per: 45.1,
      price: '$697.00',
      marketCap: '$850B',
    },
    {
      rank: 3,
      name: 'Amazon.com, Inc.',
      ticker: 'AMZN',
      sector: 'Consumo',
      score: 76,
      per: 36.2,
      price: '$129.75',
      marketCap: '$1.5T',
    },
    {
      rank: 4,
      name: 'Nvidia Corporation',
      ticker: 'NVDA',
      sector: 'Tecnología',
      score: 85,
      per: 62.5,
      price: '$435.12',
      marketCap: '$1.1T',
    },
    {
      rank: 5,
      name: 'Microsoft Corp.',
      ticker: 'MSFT',
      sector: 'Tecnología',
      score: 81,
      per: 34.7,
      price: '$312.90',
      marketCap: '$2.8T',
    },
    {
      rank: 6,
      name: 'Chevron Corporation',
      ticker: 'CVX',
      sector: 'Energía',
      score: 70,
      per: 17.2,
      price: '$157.40',
      marketCap: '$300B',
    },
  ]

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

  return (
    <div className="min-h-screen bg-[#f7f7f7] text-black font-sans">
      <Header />

      <main className="max-w-7xl mx-auto px-6 py-16">
        {/* Título */}
        <div className="text-center mb-14">
          <h1 className="text-4xl md:text-5xl font-extrabold mb-3">Acciones destacadas</h1>
          <p className="text-lg text-gray-500">Las mejores valoradas este mes por nuestro algoritmo</p>
        </div>

        {/* Tarjetas */}
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-8">
          {destacados.map((stock, idx) => {
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
      <Footer />
    </div>
  )
}
