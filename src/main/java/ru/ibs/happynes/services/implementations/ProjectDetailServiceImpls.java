package ru.ibs.happynes.services.implementations;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.ibs.happynes.dto.FilterSearchDto;
import ru.ibs.happynes.entities.ProjectCard;
import ru.ibs.happynes.repositories.ProjectCardRepository;
import ru.ibs.happynes.services.intefaces.ProjectDetailService;

import java.text.ParseException;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProjectDetailServiceImpls implements ProjectDetailService {

    private final ProjectCardRepository projectCardRepository;

    private final List<Function<String, List<ProjectCard>>> allTablesFinder;

    public ProjectDetailServiceImpls(ProjectCardRepository projectCardRepository){
        this.projectCardRepository = projectCardRepository;

        allTablesFinder = Arrays.asList(
                param -> {
                    try {
                        return Collections.singletonList(projectCardRepository.findProjectCardById(Long.parseLong(param)));
                    }catch (Exception e){
                        return Collections.emptyList();
                    }
                },
                projectCardRepository::findAllByProjectName,
                projectCardRepository::findAllByCreatorName,
                projectCardRepository::findAllByFirm,
                projectCardRepository::findAllByProjectStage,
                projectCardRepository::findAllByProjectArea,
                param -> {
                    try {
                        return projectCardRepository.findAllByCardCreateDate(Date.from(Instant.parse(param)));
                    } catch (Exception e) {
                        return Collections.emptyList();
                    }
                });
    }

    public List<ProjectCard> fAllInDate(Date bDate, Date aDate){

        List<ProjectCard> list = projectCardRepository.findAll();
        List<ProjectCard> result = new ArrayList<>();
        list
                .forEach(t -> {
                    try {
                        if (dateChecker(t.getCardCreateDate(), bDate, aDate))
                            result.add(t);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                });
        return result;
    }

    private Boolean dateChecker(Date date, Date before, Date after) throws ParseException {
        return  (date.before(after) && date.after(before));
    }

    @Override
    public List<ProjectCard> findAllByParam(String param) {
        List<ProjectCard> list = new ArrayList<>();
        for (Function<String, List<ProjectCard>> projectCardFinder : allTablesFinder) {
            List<ProjectCard> result = projectCardFinder.apply(param);
            if (!CollectionUtils.isEmpty(result))
                list.addAll(result.stream().filter(
                        v -> list.stream().noneMatch(v2 -> v2.getId().equals(v.getId()))
                ).collect(Collectors.toList()));
        }

        return list;
    }

    @Override
    public List<ProjectCard> filter(FilterSearchDto filterSearchDto) {

        List<ProjectCard> list = projectCardRepository.findAll();

        if (filterSearchDto.getProjectStage() != null)
            list = list.stream().filter(
                    v -> filterSearchDto.getProjectStage().equals(v.getProjectStage())
            ).collect(Collectors.toList());

        if (filterSearchDto.getFirm() != null)
            list = list.stream().filter(
                    v -> filterSearchDto.getFirm().equals(v.getFirm())
            ).collect(Collectors.toList());

        if (filterSearchDto.getCreatorName() != null)
            list = list.stream().filter(
                    v -> filterSearchDto.getCreatorName().equals(v.getCreatorName())
            ).collect(Collectors.toList());

        if (filterSearchDto.getDateBefore() != null && filterSearchDto.getDateAfter() != null){
            List<ProjectCard> compare = fAllInDate(filterSearchDto.getDateBefore(), filterSearchDto.getDateAfter());
            Set<ProjectCard> result = list.stream()
                    .distinct()
                    .filter(compare::contains)
                    .collect(Collectors.toSet());
            list.clear();
            list.addAll(result);
        }

        return list;
    }

    @Override
    public List<ProjectCard> sortCardAsc(String sortType) {
        return projectCardRepository.findAll(Sort.by(Sort.Direction.ASC, sortType));
    }

    @Override
    public List<ProjectCard> sortCardDesc(String sortType) {
        return projectCardRepository.findAll(Sort.by(Sort.Direction.DESC, sortType));
    }

}
