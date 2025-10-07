package com.example.users.web;

import com.example.users.domain.User;
import com.example.users.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserRepository repo;

    @BeforeEach
    void init() {
        var existing = new User();
        existing.setId(1L);
        existing.setFullName("John Smith");
        existing.setEmail("john@example.com");
        given(repo.findAll()).willReturn(List.of(existing));
    }

    @Test
    void getAll_returnsList() throws Exception {
        mvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("john@example.com"));
    }

    @Test
    void create_persistsAndReturns201() throws Exception {
        // Capture saved entity and give back with an id
        given(repo.save(argThat(hasNameAndEmail("Jane Doe", "jane@example.com"))))
                .willAnswer(inv -> {
                    User u = inv.getArgument(0);
                    u.setId(99L);
                    return u;
                });

        mvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"fullName":"Jane Doe","email":"jane@example.com"}
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(99))
                .andExpect(jsonPath("$.email").value("jane@example.com"));

        then(repo).should().save(argThat(hasNameAndEmail("Jane Doe", "jane@example.com")));
    }

    private static ArgumentMatcher<User> hasNameAndEmail(String name, String email) {
        return u -> u != null && name.equals(u.getFullName()) && email.equals(u.getEmail());
    }
}