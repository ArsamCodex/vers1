package webshopjavaaproach.vers1.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webshopjavaaproach.vers1.models.Product;
import webshopjavaaproach.vers1.service.ProductService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@ResponseBody

public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/show")
    @ResponseBody
    public String getAll(Model model) {

        List<Product> products = productService.getAll();
        model.addAttribute("products", products);

        return "cart";

    }

    @RequestMapping("/home/addToCart/{id}")
    public String addToCart(@PathVariable int id, Model model, HttpSession session) {

        Product p = productService.findById(id);

        if (session.getAttribute("prodsess") == null) {

            Map<String, Integer> cart = new HashMap<>();
            cart.put(p.getName(), p.getPrice());
            session.setAttribute("prodsess", cart);
            model.addAttribute("cart", cart);
            Integer sum = 0;
            for (Integer val : cart.values()) {
                sum += val;
            }
            model.addAttribute("sum", sum);
        } else {

            Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("prodsess");
            cart.put(p.getName(), p.getPrice());
            session.setAttribute("prodsess", cart);
            model.addAttribute("cart", cart);
            Integer sum = 0;
            for (Integer val : cart.values()) {
                sum += val;
            }
            model.addAttribute("sum", sum);

        }

        return "cart";

    }

    @RequestMapping("/cart")
    public String cart(HttpSession session, Model model) {

        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("prodsess");
        model.addAttribute("cart", cart);
        Integer sum = 0;
        for (Integer val : cart.values()) {
            sum += val;
        }
        model.addAttribute("sum", sum);
        return "show-cart";
    }

    @RequestMapping("/delete")
    public String deleteFromCart(@RequestParam("key") String key, HttpSession session, Model model) {

        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("prodsess");
        cart.remove(key);
        Integer sum = 0;
        for (Integer val : cart.values()) {
            sum += val;
        }
        session.setAttribute("prodsess", cart);
        model.addAttribute("cart", cart);
        model.addAttribute("sum", sum);
        return "redirect:/cart";
    }


    @RequestMapping("/searchProduct")
    public String search(@RequestParam("name") String name,Model model){


        Product product = productService.findByName(name);

        model.addAttribute("product",product);

        return "product-info";



    }

}