package com.fundacioncampolina.demo.repositorios;

import com.fundacioncampolina.demo.entidades.Noticia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RepositorioNoticia extends JpaRepository<Noticia, String>{
    
    @Query("SELECT n FROM Noticia n WHERE n.alta = 1")
    public List<Noticia> buscarNoticiasActivas();
    
    @Query("SELECT n FROM Noticia n WHERE n.id = :id")
    public Noticia buscarNoticiaPorId(@Param("id") String id);
}
