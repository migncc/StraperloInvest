// src/hooks/useFavoritos.js
import { useEffect, useState } from 'react'

export default function useFavoritos() {
  const [favoritos, setFavoritos] = useState([])

  useEffect(() => {
    const saved = JSON.parse(localStorage.getItem('favoritos')) || []
    setFavoritos(saved)
  }, [])

  const guardar = (ticker) => {
    const updated = [...new Set([...favoritos, ticker])]
    localStorage.setItem('favoritos', JSON.stringify(updated))
    setFavoritos(updated)
  }

  const eliminar = (ticker) => {
    const updated = favoritos.filter((item) => item !== ticker)
    localStorage.setItem('favoritos', JSON.stringify(updated))
    setFavoritos(updated)
  }

  const estaGuardado = (ticker) => favoritos.includes(ticker)

  return { favoritos, guardar, eliminar, estaGuardado }
}
