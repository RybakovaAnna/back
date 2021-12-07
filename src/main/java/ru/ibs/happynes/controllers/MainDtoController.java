package ru.ibs.happynes.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.happynes.configuration.MapperUtil;
import ru.ibs.happynes.dto.ImportantTableDto;
import ru.ibs.happynes.dto.MainCardDto;
import ru.ibs.happynes.entities.ProjectCard;
import ru.ibs.happynes.services.intefaces.ProjectCardService;

import javax.annotation.security.RolesAllowed;
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

//    @RolesAllowed("projectmanagement")
    @GetMapping("read")
    private List<Object> readDTOCards(@RequestParam(required = false) Long id) {

        if (id == null) {
            List<ProjectCard> tables = projectCardService.findAll();
            return MapperUtil.convertList(tables, this::convertToDTO);
        } else {
            return projectCardService.findTable(id);
        }
    }

//    @RolesAllowed("projectManagement")
    @PostMapping("create")
    private void createDTOCard(@RequestBody MainCardDto dto){
        projectCardService.createTable(dto);
    }

//    @RolesAllowed("projectManagement")
    @PostMapping("delete")
    private void deleteDTOCard(@RequestParam Long id){
        projectCardService.deleteTable(id);
    }

    //TODO: убрать параметр id
//    @RolesAllowed("projectmanagement")
    @PostMapping("update")
    private void updateDTOCard(@RequestParam long id, @RequestBody MainCardDto dto){
        projectCardService.updateTable(id, dto);
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

}
