package ru.ibs.happynes;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.ibs.happynes.dto.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class HappynesApplicationTests extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getCardsList() throws Exception {
        String uri = "/api/table/readCards";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ImportantTableDto[] tableDtos = super.mapFromJson(content, ImportantTableDto[].class);
        assertTrue(tableDtos.length > 0);
    }

    @Test
    public void createCard() throws Exception {
        String uri = "/api/table/create";

        ProjectCardDto projectCard = new ProjectCardDto();
        projectCard.setFirm("Firm");
        projectCard.setStatus("Status");
        projectCard.setCreatorName("Name");
        projectCard.setFinishingDate("finish");
        projectCard.setFunctionalDirection("func");
        projectCard.setProjectName("projectName");
        projectCard.setProjectStage("projectStage");
        projectCard.setProjectArea("area");

        ProjectManagementDto projectManagement = new ProjectManagementDto();
        projectManagement.setComment("comment");
        projectManagement.setDayEnd("end");
        projectManagement.setDayStart("start");
        projectManagement.setDescription("descr");
        projectManagement.setOfficeLocation("location");
        projectManagement.setOverTime("overtime");
        projectManagement.setIsOffice(false);
        projectManagement.setTasks("tasks");
        projectManagement.setTeamStartDate("teamStartDay");

        ProjectTeamCardDto projectTeam = new ProjectTeamCardDto();
        projectTeam.setAnalytics("3");
        projectTeam.setDesigners("4");
        projectTeam.setIsProductDevelop(false);
        projectTeam.setIsTeamFormed(false);
        projectTeam.setAnalyticsRequirements("ARec");
        projectTeam.setDevelopers("2");
        projectTeam.setDeveloperRequirements("Drec");
        projectTeam.setTeamCount("12");
        projectTeam.setDevOps("5");
        projectTeam.setMethodology("met");
        projectTeam.setStakeHoldersCount("10");
        projectTeam.setTechWriters("techWr");
        projectTeam.setTesters("8");

        RecruitingCardDto recruitingCard = new RecruitingCardDto();
        recruitingCard.setEmail("email");
        recruitingCard.setFullName("name");
        recruitingCard.setPhoneNumber("number");
        EmployeeDListDto employeeD = new EmployeeDListDto();
        employeeD.setEmail("email");
        employeeD.setFullName("name");
        employeeD.setPhoneNumber("number");
        EmployeeAListDto employeeA = new EmployeeAListDto();
        employeeA.setEmailAnalytic("email");
        employeeA.setFullAnalyticName("name");
        employeeA.setPhoneAnalyticNumber("number");
        recruitingCard.setEmployeeDListDtoList(Collections.singletonList(employeeD));
        recruitingCard.setEmployeeAListDtoList(Collections.singletonList(employeeA));

        MainCardDto mainCardDto = new MainCardDto();
        mainCardDto.setId(1L);
        mainCardDto.setRecruitingCardDto(recruitingCard);
        mainCardDto.setTechnologies(new ArrayList<>(Collections.singleton("Technology")));
        mainCardDto.setProjectCardDto(projectCard);
        mainCardDto.setProjectTeamCardDto(projectTeam);
        mainCardDto.setProjectTypeDto(new ArrayList<>(Collections.singleton("type")));
        mainCardDto.setProjectManagementDto(projectManagement);

        String inputJson = super.mapToJson(mainCardDto);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);


        uri = "/api/table/read?id=1";
        mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void updateCard() throws Exception {
        String uri = "/api/table/update";

        ProjectCardDto projectCard = new ProjectCardDto();
        projectCard.setFirm("Firm");
        projectCard.setStatus("Status");
        projectCard.setCreatorName("Name");
//        projectCard.setCardCreateDate(new Date());
        projectCard.setFinishingDate("finish");
        projectCard.setFunctionalDirection("func");
        projectCard.setProjectName("projectName");
        projectCard.setProjectStage("projectStage");
        projectCard.setProjectArea("area");

        ProjectManagementDto projectManagement = new ProjectManagementDto();
        projectManagement.setComment("comment");
        projectManagement.setDayEnd("end");
        projectManagement.setDayStart("start");
        projectManagement.setDescription("descr");
        projectManagement.setOfficeLocation("location");
        projectManagement.setOverTime("overtime");
        projectManagement.setIsOffice(false);
        projectManagement.setTasks("tasks");
        projectManagement.setTeamStartDate("teamStartDay");

        ProjectTeamCardDto projectTeam = new ProjectTeamCardDto();
        projectTeam.setAnalytics("3");
        projectTeam.setDesigners("4");
        projectTeam.setIsProductDevelop(false);
        projectTeam.setIsTeamFormed(false);
        projectTeam.setAnalyticsRequirements("ARec");
        projectTeam.setDevelopers("2");
        projectTeam.setDeveloperRequirements("Drec");
        projectTeam.setTeamCount("12");
        projectTeam.setDevOps("5");
        projectTeam.setMethodology("met");
        projectTeam.setStakeHoldersCount("10");
        projectTeam.setTechWriters("techWr");
        projectTeam.setTesters("8");

        RecruitingCardDto recruitingCard = new RecruitingCardDto();
        recruitingCard.setEmail("email");
        recruitingCard.setFullName("name");
        recruitingCard.setPhoneNumber("number");
        EmployeeDListDto employeeD = new EmployeeDListDto();
        employeeD.setEmail("email");
        employeeD.setFullName("name");
        employeeD.setPhoneNumber("number");
        EmployeeAListDto employeeA = new EmployeeAListDto();
        employeeA.setEmailAnalytic("email");
        employeeA.setFullAnalyticName("name");
        employeeA.setPhoneAnalyticNumber("number");
        recruitingCard.setEmployeeDListDtoList(Collections.singletonList(employeeD));
        recruitingCard.setEmployeeAListDtoList(Collections.singletonList(employeeA));

        MainCardDto mainCardDto = new MainCardDto();
        mainCardDto.setId(1L);
        mainCardDto.setRecruitingCardDto(recruitingCard);
        mainCardDto.setTechnologies(new ArrayList<>(Collections.singleton("Technology")));
        mainCardDto.setProjectCardDto(projectCard);
        mainCardDto.setProjectTeamCardDto(projectTeam);
        mainCardDto.setProjectTypeDto(new ArrayList<>(Collections.singleton("type")));
        mainCardDto.setProjectManagementDto(projectManagement);

        String inputJson = super.mapToJson(mainCardDto);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @AfterAll
    @Test
    public void deleteCard() throws Exception {
        String uri = "/api/table/delete?id=1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

//    @Test
//    public void updateStatus() throws Exception {
//        UpdateStatusDto dto = new UpdateStatusDto(1L, "Черновик");
//
//        String inputJson = super.mapToJson(dto);
//        String uri = "/api/table/status";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//    }


}
