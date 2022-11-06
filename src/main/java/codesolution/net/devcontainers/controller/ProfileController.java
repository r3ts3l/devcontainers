package codesolution.net.devcontainers.controller;

import codesolution.net.devcontainers.model.Profile;
import codesolution.net.devcontainers.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {
    private ProfileService profileService;

    @GetMapping
    Iterable<Profile> findAll() {
        return profileService.findAll();
    }
}
