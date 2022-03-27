package com.ipiecoles.java.eval.th330.controller;

import com.ipiecoles.java.eval.th330.model.Artist;
import com.ipiecoles.java.eval.th330.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @RequestMapping(
            method = RequestMethod.GET,
            value  = "/artists/{id}"
    )
    public ModelAndView GetArtistById (final ModelMap modelMap,@PathVariable Long id){
        Artist artist = artistService.findById(id);
        ModelAndView modelAndView = new ModelAndView("detailArtist");
        modelAndView.addObject("artists",artist);
        return modelAndView ;

    }

    @RequestMapping(
            method = RequestMethod.GET,
            value  = "/artists?name={name}"
    )
    public ModelAndView GetArtistByName (final ModelMap modelMap,@PathVariable String name) {

        Page<Artist> artist = artistService.findByNameLikeIgnoreCase(name,
                1, 10,  "name", "name");
        ModelAndView modelAndView = new ModelAndView("listeArtists");
        modelAndView.addObject("artists", artist);
        return modelAndView;

    }
}