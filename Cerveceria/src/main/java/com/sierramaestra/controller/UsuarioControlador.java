package com.sierramaestra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sierramaestra.model.Usuario;
import com.sierramaestra.service.UsuarioServicio;

@Controller
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio servicio;

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    @GetMapping("/usuarios")
    public String listarUsuarios(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(required = false) String legajo,
                                 Model model) {
        int pageSize = 10; // Tamaño de página
        long totalUsuarios = servicio.contarUsuarios(legajo);
        int totalPages = (int) Math.ceil((double) totalUsuarios / pageSize);
        
        List<Usuario> usuarios = servicio.listarUsuarios(page, pageSize, legajo);
        
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("legajo", legajo);
        
        return "usuarios"; // Nombre de la vista
    }
    
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    @GetMapping("/usuarios/nuevo")
    public String crearUsuarioFormulario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "crear_usuario";
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "crear_usuario";
        }
    
        // Aquí se confía en el valor recibido desde el formulario, sin cambiar el estado de 'activo'.
        servicio.guardarUsuario(usuario);
    
        return "redirect:/usuarios";
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    @GetMapping("/usuarios/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", servicio.obtenerUsuarioPorId(id));
        return "editar_usuario";
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    @PostMapping("/usuarios/{id}")
    public String actualizarUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario, Model model) {
        Usuario usuarioExistente = servicio.obtenerUsuarioPorId(id);
        usuarioExistente.setId(id);
        usuarioExistente.setLegajo(usuario.getLegajo());
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellido(usuario.getApellido());
        usuarioExistente.setDni(usuario.getDni());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setRol(usuario.getRol());
        usuarioExistente.setLegajo(usuario.getLegajo());
        usuarioExistente.setContrasena(usuario.getContrasena());
        usuarioExistente.setActivo(usuario.isActivo());

        servicio.actualizarUsuario(usuarioExistente);
        return "redirect:/usuarios";
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    @GetMapping("/usuarios/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        servicio.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    // Nuevo método para mostrar el menú principal
    @GetMapping("/menu-principal")
    public String mostrarMenuPrincipal() {
        return "menu-principal"; // Retorna el archivo menu-principal.html
    }
}

