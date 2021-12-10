package ru.ibs.happynes.services.implementations;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.ibs.happynes.dto.*;
import ru.ibs.happynes.entities.*;
import ru.ibs.happynes.repositories.*;
import ru.ibs.happynes.services.intefaces.ProjectCardService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProjectCardServiceImpl implements ProjectCardService {

    private final ProjectCardRepository projectCardRepository;
    private final EmployeeListRepository employeeListRepository;
    private final ProjectTypeRepository projectTypeRepository;
    private final ProjectTechnologiesRepository projectTechnologiesRepository;
    private final TechnologiesDictionaryRepository technologiesDictionaryRepository;
    private final ProjectAreaDictionaryRepository projectAreaDictionaryRepository;
    private final FirmDictionaryRepository firmDictionaryRepository;
    private final ModelMapper mapper;
    

    @Override
    public void deleteTable(Long id) {
        projectCardRepository.deleteById(id);
    }

    @Override
    public void updateTable(MainCardDto dto) {
        Long firstId = dto.getId();
        ProjectCard projectCard = projectCardRepository.findProjectCardById(firstId);

        ProjectTeam projectTeam = mapper.map(dto.getProjectTeamCardDto(), ProjectTeam.class);
        ProjectManagement projectManagement = mapper.map(dto.getProjectManagementDto(), ProjectManagement.class);

        RecruitingCard recruitingCard = mapper.map(dto.getRecruitingCardDto(), RecruitingCard.class);
        List<Employee> list = new ArrayList<>();
        recruitingCard.setEmployeesLists(list);
        List<EmployeeListDto> employeeListDto = dto.getRecruitingCardDto().getEmployeeListDtoList();
        employeeListDto.forEach(e -> {
            Employee employee = mapper.map(e, Employee.class);
            employeeListRepository.save(employee);
            recruitingCard.getEmployeesLists().add(employee);
        });

//        List<ProjectType> type = new ArrayList<>();
//        projectCard.setProjectType(type);
//        List<String> dtoType = dto.getProjectTypeDto();
//        ProjectCard finalProjectCard1 = projectCard;
//        dtoType.forEach(e -> {
//            ProjectType projectType = new ProjectType(e);
//            projectTypeRepository.save(projectType);
//            projectCard.getProjectType().add(projectType);
//        });

        List<String> projectTypeDto = dto.getProjectTypeDto();
        projectCard.setProjectType(new ArrayList<>());
        int count = 0;
        while (count < projectTypeDto.size()){
            ProjectType projectType = new ProjectType(projectTypeDto.get(count++));
            projectCard.getProjectType().add(projectType);
        }

//        List<ProjectTechnologies> technologies = new ArrayList<>();
//        projectCard.setProjectTechnologies(technologies);
//        List<String> dtoTechnologies = dto.getTechnologies();
//        ProjectCard finalProjectCard = projectCard;
//        dtoTechnologies.forEach(t -> {
//            ProjectTechnologies projectTechnologies = new ProjectTechnologies(t);
//            TechnologiesDictionary technologiesDictionary = new TechnologiesDictionary(t);
//            technologiesDictionaryRepository.save(technologiesDictionary);
//            projectTechnologiesRepository.save(projectTechnologies);
//            finalProjectCard.getProjectTechnologies().add(projectTechnologies);
//        });

        List<String> technologies = dto.getTechnologies();
        projectCard.setProjectTechnologies(new ArrayList<>());
        count = 0;
        while (count < technologies.size()){
            ProjectTechnologies projectTechnologies = new ProjectTechnologies(technologies.get(count++));
            projectCard.getProjectTechnologies().add(projectTechnologies);
        }

        projectTeam.setId(firstId);
        projectManagement.setId(firstId);
        recruitingCard.setId(firstId);

        projectCard = mapper.map(dto.getProjectCardDto(), ProjectCard.class);

        ProjectAreaDictionary projectAreaDictionary = new ProjectAreaDictionary(projectCard.getProjectArea());
        projectAreaDictionaryRepository.save(projectAreaDictionary);

        FirmDictionary firmDictionary = new FirmDictionary(projectCard.getFirm());
        firmDictionaryRepository.save(firmDictionary);

        projectCard.setProjectManagement(projectManagement);
        projectCard.setProjectTeam(projectTeam);
        projectCard.setRecruitingCard(recruitingCard);
//        projectCard.setProjectType(type);
//        projectCard.setProjectTechnologies(technologies);

        projectCard.setId(firstId);

        projectCardRepository.save(projectCard);

    }

    @Override
    public Long createTable(MainCardDto dto) {
        ProjectCard projectCard = mapper.map(dto.getProjectCardDto(), ProjectCard.class);

        ProjectAreaDictionary projectAreaDictionary = new ProjectAreaDictionary(projectCard.getProjectArea());
        projectAreaDictionaryRepository.save(projectAreaDictionary);

        FirmDictionary firmDictionary = new FirmDictionary(projectCard.getFirm());
        firmDictionaryRepository.save(firmDictionary);

        ProjectTeam projectTeam = mapper.map(dto.getProjectTeamCardDto(), ProjectTeam.class);
        projectCard.setProjectTeam(projectTeam);

        ProjectManagement projectManagement = mapper.map(dto.getProjectManagementDto(), ProjectManagement.class);
        projectCard.setProjectManagement(projectManagement);

        RecruitingCard recruitingCard = mapper.map(dto.getRecruitingCardDto(), RecruitingCard.class);
        List<Employee> list = new ArrayList<>();
        recruitingCard.setEmployeesLists(list);
        List<EmployeeListDto> employeeListDto = dto.getRecruitingCardDto().getEmployeeListDtoList();
        employeeListDto.forEach(e -> {
            Employee employee = mapper.map(e, Employee.class);

            recruitingCard.getEmployeesLists().add(employee);
        });
        projectCard.setRecruitingCard(recruitingCard);

        List<ProjectType> type = new ArrayList<>();
        projectCard.setProjectType(type);
        List<String> dtoType = dto.getProjectTypeDto();
        dtoType.forEach(e -> {
            ProjectType projectType = new ProjectType(e);
            projectCard.getProjectType().add(projectType);
        });

        List<ProjectTechnologies> technologies = new ArrayList<>();
        projectCard.setProjectTechnologies(technologies);
        List<String> dtoTechnologies = dto.getTechnologies();
        dtoTechnologies.forEach(t -> {
            ProjectTechnologies projectTechnologies = new ProjectTechnologies(t);
            TechnologiesDictionary technologiesDictionary = new TechnologiesDictionary(t);
            technologiesDictionaryRepository.save(technologiesDictionary);
            projectCard.getProjectTechnologies().add(projectTechnologies);
        });

        projectCardRepository.save(projectCard);

        return projectCard.getId();
    }

    @Override
    public List<ProjectCard> findAll() {
        return projectCardRepository.findAll();
    }



    @Override
    public List<MainCardDto> findTable(Long id) {
        MainCardDto mainCardDto = new MainCardDto();

        ProjectCard projectCard = projectCardRepository.findProjectCardById(id);
        Long cardId = projectCard.getId();

        ProjectCardDto projectCardDto = mapper.map(projectCard, ProjectCardDto.class);
        ProjectTeamCardDto projectTeamCardDto = mapper.map(projectCard.getProjectTeam(), ProjectTeamCardDto.class);
        ProjectManagementDto managementDto = mapper.map(projectCard.getProjectManagement(), ProjectManagementDto.class);
        RecruitingCardDto recruitingCardDto = mapper.map(projectCard.getRecruitingCard(), RecruitingCardDto.class);

        List<String> type = new ArrayList<>();
        projectCard.getProjectType()
                .forEach(t -> type.add(t.getText()));

        List<String> technologies = new ArrayList<>();
        projectCard.getProjectTechnologies()
                .forEach(t -> technologies.add(t.getTechnologies()));

        List<EmployeeListDto> employeeLists = new ArrayList<>();
        projectCard.getRecruitingCard().getEmployeesLists()
                .forEach(e -> employeeLists.add(mapper.map(e, EmployeeListDto.class)));

        mainCardDto.setId(cardId);
        mainCardDto.setProjectCardDto(projectCardDto);
        mainCardDto.setProjectTeamCardDto(projectTeamCardDto);
        mainCardDto.setProjectManagementDto(managementDto);
        mainCardDto.setRecruitingCardDto(recruitingCardDto);
        mainCardDto.setProjectTypeDto(type);
        mainCardDto.setTechnologies(technologies);
        mainCardDto.getRecruitingCardDto().setEmployeeListDtoList(employeeLists);

        return Collections.singletonList(mainCardDto);
    }

    @Override
    public List<String> findTechnologiesDictionary(){
        List<TechnologiesDictionary> technologiesDictionaryList = technologiesDictionaryRepository.findAll();
        List<String> result = new ArrayList<>();
        technologiesDictionaryList.forEach(t -> result.add(t.getTechnology()));
        return result;
    }

    @Override
    public List<String> findProjectAreaDictionary(){
        List<ProjectAreaDictionary> projectAreaDictionaryList = projectAreaDictionaryRepository.findAll();
        List<String> result = new ArrayList<>();
        projectAreaDictionaryList.forEach(t -> result.add(t.getArea()));
        return result;
    }

    @Override
    public List<String> findFirmDictionary(){
        List<FirmDictionary> firmDictionaries = firmDictionaryRepository.findAll();
        List<String> result = new ArrayList<>();
        firmDictionaries.forEach(t -> result.add(t.getFirm()));
        return result;
    }

}
