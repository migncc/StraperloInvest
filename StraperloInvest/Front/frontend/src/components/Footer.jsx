export default function Footer() {
  return (
    <footer className="bg-[#0b0d10] text-white px-6 lg:px-16 py-10 text-sm">
      <div className="max-w-7xl mx-auto flex flex-col md:flex-row justify-between items-start gap-6">
        {/* Columna 1 */}
        <div className="flex flex-col gap-2">
          <h2 className="font-semibold text-base mb-1">StraperloInvest</h2>
<p className="text-gray-400 max-w-xs">
  Plataforma informativa y educativa. No damos consejos de inversión.  
  <a href="/aviso-legal" className="text-[#F5AF12] underline hover:text-white ml-1">Leer más</a>
</p>

        </div>

        {/* Columna 2 */}
        <div className="flex flex-col gap-2">
          <h3 className="font-semibold text-sm mb-1">Legal</h3>
          <a href="/aviso-legal" className="text-gray-400 hover:text-white transition">Aviso legal</a>
          <a href="#" className="text-gray-400 hover:text-white transition">Términos y condiciones</a>
          <a href="#" className="text-gray-400 hover:text-white transition">Política de privacidad</a>
        </div>

        {/* Columna 3 */}
        <div className="flex flex-col gap-2">
          <h3 className="font-semibold text-sm mb-1">Contacto</h3>
          <p className="text-gray-400">info@straperloinvest.com</p>
          <p className="text-gray-400">Madrid, España</p>
        </div>
      </div>

      <div className="text-center text-gray-500 mt-10 text-xs">
        © {new Date().getFullYear()} StraperloInvest. Todos los derechos reservados.
      </div>
    </footer>
  )
}
