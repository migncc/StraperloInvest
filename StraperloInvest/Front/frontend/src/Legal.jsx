import Header from './components/Header'
import Footer from './components/Footer'

export default function Legal() {
  return (
    <div className="bg-[#fcfdfc] text-black font-sans">
      <Header />
      <main className="max-w-4xl mx-auto px-6 py-16">
        <h1 className="text-3xl font-bold mb-6">Aviso Legal y Descargo de Responsabilidad</h1>
        <p className="mb-4">
          Straperlo Invest es una plataforma informativa desarrollada en España con el objetivo de agilizar y simplificar el análisis de acciones mediante un algoritmo propio. Toda la información ofrecida en esta web/app tiene un carácter puramente educativo e informativo.
        </p>
        <p className="mb-4">
          Straperlo Invest no es una entidad financiera ni proporciona asesoramiento en materia de inversión. Ninguna de las métricas, puntuaciones o análisis mostrados deben interpretarse como recomendaciones de compra, venta o mantenimiento de activos financieros.
        </p>
        <p className="mb-4">
          El usuario asume la plena responsabilidad del uso que haga de la información presentada, liberando a los creadores de esta plataforma de cualquier responsabilidad derivada de decisiones de inversión basadas en dicha información.
        </p>
        <p>
          Si necesitas asesoramiento financiero, fiscal o legal adaptado a tu situación, te recomendamos consultar con un profesional cualificado y debidamente autorizado.
        </p>
      </main>
      <Footer />
    </div>
  )
}
