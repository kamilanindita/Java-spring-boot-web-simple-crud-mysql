package com.springCrudMysql.spring.controller;


import com.springCrudMysql.spring.model.Buku;
import com.springCrudMysql.spring.services.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BukuController {

    private BukuService bukuService;

    @Autowired
    public void setBukuService(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @RequestMapping("/buku")
    public String index(Model model){
        model.addAttribute("buku",bukuService.ListBuku());
        return "Buku";
    }

    @RequestMapping(value = "/buku/create", method = RequestMethod.GET)
    public String baru(Model model){
        model.addAttribute("buku",new Buku());
        return "FormData";
    }

    @RequestMapping(value = "/buku/create", method = RequestMethod.POST)
    public String simpan(Model model, Buku buku){
        model.addAttribute("buku",bukuService.savaOrUpdate(buku));
        return "redirect:/buku";
    }

    @RequestMapping(value = "/buku/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("buku",bukuService.getIdBuku(id));
        return "FormData";
    }

    @RequestMapping(value = "/buku/delete/{id}")
    public String hapus(@PathVariable Integer id){
        bukuService.hapus(id);
        return "redirect:/buku";
    }
}
