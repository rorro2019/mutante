package com.mutante.mutante.Controller;

import com.mutante.mutante.Service.MutanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MutanteController {

    @Autowired
    MutanteService mutanteService;


    @PostMapping("/mutante")
    public ResponseEntity<Void> isMutante(@RequestBody String  entrada){
        boolean isMutant = mutanteService.isMutante(entrada);
        if (isMutant) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }




}
