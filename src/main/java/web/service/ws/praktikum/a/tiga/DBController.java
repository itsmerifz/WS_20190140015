/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.service.ws.praktikum.a.tiga;

import java.util.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ACER
 */
@Controller
public class DBController {
    
    @CrossOrigin
    @RequestMapping(value="/alattulis", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseBody
    public List<Alattulis> getAlatTulis(){
        List<Alattulis> alatTulis = new ArrayList<>();
        AlattulisJpaController con = new AlattulisJpaController();
        
        try{
            alatTulis = con.findAlattulisEntities();
        }catch(Exception ex){
            
        }
        
        return alatTulis;
    }
    
}
