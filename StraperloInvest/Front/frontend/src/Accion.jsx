import { useParams } from 'react-router-dom'
import Header from './components/Header.jsx'
import Footer from './components/Footer'
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
} from 'recharts'
import { Star } from 'lucide-react'

import useFavoritos from './hooks/useFavoritos'


export default function Accion() {
     const { ticker } = useParams()
      const stock = {
    name: 'Apple Inc.',
    ticker: ticker.toUpperCase(),
    sector: 'Tecnología',
    price: '$218.40',
    marketCap: '$2.9T',
    per: 28.3,
    ebitda: '$120B',
    rating: 'Buy',
    score: 82,
    resumen:
      'Esta acción presenta un perfil sólido con buenas métricas de rentabilidad y riesgo moderado.',
    checks: [
      { texto: 'PER dentro del rango óptimo', valor: 0.8 },
      { texto: 'Buen crecimiento de beneficios', valor: 0.9 },
      { texto: 'Valoración algo exigente respecto al sector', valor: 0.3 },
      { texto: 'EBITDA creciente en últimos 3 años', valor: 0.7 },
    ],
  }
 const { guardar, eliminar, estaGuardado } = useFavoritos()
const isFav = estaGuardado(stock.ticker)

const toggleFav = () => {
  isFav ? eliminar(stock.ticker) : guardar(stock.ticker)
}


  const data = [
    { name: 'Jan', price: 178 },
    { name: 'Feb', price: 190 },
    { name: 'Mar', price: 200 },
    { name: 'Apr', price: 215 },
    { name: 'May', price: 210 },
    { name: 'Jun', price: 218 },
  ]

  const chartIsPositive = data[data.length - 1].price >= data[0].price
  const chartColor = chartIsPositive ? '#1766f9' : '#F5AF12'

 const companyToDomain = (name) => {
  return name
    .toLowerCase()
    .replace(/(inc\.?|corp\.?|ltd\.?|co\.?|s\.a\.|plc)/gi, '')
    .trim()
    .replace(/\s+/g, '') + '.com'
}

const companyLogoURL = `https://logo.clearbit.com/${companyToDomain(stock.name)}`

  return (
    <div className="min-h-screen bg-[#fcfdfc] text-black font-sans">
      <Header />

      <main className="max-w-6xl mx-auto px-6 lg:px-16 py-16">
        {/* Encabezado con favorito */}
        <div className="flex justify-between items-center mb-8">
          <div>
<img
  src={companyLogoURL}
  alt={`${stock.name} logo`}
  className="w-10 h-10 rounded-md mr-2 object-contain"
  onError={(e) => {
    e.target.onerror = null
    e.target.src = '/assets/recursos/default.png' // ← asegúrate de tener esta imagen
  }}
/>

            <h1 className="text-4xl font-bold text-[#0b0d10]">
              {stock.name}{' '}
              <span className="text-gray-500">| {stock.ticker}</span>
            </h1>
            <p className="text-sm text-gray-500">Sector: {stock.sector}</p>
          </div>
          <button
            onClick={toggleFav}
            className={`border rounded-full p-2 transition ${
              isFav ? 'bg-[#1766f9] text-white' : 'border-black text-black'
            }`}
          >
            <Star fill={isFav ? '#1766f9' : 'none'} className="w-5 h-5" />
          </button>
        </div>

        {/* Gráfico */}
        <div className="bg-white rounded-xl shadow-md p-6 mb-12">
          <h3 className="text-lg font-semibold mb-4">Evolución del precio</h3>
          <div style={{ width: '100%', height: 300 }}>
            <ResponsiveContainer>
              <LineChart data={data}>
                <XAxis dataKey="name" stroke="#888" />
                <YAxis stroke="#888" />
                <Tooltip />
                <Line
                  type="monotone"
                  dataKey="price"
                  stroke={chartColor}
                  strokeWidth={3}
                />
              </LineChart>
            </ResponsiveContainer>
          </div>
        </div>

        {/* Score */}
        <div className="bg-[#f2f3f5] text-center rounded-xl p-8 mb-12 shadow-md">
          <p className="text-sm text-gray-600 mb-1">Puntuación del algoritmo</p>
          <p className="text-6xl font-extrabold text-[#1766f9]">{stock.score}</p>
        </div>

        {/* Datos clave */}
        <div className="grid md:grid-cols-3 gap-6 mb-12">
          {[
            { label: 'Cotización', value: stock.price },
            { label: 'PER', value: stock.per },
            { label: 'Capitalización', value: stock.marketCap },
            { label: 'EBITDA', value: stock.ebitda },
            { label: 'Rating de analistas', value: stock.rating },
          ].map((item, idx) => (
            <div
              key={idx}
              className="bg-white shadow-md rounded-xl p-5 text-center"
            >
              <p className="text-sm text-gray-400 mb-1">{item.label}</p>
              <p className="text-2xl font-semibold">{item.value}</p>
            </div>
          ))}
        </div>

        {/* Análisis del algoritmo */}
        <div className="bg-white p-6 rounded-xl shadow-md mb-10">
          <h3 className="text-xl font-semibold mb-4">Análisis del algoritmo</h3>
          <ul className="space-y-3">
            {stock.checks.map((check, idx) => (
              <li key={idx} className="text-gray-700 flex items-center">
                <span
                  className={`w-2 h-2 rounded-full mr-3 ${
                    check.valor >= 0.5 ? 'bg-[#1766f9]' : 'bg-[#F5AF12]'
                  }`}
                ></span>
                {check.texto}
              </li>
            ))}
          </ul>
        </div>

        {/* Resumen */}
        <div className="bg-white rounded-xl p-6 shadow-md">
          <h3 className="font-semibold text-lg mb-2">Resumen del algoritmo</h3>
          <p className="text-gray-700">{stock.resumen}</p>
        </div>
      </main>

      <Footer />
    </div>
  )
}
