import { useState, useEffect } from "react";
import axios from "axios";

export default function ListaTrabajadores() {
  const [trabajadores, setTrabajadores] = useState([]);
  const [busqueda, setBusqueda] = useState("");
  const [cargando, setCargando] = useState(true);
  const [error, setError] = useState(null);

  const API_URL = "http://localhost:8080/api/trabajadores";

  const cargarTrabajadores = async () => {
    try {
      setCargando(true);
      const response = await axios.get(API_URL);
      setTrabajadores(response.data);
      setError(null);
    } catch (err) {
      console.error("Error al cargar trabajadores:", err);
      setError("No se pudo conectar con el servidor. Verifica que el backend en Docker esté activo.");
    } finally {
      setCargando(false);
    }
  };

  useEffect(() => {
    cargarTrabajadores();
  }, []);

  // Filtro en tiempo real por DNI, nombres, apellidos o empresa contratista
  const trabajadoresFiltrados = trabajadores.filter((t) => {
    const texto = busqueda.toLowerCase();
    return (
      t.dni?.toLowerCase().includes(texto) ||
      t.nombres?.toLowerCase().includes(texto) ||
      t.apellidos?.toLowerCase().includes(texto) ||
      t.empresaContratista?.toLowerCase().includes(texto)
    );
  });

  return (
    <div className="p-6 max-w-7xl mx-auto">
      {/* Encabezado y barra de herramientas estilo Flowbite */}
      <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-4 mb-6">
        <div>
          <h1 className="text-2xl font-semibold text-heading">
            Personal y Trabajadores
          </h1>
          <p className="text-sm text-body mt-1">
            Registro de personal operativo y contratistas — Campamentos ECOSEM
          </p>
        </div>

        <div className="flex flex-col sm:flex-row items-stretch sm:items-center gap-3">
          {/* Buscador */}
          <div className="relative">
            <input
              type="text"
              value={busqueda}
              onChange={(e) => setBusqueda(e.target.value)}
              placeholder="Buscar por DNI, nombre o empresa..."
              className="bg-neutral-secondary-medium border border-default-medium text-heading text-sm rounded-base focus:ring-brand focus:border-brand block w-full sm:w-72 px-3 py-2.5 shadow-xs placeholder:text-body"
            />
          </div>

          {/* Botón Nuevo Trabajador */}
          <button
            type="button"
            className="text-white bg-brand hover:bg-brand-strong box-border border border-transparent focus:ring-4 focus:ring-brand-medium shadow-xs font-medium leading-5 rounded-base text-sm px-4 py-2.5 focus:outline-none cursor-pointer"
          >
            + Nuevo Trabajador
          </button>
        </div>
      </div>

      {/* Mensaje de error si falla la conexión */}
      {error && (
        <div className="p-4 mb-4 text-sm text-fg-danger-strong rounded-base bg-danger-soft border border-danger-subtle">
          {error}
        </div>
      )}

      {/* Tabla con estructura y variables oficiales de Flowbite */}
      <div className="relative overflow-x-auto bg-neutral-primary-soft shadow-xs rounded-base border border-default">
        <table className="w-full text-sm text-left rtl:text-right text-body">
          <thead className="text-sm text-body bg-neutral-secondary-medium border-b border-default">
            <tr>
              <th scope="col" className="px-6 py-3 font-medium">
                DNI
              </th>
              <th scope="col" className="px-6 py-3 font-medium">
                Nombres y Apellidos
              </th>
              <th scope="col" className="px-6 py-3 font-medium">
                Cargo
              </th>
              <th scope="col" className="px-6 py-3 font-medium">
                Área
              </th>
              <th scope="col" className="px-6 py-3 font-medium">
                Empresa Contratista
              </th>
              <th scope="col" className="px-6 py-3 font-medium text-right">
                Acciones
              </th>
            </tr>
          </thead>
          <tbody>
            {cargando ? (
              <tr>
                <td colSpan="6" className="px-6 py-8 text-center text-body">
                  Cargando trabajadores desde PostgreSQL...
                </td>
              </tr>
            ) : trabajadoresFiltrados.length === 0 ? (
              <tr>
                <td colSpan="6" className="px-6 py-8 text-center text-body">
                  No se encontraron trabajadores registrados.
                </td>
              </tr>
            ) : (
              trabajadoresFiltrados.map((trabajador) => (
                <tr
                  key={trabajador.id}
                  className="bg-neutral-primary border-b border-default hover:bg-neutral-secondary-soft"
                >
                  <td className="px-6 py-4 font-medium text-heading whitespace-nowrap">
                    {trabajador.dni}
                  </td>
                  <td className="px-6 py-4 font-medium text-heading">
                    {trabajador.nombres} {trabajador.apellidos}
                  </td>
                  <td className="px-6 py-4">{trabajador.cargo}</td>
                  <td className="px-6 py-4">{trabajador.area}</td>
                  <td className="px-6 py-4">
                    <span className="bg-neutral-secondary-medium text-heading text-xs font-medium px-2.5 py-0.5 rounded-base border border-default">
                      {trabajador.empresaContratista || "ECOSEM"}
                    </span>
                  </td>
                  <td className="px-6 py-4 text-right space-x-3 whitespace-nowrap">
                    <button
                      type="button"
                      className="font-medium text-fg-brand hover:underline cursor-pointer"
                    >
                      Editar
                    </button>
                    <button
                      type="button"
                      className="font-medium text-fg-danger hover:underline cursor-pointer"
                    >
                      Eliminar
                    </button>
                  </td>
                </tr>
              ))
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
}