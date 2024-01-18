package com.cedula.ups;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CedulaController {

    @Autowired
    private CedulaRepository cedulaRepository;

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, String>> guardarCedula(@RequestBody Cedula cedula) {
        cedulaRepository.save(cedula);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Datos guardados");
        return ResponseEntity.ok(response);
    }

    
    @GetMapping("/provincia/{numeroCedula}")
    public ResponseEntity<Map<String, String>> getProvincia(@PathVariable String numeroCedula) {
        String provincia = determineProvincia(numeroCedula);
        Map<String, String> response = new HashMap<>();
        response.put("provincia", provincia);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/cedulas")
    public ResponseEntity<List<Cedula>> getAllCedulas() {
        List<Cedula> cedulas = cedulaRepository.findAll();
        return ResponseEntity.ok(cedulas);
    }



    private String determineProvincia(String numeroCedula) {
        // Logic to determine province based on cédula number
        // For example, the first two digits of the cédula number might represent the province
        // Return the province name based on those digits
        // This is a simplified example; adjust the logic as per your requirements
        if (numeroCedula != null && numeroCedula.length() >= 2) {
            String provinceCode = numeroCedula.substring(0, 2);
            switch (provinceCode) {
                case "01": return "Azuay";
                case "02": return "Bolívar";
                case "03": return "Cañar";
                case "04": return "Carchi";
                case "05": return "Cotopaxi";
                case "06": return "Chimborazo";
                case "07": return "El Oro";
                case "08": return "Esmeraldas";
                case "09": return "Guayas";
                case "10": return "Imbabura";
                case "11": return "Loja";
                case "12": return "Los Ríos";
                case "13": return "Manabí";
                case "14": return "Morona Santiago";
                case "15": return "Napo";
                case "16": return "Pastaza";
                case "17": return "Pichincha";
                case "18": return "Tungurahua";
                case "19": return "Zamora Chinchipe";
                case "20": return "Galápagos";
                case "21": return "Sucumbíos";
                case "22": return "Orellana";
                case "23": return "Santo Domingo de los Tsáchilas";
                case "24": return "Santa Elena";
                default: return "Unknown Province";
            }
        } else {
            return "Invalid Cédula Number";
        }
    }
}
