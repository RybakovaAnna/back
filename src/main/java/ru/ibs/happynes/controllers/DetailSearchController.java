package ru.ibs.happynes.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.happynes.configuration.MapperUtil;
import ru.ibs.happynes.dto.FilterSearchDto;
import ru.ibs.happynes.dto.ImportantTableDto;
import ru.ibs.happynes.entities.ProjectCard;
import ru.ibs.happynes.services.intefaces.ProjectDetailService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value ="/api/search", consumes = {MediaType.ALL_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class DetailSearchController {

    private final ModelMapper modelMapper;
    private final ProjectDetailService service;

    public DetailSearchController(ModelMapper modelMapper, ProjectDetailService service){
        this.modelMapper = modelMapper;
        this.service = service;
    }


    private ImportantTableDto convertToDTO(ProjectCard projectCard) {
        return modelMapper.map(projectCard, ImportantTableDto.class);
    }

    @GetMapping("param")
    public List<ImportantTableDto> readByPName(@RequestParam String param) {
        List<ProjectCard> result = service.findAllByParam(param);
        return MapperUtil.convertList(result, this::convertToDTO);
    }

    @GetMapping("filter")
    public List<ImportantTableDto> filter(@RequestBody FilterSearchDto filterSearchDto) throws ParseException {
        List<ProjectCard> result = service.filter(filterSearchDto);
        return MapperUtil.convertList(result, this::convertToDTO);
    }

    @GetMapping("sortAsc")
    public List<ImportantTableDto> sortAsc(@RequestParam String param){
        List<ProjectCard> result = service.sortCardAsc(param);
        return MapperUtil.convertList(result, this::convertToDTO);
    }

    @GetMapping("sortDesk")
    public List<ImportantTableDto> sortDesk(@RequestParam String param){
        List<ProjectCard> result = service.sortCardDesc(param);
        return MapperUtil.convertList(result, this::convertToDTO);
    }
}
