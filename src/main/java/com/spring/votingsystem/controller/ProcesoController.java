package com.spring.votingsystem.controller;

import com.spring.votingsystem.controller.request.ProcessRequest;
import com.spring.votingsystem.dto.UserDTO;
import com.spring.votingsystem.mapper.UserDTOMapper;
import com.spring.votingsystem.repository.model.Partido;
import com.spring.votingsystem.repository.model.Proceso;
import com.spring.votingsystem.repository.model.UsuarioProceso;
import com.spring.votingsystem.service.ProcesoService;
import com.spring.votingsystem.service.UserService;
import com.spring.votingsystem.service.impl.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.spring.votingsystem.service.impl.ProcesoServiceImpl;

@RequestMapping("/votes")
@RestController
public class ProcesoController {

    @Autowired
    private ProcesoService procesoService;

    @Autowired
    private ProcessService processService;

    @GetMapping("getAllProcess")
    public List<Proceso> getAllProcess() {
        return procesoService.getAllProcesos();
    }

    @GetMapping("getProcess/{id}")
    public Optional<Proceso> getProcess(@PathVariable Long id) {
        return procesoService.getProceso(id);
    }

    @PostMapping("createProcess")
    public Proceso createProcess(@RequestBody ProcessRequest proceso) {
        return procesoService.createProceso(proceso);
    }

    @PutMapping("modifyProcess")
    public Proceso modifyProceso(@RequestBody ProcessRequest proceso) {
        return procesoService.modifyProceso(proceso);
    }

    @PutMapping("setStateProcess/{id}")
    public Proceso setStateProcess(@PathVariable Long id, @RequestBody String estado) {
        return procesoService.setStateProcess(id, estado);
    }

    @PostMapping(path = "create-process", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Proceso createProcessCSV(@RequestPart("file") MultipartFile file, @RequestPart String procesoStr) {
        ProcessRequest proceso = ProcessRequest.fromJson(procesoStr);
        List<UserDTO> usuariosDTO = UserDTOMapper.CSVToUserDTO(file);
        UserService.createUsers(file);
        List<UsuarioProceso> usuarioProcesos = new ArrayList<>();
        Proceso p = ProcesoServiceImpl.toEntity(proceso);
        for (UserDTO userDTO : usuariosDTO) {
            String email = userDTO.getEmail();
            UsuarioProceso usuarioProceso = new UsuarioProceso();
            usuarioProceso.setEmail(email);
            usuarioProceso.setProceso(p);
            usuarioProceso.setEstadoVoto("sin votar");
            usuarioProceso.setVoto(null);
            usuarioProcesos.add(usuarioProceso);
        }
        List<Partido> partidos = new ArrayList<>();
        for (Partido partido : proceso.getPartidos()) {
            Partido p1 = Partido.builder()
                    .nombrePartido(partido.getNombrePartido())
                    .nombrePostulante(partido.getNombrePostulante())
                    .imagenPartido(partido.getImagenPartido())
                    .proceso(p)
                    .build();
            partidos.add(p1);
        }
        p.setUsuarioProceso(usuarioProcesos);
        p.setPartidoProceso(partidos);
        return processService.createProcess(p);
    }
}