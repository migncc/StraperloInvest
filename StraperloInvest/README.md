# 📈 StraperloInvest

**StraperloInvest** es una herramienta de análisis de acciones y carteras de inversión. Su objetivo es automatizar evaluaciones que normalmente se hacen de forma manual, aplicando una lógica basada en 5 pasos claros y objetivos.

> ⚠️ Este software no ofrece recomendaciones financieras. Solo realiza análisis técnicos y fundamentales basados en criterios definidos por el usuario.

---

## 🚀 Objetivo del proyecto

Crear una aplicación modular que permita:

- Evaluar acciones individuales mediante 5 criterios objetivos
- Analizar carteras de inversión según distribución geográfica, sectorial y riesgo
- Visualizar los resultados en forma de checklist, tablas y gráficos
- Automatizar la obtención de datos desde APIs financieras (ej: Yahoo Finance)

---

## 📊 Evaluación de acciones (5 Checks)

Cada acción es evaluada según los siguientes parámetros:

1. **Gráfico de 5 años**: ¿Está en máximos históricos?
2. **Market Cap vs. Enterprise Value**: ¿Buena salud de deuda?
3. **Deuda / EBITDA**: ¿Finanzas sólidas?
4. **PER (Price to Earnings Ratio)**: ¿Está sobrevalorada?
5. **Opiniones de analistas y resultados recientes**: ¿Qué dice el consenso?

---

## 🔧 Tecnologías utilizadas

- **Java 17+**
- **Maven**
- **IntelliJ IDEA**
- [ ] Spring Boot (futuro)
- [ ] API financiera (Yahoo Finance, Finnhub, etc.)
- [ ] Motor de gráficos (más adelante)

---

## 📁 Estructura inicial del proyecto

StraperloInvest/
├── src/
│ └── main/
│ └── java/com/straperlo/evaluador/
│ ├── model/ # Clases de dominio (Stock, Enums, Resultados)
│ ├── logic/ # Evaluador de acciones
│ ├── mock/ # Datos de prueba simulados
│ └── Main.java # Clase principal para pruebas
└── pom.xml # Archivo de configuración Maven

---

## 🧠 Filosofía del proyecto

- **Centrado en la lógica**: no avanzamos a interfaz o persistencia sin validar la lógica de negocio
- **Mantenible y modular**: código limpio, desacoplado, orientado a crecimiento
- **Inspirado por neobancos**: diseño limpio, profesional y directo
- **Marca personal**: forma parte del ecosistema de proyectos bajo *Straperlo*

---

## ✅ Estado actual

- [x] Repositorio inicial creado
- [x] Proyecto Maven estructurado
- [x] Lógica de evaluación modelada (en desarrollo)
- [ ] Integración con APIs externas
- [ ] Análisis de carteras
- [ ] Interfaz visual o chatbot

---

## 📌 Licencia

Este proyecto es de uso personal y educativo. No constituye asesoramiento financiero. Distribución bajo licencia MIT (a definir si se abre al público).

---

## ✍️ Autor

**Miguel Ignacio Cantos** – 2025  
[Tu enlace GitHub o LinkedIn opcional]

