package com.htlimst.lieferrex.controller.gericht;

import com.htlimst.lieferrex.model.Angestellter;
import com.htlimst.lieferrex.model.Gericht;
import com.htlimst.lieferrex.model.Mandant;
import com.htlimst.lieferrex.service.gericht.GerichtService;
import com.htlimst.lieferrex.service.mandant.MandantService;
import com.htlimst.lieferrex.service.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dashboard/gerichte")
public class GerichtController {

    private GerichtService gerichtService;
    private MandantService mandantService;

    @Autowired
    public GerichtController(GerichtService gerichtService, MandantService mandantService){
        this.gerichtService = gerichtService;
        this.mandantService = mandantService;
    }

    @GetMapping
    public String showDashboardGerichte(Model model) {

        // Gerichte mit Status 1 oder 2
        List<Gericht> gerichteList = gerichtService.getGerichtByStatus();
        // Gerichte mit Status 0
        List<Gericht> gerichteListStatusZero = gerichtService.getGerichtByStatusZero();
        model.addAttribute("gerichteList", gerichteList);
        model.addAttribute("gerichteListStatusZero", gerichteListStatusZero);
        // ---------Grad nur zum testen für das erste Gericht !---------
        Optional<Gericht> gerichte = gerichtService.getGerichtById(1L);
        model.addAttribute("gericht", gerichte);
        //---------------------------------------------------------------
        return "dashboard/gerichte.html";
    }
    @GetMapping("/{id}")
    public String showModalGericht(@PathVariable("id") Long id, Model model){
        Optional<Gericht> gericht = gerichtService.getGerichtById(id);
        model.addAttribute("gericht", gericht);
        return "edit";
    }

    @PostMapping("/save")
    public String saveGericht(Gericht gericht){
        Mandant foundMandant = mandantService.mandantMitId(1L);
        gericht.setMandant(foundMandant);
        gerichtService.save(gericht);
        return "redirect:/dashboard/gerichte";
    }

}