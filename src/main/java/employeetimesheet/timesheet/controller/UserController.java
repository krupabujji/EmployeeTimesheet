package employeetimesheet.timesheet.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employeetimesheet.timesheet.dto.UserDTO;
import employeetimesheet.timesheet.entity.User;
import employeetimesheet.timesheet.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAll() { return userService.findAll(); }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) { return userService.findById(id); }

    @PostMapping("/postuser")
    public ResponseEntity<User> create(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.create(dto));
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody UserDTO dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

