import logo from '../assets/recursos/logo.png'
import { Search, Star } from 'lucide-react'
import { Link } from 'react-router-dom'

export default function Header() {
  return (
    <header className="w-full flex justify-between items-center px-10 py-6 bg-[#fcfdfc]">
      {/* Bloque izquierda: logo + navegación */}
      <div className="flex items-center gap-10">
        <Link to="/" className="flex items-center gap-2">
          <img src={logo} alt="Straperlo Logo" className="h-10 w-auto" />
          <span className="font-bold text-xl">StraperloInvest</span>
        </Link>

        {/* Enlaces navegación */}
        <nav className="hidden lg:flex gap-6 text-sm font-medium text-gray-700">
          <Link to="/destacadas" className="hover:text-[#1766f9] transition">Destacadas</Link>
          <Link to="/explorar" className="hover:text-[#1766f9] transition">Explorar</Link>
        </nav>
      </div>

      {/* Bloque derecha: buscador + iconos + login */}
      <div className="flex items-center gap-4 flex-wrap">
        {/* Buscador */}
        <div className="relative">
          <Search className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400 w-4 h-4" />
          <input
            type="text"
            placeholder="Busca una acción..."
            className="pl-10 pr-4 py-2 rounded-full border border-gray-300 focus:outline-none focus:ring-2 focus:ring-[#1766f9] bg-white transition text-sm w-[230px] sm:w-[280px] md:w-[320px]"
          />
        </div>

        {/* Favoritos */}
        <Link to="/favoritos">
          <Star className="text-black w-5 h-5" fill="black" />
        </Link>

        {/* Login / Registro */}
        <div className="flex items-center gap-4">
          <button className="text-sm text-gray-700 font-medium hover:text-[#1766f9] transition">
            Iniciar sesión
          </button>
          <button className="bg-[#1766f9] text-white px-5 py-2 rounded-full font-medium text-sm hover:bg-blue-700 transition">
            Registrarse
          </button>
        </div>
      </div>
    </header>
  )
}
