//package by.pvt.core.controller;
//
//import by.pvt.core.domain.Visits;
//import by.pvt.core.dto.VisitCreateRequest;
//import by.pvt.core.service.VisitService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
//@RequestMapping("client")
//public class ClientMVCController
//    {
//
//    private final VisitService visitService;
//
//    @ModelAttribute
//    public void initAttribute(Model model)
//        {
//        model.addAttribute("visitCreateRequest", new VisitCreateRequest());
//        }
//
//    @Autowired
//    public ClientMVCController(VisitService visitService)
//        {
//        this.visitService = visitService;
//        }
//
//    @GetMapping("/client")
//    public String clientPage()
//        {
//        var visits = visitService.getAll();
//        return "client/main";
//        }
//
//    @GetMapping("test") //задаем url
//    public ModelAndView getAll()
//        {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("client/test"); //задаем файл, который будет отображаться по этому url
//        return modelAndView;
//        }
//
//    @RequestMapping("/client/hw")
//    public String home(Model model)
//        {
//        model.addAttribute("title", "Hello World!");
//        return "home";
//        }
//
//    @PostMapping(value = "/addvisits")
//    public ModelAndView addVisit(VisitCreateRequest visitCreate, BindingResult bindingResult, Model model)
//        {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("client/visit");
//        if (bindingResult.hasErrors())
//            {
//            modelAndView.addObject("error", bindingResult.getAllErrors().get(0));
//            modelAndView.setViewName("error");
//            return modelAndView;
//            }
//        model.addAttribute("Visits", visitCreate);
//        var visitResponse = visitService.addVisit(visitCreate);
//        modelAndView.addObject("visitResponse", visitResponse);
//        return modelAndView;
//        }
//
//    @GetMapping(value = "/main")
//    public ModelAndView getAllVisit()
//        {
//        var visits = visitService.getAll();
//        ModelAndView modelAndView = new ModelAndView();
//        ModelMap modelMap = new ModelMap();
//        Map<String, Collection<Visits>> visitMap = new HashMap<>();
//        visitMap.put("visits", visits);
//        modelMap.addAllAttributes(visitMap);
////        modelAndView.addObject("VisitObject", modelMap);
//        modelAndView.addAllObjects(modelMap);
//        modelAndView.setViewName("client/visit");
//        return modelAndView;
//        }
//
//    @PostMapping("/client/update")
//    public ModelAndView updateVisit(VisitCreateRequest visits)
//        {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("client/visit");
//        var visit = visitService.update(visits);
//        modelAndView.addObject("visitResponse", visit);
//        return modelAndView;
//        }
//@GetMapping("/client/getbyid")
//public ModelAndView getbyId(Long id)
//    {
//    ModelAndView modelAndView = new ModelAndView();
//    modelAndView.setViewName("client/visit");
//    var visit = visitService.getByID(id);
//    modelAndView.addObject("visitResponse", visit);
//    return modelAndView;
//    }
//
//
//    @PostMapping("/client/delete")
//    public ModelAndView deleteVisit(long id)
//        {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("client/visit");
//        visitService.delByID(id);
//        return modelAndView;
//        }
//    }
