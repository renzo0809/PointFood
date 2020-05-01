package com.example.controller;


import com.example.entity.Orden;
import com.example.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {
    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public ResponseEntity<List<Orden>> listOrden()
    {
        List<Orden> ordenes=ordenService.listAllOrden();
        if(ordenes.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(ordenes);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> getOrden(@PathVariable("id") Long id)
    {
        Orden orden=ordenService.getOrden(id);
        if(orden==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orden);
    }

    @PostMapping
    public ResponseEntity<Orden> createOrden(@Valid @RequestBody Orden orden,
                                             BindingResult result)
    {
        if(result.hasErrors())
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Orden ordenCreate=ordenService.createOrden(orden);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orden> updateOrden(@PathVariable Long id,
                                             @RequestBody Orden orden)
    {
        orden.setId(id);
        Orden ordenDB= ordenService.updateOrden(orden);
        if(ordenDB==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ordenDB);
    }

    @DeleteMapping
    public ResponseEntity<Orden> deleteOrden(@PathVariable Long id)
    {
        Orden ordenDB=ordenService.getOrden(id);
        if(ordenDB==null)
        {
            return ResponseEntity.notFound().build();
        }
        ordenService.deleteOrden(id);
        return ResponseEntity.ok(ordenDB);

    }

}
