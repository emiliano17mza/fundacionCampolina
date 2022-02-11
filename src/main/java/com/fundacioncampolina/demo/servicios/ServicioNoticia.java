package com.fundacioncampolina.demo.servicios;

import com.fundacioncampolina.demo.controladores.ControladorNoticia;
import com.fundacioncampolina.demo.entidades.*;
import com.fundacioncampolina.demo.excepciones.NoticiaException;
import com.fundacioncampolina.demo.repositorios.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ServicioNoticia {

    @Autowired
    private RepositorioNoticia repositorioNoticia;

    @Transactional(readOnly = true)
    public List<Noticia> listarNoticiasActivas() {

        return repositorioNoticia.buscarNoticiasActivas();
    }

    @Transactional(readOnly = true)
    public Noticia buscarNoticiaPorId(String id) {

        return repositorioNoticia.buscarNoticiaPorId(id);
    }

    @Transactional
    public void alta(Noticia noticia, MultipartFile imagen) throws Exception {

        validar(noticia);

        if (noticia.getTexto().length() > 100) {

            String aux = noticia.getTexto().substring(0, 100).concat("...");
            noticia.setTextoCortado(aux);

        } else {

            noticia.setTextoCortado(noticia.getTexto());
        }

//        if (!imagen.isEmpty()) {
//
//            Path directorioImagen = Paths.get("src//main//resources//static//img/noticias");
//            String rutaAbsoluta = directorioImagen.toFile().getAbsolutePath();
//
//            try {
//
//                byte[] bytesImg = imagen.getBytes();
//                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
//                Files.write(rutaCompleta, bytesImg);
//                noticia.setImagen(imagen.getOriginalFilename());
//
//            } catch (IOException ex) {
//                Logger.getLogger(ControladorNoticia.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        }else{
//            
//            noticia.setImagen("null");
//        }

        noticia.setImagen(guardaImagen(imagen));
        System.out.println(noticia.getImagen());
        noticia.setAlta(true);
        noticia.setFecha(new Date());

        repositorioNoticia.save(noticia);

    }

    @Transactional
    public void cargarImagen(Noticia noticia, MultipartFile imagen){
              
        noticia.setImagen(guardaImagen(imagen));
             
        repositorioNoticia.save(noticia);
    }
    
    public String guardaImagen(MultipartFile imagen) {

        if (!imagen.isEmpty()) {

            Path directorioImagen = Paths.get("src//main//resources//static//img/noticias");
            String rutaAbsoluta = directorioImagen.toFile().getAbsolutePath();

            try {

                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                
                return imagen.getOriginalFilename();

            } catch (IOException ex) {
                Logger.getLogger(ControladorNoticia.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            return "null";
        }
        
        return null;

    }

    public void validar(Noticia noticia) throws Exception {

        int cont = 0, cont2 = 0;

        for (int i = 0; i < noticia.getTitulo().length(); i++) {

            if (noticia.getTitulo().charAt(i) == ' ') {

                cont++;
            }
        }

        for (int i = 0; i < noticia.getTexto().length(); i++) {

            if (noticia.getTexto().charAt(i) == ' ') {

                cont2++;
            }
        }

        if ((noticia.getTitulo() == null || noticia.getTitulo().isEmpty()) || noticia.getTitulo().length() == cont) {

            throw new NoticiaException("El título no puede quedar vacio.");
        }

        if ((noticia.getTexto() == null || noticia.getTexto().isEmpty()) || noticia.getTexto().length() == cont2) {

            throw new NoticiaException("El cuerpo de la noticia no puede quedar vacio.");
        }

    }

}
