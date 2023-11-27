package com.example.pagina_status.controller;

import com.example.pagina_status.interfaceService.ICotizacionStatusService;
import com.example.pagina_status.model.CotizacionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ControllerCotizacionStatus {
    @Autowired
    private ICotizacionStatusService cotizacionStatusService;

    @GetMapping("/inicio")
    public String inicio(Model model) {
        List<CotizacionStatus> cotizacionStatus = cotizacionStatusService.listar();
        model.addAttribute("cotizacionStatus", cotizacionStatus);
        return "index";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<CotizacionStatus> cotizacion = cotizacionStatusService.listar();
        model.addAttribute("cotizacion", cotizacion);
        return "visualizacion-cotizacion";
    }

    @PostMapping("/save")
    public String save(@Validated CotizacionStatus r, Model model) {
        cotizacionStatusService.save(r);
        model.addAttribute("mensaje", "Reserva realizada correctamente");
        model.addAttribute("reserva", new CotizacionStatus());  // Esto reinicia el formulario
        return "redirect:/inicio";
    }

    @GetMapping("/cotizar")
    public String reservarServicio(Model model) {
        model.addAttribute("cotizacion", new CotizacionStatus());
        return "formulario";
    }

    @GetMapping("eliminar/{id}")
    public String delete(@PathVariable int id) {
        cotizacionStatusService.delete(id);
        return "redirect:/listar";
    }

    @GetMapping("/preguntasfrecuentes")
    public String otraPagina() {
        return "indexpreguntas";
    }

    @GetMapping("/tatuajes")
    public String otraPagina2() {
        return "indextatuajes";
    }

    @GetMapping("/piercing")
    public String otraPagina3() {
        return "indexpiercings";
    }

    @GetMapping("/productos")
    public String otraPagina4() {
        return "indexproductos";
    }
}
