package com.sierramaestra.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sierramaestra.model.Barril;
import com.sierramaestra.service.BarrileServicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Controller
public class BarrilControlador {

    @Autowired
    @Qualifier("barrilServicioImlp")
    private BarrileServicio servicio;

    @GetMapping("/barril")
    public String listarBarriles(
            @RequestParam(value = "estado", required = false) String estado,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            Model modelo) {

        // Se crea el objeto Pageable
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

        // Se recupera la página de barriles
        Page<Barril> barrilesPage;
        if (estado == null || estado.isEmpty()) {
            barrilesPage = servicio.listarTodosLosBarriles(pageable);
        } else {
            barrilesPage = servicio.listarBarrilesPorEstado(estado, pageable);
        }

        modelo.addAttribute("barrilesPage", barrilesPage);
        modelo.addAttribute("estados", new String[]{"Cargado", "Alquilado", "Devuelto", "Limpio", "Inactivo"});
        return "tabla_barril";  // Asegúrate de que esta vista sea la correcta
    }

    @GetMapping("/barril/nuevo")
    public String crearBarrilFormulario(Model modelo) {
        Barril barril = new Barril();
        modelo.addAttribute("barril", barril);
        modelo.addAttribute("estados", new String[]{"Cargado", "Alquilado", "Devuelto", "Limpio", "Inactivo"});
        return "crear_barril";  // Asegúrate de que esta vista sea la correcta
    }

    @PostMapping("/barril")
    public String guardarBarril(@ModelAttribute("barril") Barril barril) {
        servicio.guardarBarril(barril);
        return "redirect:/barril";
    }

    @GetMapping("/barril/editarBarril/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("barril", servicio.obtenerBarrilPorId(id));
        modelo.addAttribute("estados", new String[]{"Cargado", "Alquilado", "Devuelto", "Limpio", "Inactivo"});
        return "editar_barril";  // Asegúrate de que esta vista sea la correcta
    }

    @PostMapping("/barril/{id}")
    public String actualizarBarril(@PathVariable Long id, @ModelAttribute("barril") Barril barril) {
        Barril barrilExistente = servicio.obtenerBarrilPorId(id);
        barrilExistente.setId(id);
        barrilExistente.setLitros(barril.getLitros());
        barrilExistente.setEstado(barril.getEstado());
        barrilExistente.setNotas(barril.getNotas());
        servicio.actualizarBarril(barrilExistente);
        return "redirect:/barril";
    }

    @GetMapping("/barril/{id}")
    public String eliminarBarril(@PathVariable Long id) {
        servicio.eliminarBarril(id);
        return "redirect:/barril";
    }

    @GetMapping("/barril/showBarril/{id}")
    public String obtenerBarrilPorId(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("barril", servicio.obtenerBarrilPorId(id));
        return "show_barril";  // Asegúrate de que esta vista sea la correcta
    }

    @GetMapping("/barril/limpios")
    public String listarBarrilesLimpios(Model modelo) {
        List<Barril> barrilesLimpios = servicio.listarBarrilesPorEstadoLimpio();
        modelo.addAttribute("barrilesLimpios", barrilesLimpios);
        return "crear_lote";  // Asegúrate de que esta vista sea la correcta
    }
}