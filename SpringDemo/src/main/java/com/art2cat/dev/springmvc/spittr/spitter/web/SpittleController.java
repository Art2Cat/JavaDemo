package com.art2cat.dev.springmvc.spittr.spitter.web;


import com.art2cat.dev.springmvc.spittr.spitter.data.ISpittleRepository;
import com.art2cat.dev.springmvc.spittr.spitter.data.Spittle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/spittles")
public class SpittleController {
    
    private static final String MAX_LONG_AS_STRING = String.valueOf(Long.MAX_VALUE);
    private ISpittleRepository spittleRepository;
    
    @Autowired
    public SpittleController(ISpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles";
//    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
        @RequestParam(value = "max", defaultValue = "238900") long max,
        @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }
    
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String showSpittle(@PathVariable long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
