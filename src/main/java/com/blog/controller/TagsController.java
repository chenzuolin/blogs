package com.blog.controller;

import com.blog.domain.Tag;
import com.blog.service.TagService;
import lombok.extern.slf4j.Slf4j;
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

import java.util.logging.Logger;

/**
 * @author chenzuolin
 * @Description
 * @date 2020/4/21 14:46
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class TagsController {


    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    public String tagsList(@PageableDefault(size = 2,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,
                           Model model){
        model.addAttribute("page",tagService.listTag(pageable));
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String tagsInput(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }

    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));
        return "admin/tags-input";
    }

    @PostMapping("/tags")
    public String post(Tag tag, RedirectAttributes attributes) {
        Tag tag1 = tagService.getTagByName(tag.getName());
        log.info("=======>"+tag1);
        if (!StringUtils.isEmpty(tag1)){
            attributes.addFlashAttribute("message","不能添加重复的标签");
            return "redirect:/admin/tags";
        }
        Tag t = tagService.saveTag(tag);
        if (t == null) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags/{id}")
    public String editPost( Tag tag,@PathVariable Long id, RedirectAttributes attributes) {
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (!StringUtils.isEmpty(tag1)){
            attributes.addFlashAttribute("message","不能添加重复的标签");
            return "redirect:/admin/tags";
        }
        Tag t = tagService.updateTag(id,tag);
        if (t == null) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/tags";
    }


}
