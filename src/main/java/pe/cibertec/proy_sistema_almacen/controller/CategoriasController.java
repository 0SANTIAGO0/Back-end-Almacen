package pe.cibertec.proy_sistema_almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.proy_sistema_almacen.dto.CategoriaCrearDto;
import pe.cibertec.proy_sistema_almacen.entity.Categoria;
import pe.cibertec.proy_sistema_almacen.repository.CategoriasRepository;
import pe.cibertec.proy_sistema_almacen.service.MaintenanceCategoriasService;

import java.util.Optional;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
/*
    @Autowired
    MaintenanceCategoriasService service;

    @Autowired
    CategoriasRepository repo;

    @GetMapping("/listar")
    public String listar(Model model) throws Exception {
        model.addAttribute("categorias", service.listarCategorias());
        return "categorias-listar";
    }

    @GetMapping("/registrar")
    public String crear(Model model) {
        model.addAttribute("categoria", new CategoriaCrearDto(null, "", "", "Activo"));
        return "categorias-crear";
    }

    @PostMapping("/registrar")
    public String guardar(@ModelAttribute("categoria") Categoria dto) throws Exception {
        service.agregarCategoria(dto);
        return "redirect:/categorias/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Optional<Categoria> optional = repo.findById(id);
        if (optional.isPresent()) {
            Categoria cat = optional.get();
            model.addAttribute("categoria", new CategoriaCrearDto(
                    cat.getIdCategoria(), cat.getNombreCategoria(), cat.getDescripcion(), cat.getEstado()
            ));
            return "categorias-editar";
        }
        return "redirect:/categorias/listar";
    }

    @PostMapping("/editar")
    public String actualizar(@ModelAttribute("categoria") Categoria dto) throws Exception {
        service.actualizarCategoria(dto);
        return "redirect:/categorias/listar";
    }

    @PostMapping("/borrarCategoria")
    public String borrar(@RequestParam("idCategoria") int id) throws Exception {
        service.borrarCategoriaId(id);
        return "redirect:/categorias/listar";
    }

 */
}
