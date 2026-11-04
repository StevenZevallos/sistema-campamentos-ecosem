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
      <div className="max-w-6xl mx-auto bg-white p-8 rounded-lg shadow-md border border-gray-200">
        
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
      </div>
    </div>
  );
}