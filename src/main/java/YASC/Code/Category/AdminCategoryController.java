//package YASC.Code.Category;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import YASC.Code.User.CateRepository;
//import YASC.Code.User.Category;
//
//@Controller
//@RequestMapping("/admin/categories")
//public class AdminCategoryController {
//    @Autowired
//    private CateRepository categoryRepo;
//
//    @GetMapping
//    public String index(Model model) {
//        List<Category> categories = categoryRepo.findAllByOrderBySortingAsc();
//        model.addAttribute("categories", categories);
//        return "admin/categories/index";
//    }
//
//    @GetMapping("/add")
//    public String add(Category category) {
//        return "admin/categories/add";
//    }
//
//    @PostMapping("/add")
//    public String add(@Valid Category category, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "admin/categories/add";
//        }
//        redirectAttributes.addFlashAttribute("message", "Category added");
//        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
//        
//        String slug = category.getName().toLowerCase().replace(" ", "-");
//        Category categoryExists = categoryRepo.findByName(category.getName());
//
//        if (categoryExists != null) {
//            redirectAttributes.addFlashAttribute("message", "Category exists, choose another");
//            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
//            redirectAttributes.addFlashAttribute("categoryInfo", category);
//        } else {
//            category.setSlug(slug);
//            category.setSorting(100);
//            categoryRepo.save(category);
//        }
//        return "redirect:/admin/categories/add";
//    }
//}
