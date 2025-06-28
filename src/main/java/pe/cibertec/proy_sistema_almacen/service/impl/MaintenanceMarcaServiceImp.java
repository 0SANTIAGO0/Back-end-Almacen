package pe.cibertec.proy_sistema_almacen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.proy_sistema_almacen.dto.MarcaRequestDto;
import pe.cibertec.proy_sistema_almacen.dto.MarcaResponseDto;
import pe.cibertec.proy_sistema_almacen.entity.Marca;
import pe.cibertec.proy_sistema_almacen.repository.MarcaRepository;
import pe.cibertec.proy_sistema_almacen.service.MaintenanceMarcaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaintenanceMarcaServiceImp implements MaintenanceMarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    // Helper method para convertir Entidad a Response DTO
    private MarcaResponseDto convertToResponseDto(Marca marca) {
        return new MarcaResponseDto(
                marca.getIdMarca(),
                marca.getNombreMarca(),
                marca.getPaisOrigen(),
                marca.getEstado()
        );
    }

    // Helper method para convertir Request DTO a Entidad
    private Marca convertToEntity(MarcaRequestDto dto) {
        Marca marca = new Marca();
        marca.setIdMarca(dto.idMarca()); // idMarca puede ser null para creacion
        marca.setNombreMarca(dto.nombreMarca());
        marca.setPaisOrigen(dto.paisOrigen());
        marca.setEstado(dto.estado());
        return marca;
    }

    @Override
    public List<MarcaResponseDto> listarMarcas() {
        // CORRECCIÓN CLAVE AQUÍ: Ahora se listan TODAS las marcas, incluyendo las "Inactivas".
        // El filtrado por estado se manejará completamente en el frontend (MarcaTable.tsx).
        List<Marca> marcas = marcaRepository.findAll();

        // Convertir la lista de entidades a una lista de DTOs de respuesta
        return marcas.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MarcaResponseDto> buscarMarcaPorId(Integer id) {
        return marcaRepository.findById(id)
                .map(this::convertToResponseDto); // Convertir a DTO si se encuentra
    }

    @Override
    public MarcaResponseDto guardarMarca(MarcaRequestDto marcaDto) {
        Marca marcaEntidad = convertToEntity(marcaDto);
        // Al guardar (crear o actualizar), aseguramos que el estado sea "Activo" por defecto si no se especifica
        if (marcaEntidad.getEstado() == null || marcaEntidad.getEstado().isEmpty()) {
            marcaEntidad.setEstado("Activo");
        }
        Marca savedMarca = marcaRepository.save(marcaEntidad);
        return convertToResponseDto(savedMarca); // Devolver el DTO de la marca guardada
    }

    @Override
    public MarcaResponseDto actualizarMarca(Integer id, MarcaRequestDto marcaDto) {
        // Buscar la marca existente por ID
        Optional<Marca> existingMarcaOptional = marcaRepository.findById(id);

        if (existingMarcaOptional.isEmpty()) {
            // Manejar caso donde la marca no existe, puedes lanzar una excepcion customizada
            throw new RuntimeException("Marca con ID " + id + " no encontrada para actualizar.");
        }

        Marca existingMarca = existingMarcaOptional.get();

        // Actualizar los campos de la entidad existente con los datos del DTO de solicitud
        existingMarca.setNombreMarca(marcaDto.nombreMarca());
        existingMarca.setPaisOrigen(marcaDto.paisOrigen());
        // Solo actualiza el estado si viene en la peticion y es diferente
        if (marcaDto.estado() != null && !marcaDto.estado().isEmpty()) {
            existingMarca.setEstado(marcaDto.estado());
        }

        Marca updatedMarca = marcaRepository.save(existingMarca);
        return convertToResponseDto(updatedMarca); // Devolver el DTO de la marca actualizada
    }

    @Override
    public void eliminarMarca(Integer id) {
        // Implementacion de borrado logico (soft delete)
        Optional<Marca> marcaOptional = marcaRepository.findById(id);
        if (marcaOptional.isPresent()) {
            Marca marca = marcaOptional.get();
            marca.setEstado("Inactivo"); // Cambiar estado a "Inactivo"
            marcaRepository.save(marca); // Guardar el cambio de estado
        } else {
            System.out.println("Marca con ID " + id + " no encontrada para eliminacion logica.");
        }
    }
}
