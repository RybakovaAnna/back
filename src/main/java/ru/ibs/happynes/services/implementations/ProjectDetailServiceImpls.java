//package ru.ibs.happynes.services.implementations;
//
//import liquibase.pro.packaged.T;
//import org.hibernate.Criteria;
//import org.hibernate.criterion.Criterion;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//import ru.ibs.happynes.dto.FilterSearchDto;
//import ru.ibs.happynes.entities.ProjectCard;
//import ru.ibs.happynes.repositories.ProjectCardRepository;
//import ru.ibs.happynes.services.intefaces.ProjectDetailService;
//
//import javax.persistence.EntityManager;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.text.ParseException;
//import java.time.Instant;
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//@Service
//public class ProjectDetailServiceImpls implements ProjectDetailService {
//
//    private final ProjectCardRepository projectCardRepository;
//    private final List<Function<String, List<ProjectCard>>> allTablesFinder;
//    private final EntityManager entityManager;
//
//    public ProjectDetailServiceImpls(ProjectCardRepository projectCardRepository, EntityManager entityManager) {
//        this.projectCardRepository = projectCardRepository;
//        this.entityManager = entityManager;
//        allTablesFinder = Arrays.asList(
//                param -> {
//                    try {
//                        return Collections.singletonList(projectCardRepository.findProjectCardById(Long.parseLong(param)));
//                    } catch (Exception e) {
//                        return Collections.emptyList();
//                    }
//                },
//                projectCardRepository::findAllByProjectName,
//                projectCardRepository::findAllByCreatorName,
//                projectCardRepository::findAllByFirm,
//                projectCardRepository::findAllByProjectStage,
//                projectCardRepository::findAllByProjectArea,
//                param -> {
//                    try {
//                        return projectCardRepository.findAllByCardCreateDate(Date.from(Instant.parse(param)));
//                    } catch (Exception e) {
//                        return Collections.emptyList();
//                    }
//                });
//    }
//
//    private Boolean dateChecker(Date date, Date before, Date after) throws ParseException {
//        return (date.before(after) && date.after(before));
//    }
//
//    @Override
//    public List<ProjectCard> findAllByParam(String param) {
//        List<ProjectCard> list = new ArrayList<>();
//        for (Function<String, List<ProjectCard>> projectCardFinder : allTablesFinder) {
//            List<ProjectCard> result = projectCardFinder.apply(param);
//            if (!CollectionUtils.isEmpty(result))
//                list.addAll(result.stream().filter(
//                        v -> list.stream().noneMatch(v2 -> v2.getId().equals(v.getId()))
//                ).collect(Collectors.toList()));
//        }
//
//        return list;
//    }
//
//
//    @Override
//    public List<ProjectCard> filter(FilterSearchDto filterSearchDto) {
//
//        String creatorName = filterSearchDto.getCreatorName();
//        String stage = filterSearchDto.getProjectStage();
//        String firm = filterSearchDto.getFirm();
//        Date dateBefore = filterSearchDto.getDateBefore();
//        Date dateAfter = filterSearchDto.getDateAfter();
//
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<ProjectCard> cq = cb.createQuery(ProjectCard.class);
//
//        Root<ProjectCard> projectCardRoot = cq.from(ProjectCard.class);
//        List<Predicate> predicates = new ArrayList<>();
//
//        if (creatorName != null)
//            predicates.add(cb.equal(projectCardRoot.get("creatorName"), creatorName));
//        if (stage != null)
//            predicates.add(cb.equal(projectCardRoot.get("projectStage"), stage));
//        if (firm != null)
//            predicates.add(cb.equal(projectCardRoot.get("firm"), firm));
//
//        cq.where(predicates.toArray(new Predicate[0]));
//
//        List<ProjectCard> filtered = entityManager.createQuery(cq).getResultList();
//
//        if (filterSearchDto.getDateBefore() == null && filterSearchDto.getDateAfter() == null)
//            return filtered;
//        else {
//            List<ProjectCard> result = filtered.stream()
//                    .filter(t -> {
//                        try {
//                            return dateChecker(t.getCardCreateDate(), dateAfter, dateBefore);
//                        } catch (ParseException e) {
//                            return false;
//                        }
//                    }).collect(Collectors.toList());
//            return result;
//        }
//    }
//
//    @Override
//    public List<ProjectCard> sortCardAsc(String sortType) {
//        return projectCardRepository.findAll(Sort.by(Sort.Direction.ASC, sortType));
//    }
//
//    @Override
//    public List<ProjectCard> sortCardDesc(String sortType) {
//        return projectCardRepository.findAll(Sort.by(Sort.Direction.DESC, sortType));
//    }
//
//}
