import { useEffect, useState } from 'react';
import axios from 'axios';

export function ListaTrabajadores() {
  const [trabajadores, setTrabajadores] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/trabajadores')
      .then(response => setTrabajadores(response.data))
      .catch(error => console.error("Hubo un error conectando con Spring Boot:", error));
  }, []);

  return (
    <div className="p-6 bg-gray-50 min-h-screen">
      {/* <div className="max-w-6xl mx-auto bg-white p-8 rounded-lg shadow-md border border-gray-200">
        
        <div className="flex justify-between items-center mb-6">
          <h2 className="text-2xl font-bold text-gray-800">Gestión de Personal</h2>
          <button className="bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded font-medium transition-colors">
          Nuevo Trabajador
          </button>
        </div>

        <div className="overflow-x-auto">
          <table className="w-full text-left border-collapse">
            <thead>
              <tr className="bg-gray-100 text-gray-600 text-sm uppercase tracking-wider border-b-2 border-gray-300">
                <th className="p-4 font-semibold">ID</th>
                <th className="p-4 font-semibold">DNI</th>
                <th className="p-4 font-semibold">Nombres</th>
                <th className="p-4 font-semibold">Apellidos</th>
                <th className="p-4 font-semibold">Cargo</th>
                <th className="p-4 font-semibold">Área</th>
              </tr>
            </thead>
            <tbody className="text-gray-700 text-sm">
              {trabajadores.map((trabajador, index) => (
                <tr 
                  key={trabajador.id} 
                  className={`border-b border-gray-200 hover:bg-blue-50 transition-colors ${index % 2 === 0 ? 'bg-white' : 'bg-gray-50'}`}
                >
                  <td className="p-4 font-medium text-gray-900">{trabajador.id}</td>
                  <td className="p-4">{trabajador.dni}</td>
                  <td className="p-4">{trabajador.nombres}</td>
                  <td className="p-4">{trabajador.apellidos}</td>
                  <td className="p-4">
                    <span className="bg-blue-100 text-blue-800 px-2 py-1 rounded-full text-xs font-semibold">
                      {trabajador.cargo}
                    </span>
                  </td>
                  <td className="p-4 font-medium">{trabajador.area}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div> */}

      <div className="p-6">
      <div className="relative overflow-x-auto bg-neutral-primary-soft shadow-xs rounded-base border border-default">
        <table className="w-full text-sm text-left rtl:text-right text-body">
          <thead className="text-sm text-body bg-neutral-secondary-medium border-b border-default-medium">
            <tr>
              <th scope="col" className="px-6 py-3 font-medium">DNI</th>
              <th scope="col" className="px-6 py-3 font-medium">Nombres</th>
              <th scope="col" className="px-6 py-3 font-medium">Apellidos</th>
              <th scope="col" className="px-6 py-3 font-medium">Cargo</th>
              <th scope="col" className="px-6 py-3 font-medium">Área</th>
              <th scope="col" className="px-6 py-3 font-medium">Empresa Contratista</th>
              {/* <th scope="col" className="px-6 py-3 font-medium">
                <span className="sr-only">Acciones</span>
              </th> */}
            </tr>
          </thead>
          <tbody>
            <tr className="bg-neutral-primary-soft border-b border-default hover:bg-neutral-secondary-medium">
              <th
                scope="row"
                className="px-6 py-4 font-medium text-heading whitespace-nowrap"
              >
                71234567
              </th>
              <td className="px-6 py-4">{}</td>
              <td className="px-6 py-4">Mendoza Quispe</td>
              <td className="px-6 py-4">Operador de Maquinaria</td>
              <td className="px-6 py-4">Operaciones</td>
              <td className="px-6 py-4">ECOSEM Huaraucaca</td>
              <td className="px-6 py-4 text-right">
                <a
                  href="#"
                  className="font-medium text-fg-brand hover:underline"
                >
                  Editar
                </a>
              </td>
            </tr>
            <tr className="bg-neutral-primary-soft border-b border-default hover:bg-neutral-secondary-medium">
              <th
                scope="row"
                className="px-6 py-4 font-medium text-heading whitespace-nowrap"
              >
                74859612
              </th>
              <td className="px-6 py-4">Luis Fernando</td>
              <td className="px-6 py-4">Huamán Torres</td>
              <td className="px-6 py-4">Técnico Mecánico</td>
              <td className="px-6 py-4">Mantenimiento</td>
              <td className="px-6 py-4">Contratas Mineras SAC</td>
              <td className="px-6 py-4 text-right">
                <a
                  href="#"
                  className="font-medium text-fg-brand hover:underline"
                >
                  Editar
                </a>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    </div>
    
    
  );
}