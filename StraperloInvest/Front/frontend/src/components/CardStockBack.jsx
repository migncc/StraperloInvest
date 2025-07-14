import { useNavigate } from 'react-router-dom'

export default function CardStockBack({ data, onFlipBack }) {
  const navigate = useNavigate()

  return (
    <div className="bg-white rounded-2xl drop-shadow-[0_12px_30px_rgba(0,0,0,0.12)] p-6 flex flex-col items-start gap-3 transition-transform duration-500">
      {/* Posición + nombre */}
      <div className="flex items-center gap-2">
        <div className="text-lg font-semibold text-gray-500">{data.rank}.</div>
        <div>
          <p className="font-semibold text-lg">{data.name}</p>
          <p className="text-sm text-gray-500">{data.ticker}</p>
        </div>
      </div>

      {/* Datos destacados */}
      <div className="text-sm text-gray-700 mt-4 space-y-2 w-full">
        <p><span className="font-semibold">Sector:</span> {data.sector}</p>
        <p><span className="font-semibold">PER:</span> {data.per}</p>
        <p><span className="font-semibold">Valor actual:</span> {data.price}</p>
        <p><span className="font-semibold">Capitalización:</span> {data.marketCap}</p>
      </div>

      {/* Botones */}
<div className="flex justify-between items-end w-full mt-auto pt-4">
<button
  onClick={onFlipBack}
   className="btn-contraste"
>
  -
</button>
  <button
    onClick={() => navigate(`/accion/${data.ticker}`)}
    className="text-sm font-medium text-[#1766f9] hover:underline transition"
  >
    Ver análisis completo
  </button>
</div>

    </div>
  )
}
