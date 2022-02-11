package com.fundacioncampolina.demo.controladores;

import com.fundacioncampolina.demo.entidades.*;
import com.fundacioncampolina.demo.servicios.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Controlador {

    @Autowired
    private ServicioNoticia servicioNoticia;

    @GetMapping("/index")
    public String index() {

        return "/index";
    }
    
    // ----------------- QUIENES SOMOS -----------------

    @GetMapping("/quieneSomos")
    public String quieneSomos() {

        return "/quieneSomos";
    }

    // ----------------- SERVICIOS ----------------- 
    
    @GetMapping("/servicios")
    public String servicios() {

        return "/servicios";
    }

    @GetMapping("/traslado")
    public String traslado(ModelMap m) {
        
        SolicitudTransporte solicitud = new SolicitudTransporte();
        
        m.put("solicitud", solicitud);

        return "/traslado";
    }
    
    // ----------------- CONTACTO -----------------

    @GetMapping("/contacto")
    public String contacto() {

        return "/contacto";
    }
    
    // ----------------- NOTICIAS ----------------- 
    
    @GetMapping("/noticias")
    public String noticias(ModelMap m) {

        Noticia noticia = new Noticia();
        List<Noticia> noticias = servicioNoticia.listarNoticiasActivas();

        m.put("noticia", noticia);
        m.put("noticias", noticias);

        return "/noticias";
    }

    @PostMapping("/noticiaDetalle") //@PostMapping("/noticia/noticiaDetalle")
    public String noticiaDetalle(@RequestParam(value = "id", required = false) String id, ModelMap m) {

        Noticia noticia = servicioNoticia.buscarNoticiaPorId(id);

        m.put("noticia", noticia);

        return "/noticiaDetalle";

    }

    @PostMapping("/guardar") //@PostMapping("/noticia/guardar")
    public String guardar(@ModelAttribute Noticia noticia, @RequestParam("file") MultipartFile imagen,
            ModelMap m) {

        try {

            servicioNoticia.alta(noticia, imagen);

        } catch (Exception ex) {

            m.put("error", "ok");
            m.put("msj_error", ex.getMessage());
        }

        Noticia noti = new Noticia();
        List<Noticia> noticias = servicioNoticia.listarNoticiasActivas();

        m.put("noticia", noti);
        m.put("noticias", noticias);

        return "/noticias";
    }

    @PostMapping("/cargarImagen")
    public String cargarImagen(@RequestParam(value = "id", required = false) String id, ModelMap m,
            @RequestParam("file") MultipartFile imagen) {

        Noticia noticia = servicioNoticia.buscarNoticiaPorId(id);

        servicioNoticia.cargarImagen(noticia, imagen);

        return "redirect:/noticias";
    }

}
