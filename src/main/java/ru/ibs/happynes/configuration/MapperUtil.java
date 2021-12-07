package ru.ibs.happynes.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ibs.happynes.dto.*;
import ru.ibs.happynes.entities.*;

import javax.persistence.Entity;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class MapperUtil {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true);

        mapper.createTypeMap(MainCardDto.class, Entity.class);

        mapper.typeMap(ProjectCard.class, ProjectCardDto.class)
                .addMappings(m -> {
                    m.map(ProjectCard::getFinishingDate, ProjectCardDto::setFinishingDate);
                    m.map(ProjectCard::getProjectStage, ProjectCardDto::setProjectStage);
                    m.map(ProjectCard::getIsDocumentRequired, ProjectCardDto::setIsDocumentRequired);
                    m.map(ProjectCard::getCreatorName, ProjectCardDto::setCreatorName);
                    m.map(ProjectCard::getFirm, ProjectCardDto::setFirm);
                    m.map(ProjectCard::getProjectName, ProjectCardDto::setProjectName);
                    m.map(ProjectCard::getCardCreateDate, ProjectCardDto::setCardCreateDate);
                    m.map(ProjectCard::getProjectArea, ProjectCardDto::setProjectArea);
                    m.map(ProjectCard::getFunctionalDirection, ProjectCardDto::setFunctionalDirection);
                    m.map(ProjectCard::getStatus, ProjectCardDto::setStatus);
                });

        mapper.typeMap(ProjectManagement.class, ProjectManagementDto.class)
                .addMappings(m -> {
                    m.map(ProjectManagement::getOfficeLocation, ProjectManagementDto::setOfficeLocation);
                    m.map(ProjectManagement::getIsTimeChange, ProjectManagementDto::setIsTimeChange);
                    m.map(ProjectManagement::getDayStart, ProjectManagementDto::setDayStart);
                    m.map(ProjectManagement::getDayEnd, ProjectManagementDto::setDayEnd);
                    m.map(ProjectManagement::getTeamStartDate, ProjectManagementDto::setTeamStartDate);
                    m.map(ProjectManagement::getOverTime, ProjectManagementDto::setOverTime);
                    m.map(ProjectManagement::getDescription, ProjectManagementDto::setDescription);
                    m.map(ProjectManagement::getTasks, ProjectManagementDto::setTasks);
                    m.map(ProjectManagement::getIsOffice, ProjectManagementDto::setIsOffice);
                });

        mapper.typeMap(ProjectTeam.class, ProjectTeamCardDto.class)
                .addMappings(m -> {
                    m.map(ProjectTeam::getIsProductDevelop, ProjectTeamCardDto::setIsProductDevelop);
                    m.map(ProjectTeam::getMethodology, ProjectTeamCardDto::setMethodology);
                    m.map(ProjectTeam::getAnalytics, ProjectTeamCardDto::setAnalytics);
                    m.map(ProjectTeam::getDevelopers, ProjectTeamCardDto::setDevelopers);
                    m.map(ProjectTeam::getTesters, ProjectTeamCardDto::setTesters);
                    m.map(ProjectTeam::getTechWriters, ProjectTeamCardDto::setTechWriters);
                    m.map(ProjectTeam::getStakeHoldersCount, ProjectTeamCardDto::setStakeHoldersCount);
                    m.map(ProjectTeam::getDeveloperRequirements, ProjectTeamCardDto::setDeveloperRequirements);
                    m.map(ProjectTeam::getAnalyticsRequirements, ProjectTeamCardDto::setAnalyticsRequirements);
                    m.map(ProjectTeam::getDevOps, ProjectTeamCardDto::setDevOps);
                    m.map(ProjectTeam::getDesigners, ProjectTeamCardDto::setDesigners);
                    m.map(ProjectTeam::getIsTeamFormed, ProjectTeamCardDto::setIsTeamFormed);
                });

        mapper.typeMap(RecruitingCard.class, RecruitingCardDto.class)
                .addMappings(m -> {
                    m.map(RecruitingCard::getFullName, RecruitingCardDto::setFullName);
                    m.map(RecruitingCard::getEmail, RecruitingCardDto::setEmail);
                });

        mapper.typeMap(Employee.class, EmployeeListDto.class)
                .addMappings(m -> {
                    m.map(Employee::getFullName, EmployeeListDto::setFullName);
                    m.map(Employee::getPhoneNumber, EmployeeListDto::setPhoneNumber);
                });



        mapper.typeMap(ProjectCardDto.class, ProjectCard.class)
                .addMappings(m -> {
                    m.map(ProjectCardDto::getFinishingDate, ProjectCard::setFinishingDate);
                    m.map(ProjectCardDto::getProjectStage, ProjectCard::setProjectStage);
                    m.map(ProjectCardDto::getIsDocumentRequired, ProjectCard::setIsDocumentRequired);
                    m.map(ProjectCardDto::getCreatorName, ProjectCard::setCreatorName);
                    m.map(ProjectCardDto::getFirm, ProjectCard::setFirm);
                    m.map(ProjectCardDto::getProjectName, ProjectCard::setProjectName);
                    m.map(ProjectCardDto::getCardCreateDate, ProjectCard::setCardCreateDate);
                    m.map(ProjectCardDto::getProjectArea, ProjectCard::setProjectArea);
                    m.map(ProjectCardDto::getFunctionalDirection, ProjectCard::setFunctionalDirection);
                    m.map(ProjectCardDto::getStatus, ProjectCard::setStatus);
                });

        mapper.typeMap(ProjectManagementDto.class, ProjectManagement.class)
                .addMappings(m -> {
                    m.map(ProjectManagementDto::getOfficeLocation, ProjectManagement::setOfficeLocation);
                    m.map(ProjectManagementDto::getIsTimeChange, ProjectManagement::setIsTimeChange);
                    m.map(ProjectManagementDto::getDayStart, ProjectManagement::setDayStart);
                    m.map(ProjectManagementDto::getDayEnd, ProjectManagement::setDayEnd);
                    m.map(ProjectManagementDto::getTeamStartDate, ProjectManagement::setTeamStartDate);
                    m.map(ProjectManagementDto::getOverTime, ProjectManagement::setOverTime);
                    m.map(ProjectManagementDto::getDescription, ProjectManagement::setDescription);
                    m.map(ProjectManagementDto::getTasks, ProjectManagement::setTasks);
                });

        mapper.typeMap(ProjectTeamCardDto.class, ProjectTeam.class)
                .addMappings(m -> {
                    m.map(ProjectTeamCardDto::getIsProductDevelop, ProjectTeam::setIsProductDevelop);
                    m.map(ProjectTeamCardDto::getMethodology, ProjectTeam::setMethodology);
                    m.map(ProjectTeamCardDto::getAnalytics, ProjectTeam::setAnalytics);
                    m.map(ProjectTeamCardDto::getDevelopers, ProjectTeam::setDevelopers);
                    m.map(ProjectTeamCardDto::getTesters, ProjectTeam::setTesters);
                    m.map(ProjectTeamCardDto::getTechWriters, ProjectTeam::setTechWriters);
                    m.map(ProjectTeamCardDto::getStakeHoldersCount, ProjectTeam::setStakeHoldersCount);
                    m.map(ProjectTeamCardDto::getDeveloperRequirements, ProjectTeam::setDeveloperRequirements);
                    m.map(ProjectTeamCardDto::getAnalyticsRequirements, ProjectTeam::setAnalyticsRequirements);
                    m.map(ProjectTeamCardDto::getDevOps, ProjectTeam::setDevOps);
                    m.map(ProjectTeamCardDto::getDesigners, ProjectTeam::setDesigners);
                    m.map(ProjectTeamCardDto::getIsTeamFormed, ProjectTeam::setIsTeamFormed);
                });

        mapper.typeMap(RecruitingCardDto.class, RecruitingCard.class)
                .addMappings(m -> {
                    m.map(RecruitingCardDto::getFullName, RecruitingCard::setFullName);
                    m.map(RecruitingCardDto::getEmail, RecruitingCard::setEmail);
                });

        mapper.typeMap(EmployeeListDto.class, Employee.class)
                .addMappings(m -> {
                    m.map(EmployeeListDto::getFullName, Employee::setFullName);
                    m.map(EmployeeListDto::getPhoneNumber, Employee::setPhoneNumber);
                });

        return mapper;
    }

    public static <R, E> List<R> convertList(List<E> list, Function<E, R> converter) {
        return list.stream().map(converter).collect(Collectors.toList());
    }
}
