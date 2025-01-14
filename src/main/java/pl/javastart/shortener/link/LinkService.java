package pl.javastart.shortener.link;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.javastart.shortener.link.dto.LinkCreateDto;
import pl.javastart.shortener.link.dto.LinkDto;

import java.util.Optional;

@Service
public class LinkService {
    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Transactional
    public LinkDto shortenLink(LinkCreateDto link) {
        String randomId;
        do {
            randomId = UUIDRandomIdGenerator.generateId();
        } while (linkRepository.existsById(randomId));
        Link newLink = new Link(randomId, link.getName(), link.getTargetUrl());
        Link savedLink = linkRepository.save(newLink);
        return LinkDtoMapper.map(savedLink);
    }

    @Transactional
    public Optional<LinkDto> incrementVisitsById(String id) {
        Optional<Link> link = linkRepository.findById(id);
        link.ifPresent(l -> l.setVisits(l.getVisits() + 1));
        return link.map(LinkDtoMapper::map);
    }

    public Optional<LinkDto> findLinkById(String id) {
        return linkRepository.findById(id)
                .map(LinkDtoMapper::map);
    }
}
