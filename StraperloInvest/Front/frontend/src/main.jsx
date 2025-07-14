import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import App from './App.jsx'
import Destacadas from './Destacadas.jsx'
import './index.css'
import Legal from './Legal.jsx'
import Accion from './Accion.jsx'
import Favoritos from './Favoritos.jsx'
import ScrollToTop from './components/ScrollToTop.jsx' 
import Explorar from './Explorar.jsx'


createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
     <ScrollToTop />
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/destacadas" element={<Destacadas />} />
        <Route path="/aviso-legal" element={<Legal />} />
        <Route path="/accion/:ticker" element={<Accion />} />
        <Route path="/favoritos" element={<Favoritos />} />
        <Route path="/explorar" element={<Explorar />} />
      </Routes>
    </BrowserRouter>
  </StrictMode>
)

