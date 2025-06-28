package pe.cibertec.proy_sistema_almacen.service;

import pe.cibertec.proy_sistema_almacen.dto.MarcaRequestDto;
import pe.cibertec.proy_sistema_almacen.dto.MarcaResponseDto;

import java.util.List;
import java.util.Optional;

public interface MaintenanceMarcaService {
    List<MarcaResponseDto> listarMarcas(); // Ahora devuelve DTOs de respuesta
    Optional<MarcaResponseDto> buscarMarcaPorId(Integer id); // Ahora devuelve DTO de respuesta
    MarcaResponseDto guardarMarca(MarcaRequestDto marcaDto); // Recibe DTO de solicitud
    MarcaResponseDto actualizarMarca(Integer id, MarcaRequestDto marcaDto); // Recibe DTO de solicitud
    void eliminarMarca(Integer id); // Sin cambios en el tipo de retorno
}
