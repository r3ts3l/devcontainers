package codesolution.net.devcontainers.service;

import codesolution.net.devcontainers.model.Profile;
import codesolution.net.devcontainers.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfileService {
    private ProfileRepository profileRepository;

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

}
