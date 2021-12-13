package ru.ibs.happynes.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.web.bind.annotation.*;
import ru.ibs.happynes.configuration.MapperUtil;
import ru.ibs.happynes.dto.ImportantTableDto;
import ru.ibs.happynes.dto.MainCardDto;
import ru.ibs.happynes.dto.UpdateStatusDto;
import ru.ibs.happynes.entities.ProjectCard;
import ru.ibs.happynes.services.intefaces.ProjectCardService;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.List;

@RestController
@RequestMapping(value ="/api/table", consumes = {MediaType.ALL_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class MainDtoController {

    private final ModelMapper modelMapper;
    private final ProjectCardService projectCardService;

    private ImportantTableDto convertToDTO(ProjectCard projectCard) {
        return modelMapper.map(projectCard, ImportantTableDto.class);
    }

    @GetMapping("readCards")
    private List<Object> readDTOCards(@RequestParam(required = false) Long id) {
            List<ProjectCard> tables = projectCardService.findAll();
            return MapperUtil.convertList(tables, this::convertToDTO);
    }

    @GetMapping("read")
    private List<MainCardDto> readDTOcard(@RequestParam Long id) {
        return projectCardService.findTable(id);
    }

    @PostMapping("create")
    private Long createDTOCard(@RequestBody MainCardDto dto){
        return projectCardService.createTable(dto);
    }

    @PostMapping("delete")
    private void deleteDTOCard(@RequestParam Long id){
        projectCardService.deleteTable(id);
    }

    @PostMapping("update")
    private void updateDTOCard(@RequestBody MainCardDto dto){
        projectCardService.updateTable(dto);
    }

    @PostMapping("status")
    private void updateStatus(@RequestBody UpdateStatusDto dto){
        projectCardService.updateStatus(dto);
    }

    @GetMapping("technologies")
    private List<String> readTechnologies(){
        return projectCardService.findTechnologiesDictionary();
    }

    @GetMapping("projectArea")
    private List<String> readProjectArea(){
        return projectCardService.findProjectAreaDictionary();
    }

    @GetMapping("firm")
    private List<String> readFirmDictionary(){
        return projectCardService.findFirmDictionary();
    }

//    @GetMapping("logout")
//    private void logOut(){
//
//    }
}
