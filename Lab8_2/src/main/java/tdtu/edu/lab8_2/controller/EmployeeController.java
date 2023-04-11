package tdtu.edu.lab8_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tdtu.edu.lab8_2.model.Employee;
import tdtu.edu.lab8_2.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String homepage(Model model, @RequestParam(defaultValue = "1")int page){
        return findPaginated(1, model);
    }

    @RequestMapping(value = "/employees/add", method = RequestMethod.GET)
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "add";
    }
    @RequestMapping(value = "/employees/add", method = RequestMethod.POST)
    public String addEmployeePost(@ModelAttribute("employee")Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping("/employees/page/{pageNo}")
    public String findPaginated(@PathVariable("pageNo")int pageNo, Model model){
        int pageSize = 5;
        Page<Employee> page = employeeService.findPage(pageNo, pageSize);
        List<Employee> employeeList = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalEmployees", page.getTotalElements());
        model.addAttribute("employees", employeeList);
        return "index";
    }

    @RequestMapping(value = "/employees/delete", method = RequestMethod.POST)
    public String deleteEmployee(@RequestParam("employeeId") long id){
        System.out.println(id);
        employeeService.removeEmployeeById(id);
        return "redirect:/employees";
    }
    @RequestMapping(value = "/employees/edit", method = RequestMethod.POST)
    public String update(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }
}
