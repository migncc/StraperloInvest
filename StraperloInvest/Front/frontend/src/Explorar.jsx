import Footer from "./components/Footer";
import Header from "./components/Header";

export default function Explorar() {
  return (
    <div className="min-h-screen w-full overflow-x-hidden bg-[#f7f7f7] text-black font-sans">
        <Header/>
      <h1 className="text-4xl font-bold mb-4">Explorar acciones</h1>
      <p className="text-gray-600">Aquí podrás aplicar filtros y buscar entre todas las acciones del mercado.</p>
      <Footer/>
    </div>
  )
}
