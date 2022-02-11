package com.fundacioncampolina.demo.controladores;

import com.fundacioncampolina.demo.entidades.Noticia;
import com.fundacioncampolina.demo.servicios.ServicioNoticia;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/noticia")
public class ControladorNoticia {
    
    @Autowired
    private ServicioNoticia servicioNoticia;
    
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Noticia noticia, @RequestParam("file") MultipartFile imagen,
                           ModelMap m){
          
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
    
    @GetMapping("/noticiaDetalle/{id}")
    public String noticiaDetalle(Noticia noticia, ModelMap m){
        
        System.out.println(noticia.getId());
        noticia = servicioNoticia.buscarNoticiaPorId(noticia.getId());   
        

        m.put("noticia", noticia);
             
        return "/noticiaDetalle";          
    }
}
