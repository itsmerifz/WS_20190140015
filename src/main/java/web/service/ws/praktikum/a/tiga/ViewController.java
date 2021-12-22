/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.service.ws.praktikum.a.tiga;

import java.util.*;
import javax.servlet.http.*;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {
    List<String> buffer = new ArrayList<>();
        
    public static ArrayList<List<String>> tabel = new ArrayList<>();
    public static ArrayList<List<String>> tabel2 = new ArrayList<>();
    static{
        tabel.add(Arrays.asList("Kacang", "1000"));
        tabel.add(Arrays.asList("Permen", "2000"));
        tabel.add(Arrays.asList("Telur", "3000"));
        tabel.add(Arrays.asList("Pulpen", "4000"));
        tabel.add(Arrays.asList("Sabun", "5000"));
        tabel.add(Arrays.asList("Penghapus", "5500"));
        
    }
    
    @RequestMapping("/tabel")
    public String getTabel(Model mod, HttpServletRequest cari){
        
        String nama_brg = cari.getParameter("barangCari");
        String nama_found = "";
        tabel2.clear();
        

        for(int i = 0; i < tabel.size(); i++){
            buffer = tabel.get(i);
            if(buffer.toString().contains(nama_brg)){
                tabel2.add(tabel.get(i));
            } else {
                nama_found = "Barang tidak ditemukan";
            }
        }
        
        
        mod.addAttribute("tabelKirim", tabel);
        mod.addAttribute("tabelUbah", tabel2);
        mod.addAttribute("barangdicari", nama_found);
        return "viewTabel";
    }
    
    @RequestMapping("/hapus")
    public String deleteData(Model mod, HttpServletRequest params){
        String nama_hps = params.getParameter("barangHapus");
        String nama_found = "";
        
        if(tabel2.isEmpty()){
            tabel2.addAll(tabel);
        }
        
        for(int i = 0; i < tabel.size(); i++){
            buffer = tabel.get(i);
            if(buffer.toString().contains(nama_hps)){
                tabel2.remove(buffer);
            } else {
                nama_found = "Barang tidak ditemukan";
            }
        }
        
        mod.addAttribute("tabelKirim", tabel);
        mod.addAttribute("tabelUbah", tabel2);
        mod.addAttribute("barangdicari", nama_found);
        return "viewTabel";
    }
    
    @RequestMapping("/data")
    @ResponseBody
    public HashMap<String, Object> getData(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("aa", "bb");
        map.put("tt", 12);
        map.put("bb", 19.38);
        
        return map;
    }
    
    @CrossOrigin
    @GetMapping(value="/data/pribadi", produces= {
        MediaType.APPLICATION_JSON_VALUE,     
    })
    @ResponseBody
    public HashMap<String, Object> getXML(){
        
//        ArrayList<String> data = new ArrayList<>();
//        data.add("Merpati");
//        data.add("Elang");
//        data.add("Beo");
          
        HashMap<String,Object> data = new HashMap<>();
        data.put("nama","Muhamad Arief");
        data.put("asal","Manado");
        data.put("umur",20);
        return data;
    }
}
