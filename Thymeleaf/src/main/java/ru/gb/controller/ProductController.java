package ru.gb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gb.domain.Product;
import ru.gb.repository.ProductRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;

    }

    @GetMapping
    @ResponseBody
    public List<Product> findAll(Model model) {
        List<Product> products = new ArrayList<>();
      //  repository.findAllByPriceIsIn(2,4).forEach(products::add);
        repository.findAll().forEach(products::add);

        model.addAttribute("products", repository.findAll());

        return products;
      //  return "products";
    }

    @GetMapping("/all")
    public String findAll2(Model model) {
//        List<T> products = StreamSupport.stream(
//                Spliterators.spliteratorUnknownSize(repository.findAll(), Spliterator.ORDERED),
//                false
//        ).collect(Collectors.toList());
        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        model.addAttribute("products", products);

        return "products";
    }




    @GetMapping("/{id}")
    @ResponseBody
    public Product findById(@PathVariable int id) {
        return repository.findById(id).orElseThrow();
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        repository.deleteById(id);


    }
/*/
    @RequestMapping(method = RequestMethod.POST)
    public List<Product> save(@RequestBody Product product) {
        repository.save(product);

        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        return products;
    }
    /*/


    @PostMapping
    public String delete(@Valid Product product) {
       // System.out.println(string);
       repository.delete(product);
        return "products";
    }



}
