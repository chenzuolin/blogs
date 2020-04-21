package com.blog.controller;

import com.blog.domain.Type;
import com.blog.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author 神州战神
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TypeService typeService;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 3,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,
                        Model model){
        logger.info("===============>"+typeService.listType(pageable).toString()+"<==================");
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(){
        return "admin/type-input";
    }

    @PostMapping("/types")
    public String postType(Type type, RedirectAttributes redirectAttributes){
        logger.info("++++++++++++++++++++++++++++++++++++++++002");
        Type byName = typeService.findByName(type.getName());
        if(!StringUtils.isEmpty(byName)){
            redirectAttributes.addFlashAttribute("msg","该名称已被占用！！！");
            return "redirect:/admin/types";
        }
        Type t = typeService.saveType(type);
        if(t == null){
            redirectAttributes.addFlashAttribute("msg","新增失败！！！");
        }else{
            redirectAttributes.addFlashAttribute("msg","新增成功！！！");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/type-input";
    }

    @PostMapping("/types/{id}")
    public String editType(Type type,@PathVariable Long id,RedirectAttributes redirectAttributes){
        Type byName = typeService.findByName(type.getName());
        logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++001");
        if(!StringUtils.isEmpty(byName)){
            redirectAttributes.addFlashAttribute("msg","该名称已被占用！！！");
            return "redirect:/admin/types";
        }
        Type t = typeService.updateType(id,type);
        if(t == null){
            redirectAttributes.addFlashAttribute("msg","更新失败！！！");
        }else{
            redirectAttributes.addFlashAttribute("msg","更新成功！！！");
        }
        return "redirect:/admin/types";
    }
    @GetMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id,RedirectAttributes redirectAttributes){
        typeService.deleteType(id);
        redirectAttributes.addFlashAttribute("msg","删除成功！！！");
        return "redirect:/admin/types";
    }
}
