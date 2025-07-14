export default function CardStock({ data, isFlipped, onFlip }) {
  if (isFlipped) return null

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

      {/* Valoración */}
      <div className="flex flex-col items-center w-full my-4">
        <div className="w-24 h-24 bg-gray-100 rounded-full flex items-center justify-center text-3xl font-bold text-blue-600">
          {data.score}
        </div>
        <p className="text-sm mt-2 text-gray-600">Valoración del algoritmo</p>
      </div>

      {/* Botón flip */}
      <button
        onClick={onFlip}
        className="mt-auto bg-[#1766f9] text-white px-4 py-2 rounded-full text-sm font-medium hover:bg-blue-700 transition"
      >
        +
      </button>
    </div>
  )
}
