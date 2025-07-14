import './App.css'
import { Link } from 'react-router-dom'
import Header from './components/Header'
import tarjetasHero from './assets/recursos/tarjeta-hero.png'
import tarjetasStock from './assets/recursos/tarjetasStocknf.png'
import Footer from './components/Footer'
import Favoritos from './Favoritos'




import { Search, Star } from 'lucide-react' // Usamos íconos planos de lucide

export default function App() {
  return (
    <div className="min-h-screen w-full overflow-x-hidden bg-[#f7f7f7] text-black font-sans">
<Header />
      {/* Contenido inicial */}
<main className="w-full bg-[#fcfdfc] px-6 lg:px-16 py-20">
  <div className="max-w-7xl mx-auto flex flex-col-reverse lg:flex-row items-center justify-between gap-16">
    
    {/* Bloque izquierdo (texto) */}
    <div className="w-full lg:w-1/2">
      <div className="flex flex-col items-start text-left">
        <h1 className="text-8xl font-extrabold leading-tight mb-7 tracking-tight typing">
          <span className="block typing-line">Analiza</span>
          <span className="block typing-line">Entiende</span>
          <span className="block typing-line">Invierte</span>
        </h1>
        <button className="mt-4 bg-[#1766f9] text-white px-6 py-3 rounded-full text-base font-medium hover:bg-blue-700 transition">
         Descubre cómo funciona
        </button>
      </div>
    </div>

   {/* Hero tarjetas animadas */}
<div className="w-full max-w-xl flex justify-center">
  <img
    src={tarjetasHero}
    alt="Tarjetas destacadas"
    className="w-full max-w-[900px] h-auto object-contain animate-float-slow drop-shadow-[0_8px_20px_rgba(0,0,0,0.4)]"
  />
</div>


  </div>
</main>

{/* Sección 2 – Información clave algorítmica */}
<section className="w-full bg-[#0b0d10] text-white py-24">
  <div className="max-w-7xl mx-auto px-6 lg:px-16 flex flex-col lg:flex-row items-center justify-between gap-16">
    
    {/* Sección 2 tarjetas animadas */}
<div className="w-full max-w-xl flex justify-center">
  <img
    src={tarjetasStock}
    alt="Tarjetas análisis"
    className="w-full h-auto object-contain animate-float-slow drop-shadow-[0_12px_20px_rgba(23,102,249,0.20)] "
  />
</div>

    {/* Texto derecha */}
    <div className="w-full lg:w-1/2 text-right">
      <h2 className="text-4xl md:text-5xl font-extrabold leading-tight mb-6">
        Tu aliado algorítmico <br />
        para invertir con cabeza
      </h2>
      <p className="text-lg text-gray-300 mb-6">
        Analiza acciones con datos objetivos, métricas claras y un motor imparcial.
        <br />
        No damos consejos. Solo te damos poder.
      </p>
<Link
  to="/destacadas"
  className="mt-4 bg-[#1766f9] text-white px-6 py-3 rounded-full text-base font-medium hover:bg-blue-700 transition"
>
  Ver destacadas
</Link>

    </div>
  </div>
</section>
<Footer />

    </div>
  )
}
