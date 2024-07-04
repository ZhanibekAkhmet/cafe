package com.coffee.cafe.controller;

import com.coffee.cafe.dto.RoleDto;
import com.coffee.cafe.dto.UserDto;
import com.coffee.cafe.dto.UserFormDto;
import com.coffee.cafe.entity.User;
import com.coffee.cafe.service.RoleService;
import com.coffee.cafe.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getUsers(Model model) {
        List<UserDto> users = userService.findAll()
                .stream()
                .map(UserDto::toDto)
                .toList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        List<RoleDto> roles = roleService.findAll()
                .stream()
                .map(RoleDto::fromEntity)
                .toList();
        model.addAttribute("user", UserFormDto.toUserFormDto(user));
        model.addAttribute("roles", roles);
        return "user/form";
    }

    @GetMapping("/new")
    public String createUser(Model model) {
        List<RoleDto> roles = roleService.findAll()
                .stream()
                .map(RoleDto::fromEntity)
                .toList();
        model.addAttribute("user", UserFormDto.toUserFormDto(new User()));
        model.addAttribute("roles", roles);
        return "user/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute UserFormDto user) {
        userService.save(user.toEntity());
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
