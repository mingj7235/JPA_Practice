package com.joshua.controller.footballManager;

import com.joshua.dto.FootballManager.manager.ManagerSaveRequestDto;
import com.joshua.dto.FootballManager.manager.ManagerUpdateRequestDto;
import com.joshua.service.FootballManager.Manager_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Manager_ApiController {

    private final Manager_Service managerService;

    @PostMapping ("/fm/manager/save")
    public void saveManager (ManagerSaveRequestDto requestDto) {
        managerService.saveManager(requestDto);
    }

    @PutMapping ("/fm/manager/update/{id}")
    public void updateManager (@PathVariable Long id, ManagerUpdateRequestDto requestDto){
        managerService.updateManager(id, requestDto);
    }

    @DeleteMapping ("/fm/manager/delete/{id}")
    public void deleteManager (@PathVariable Long id) {
        managerService.deleteManager(id);
    }

    @PostMapping("/fm/manager/find/{id}")
    public void findManager (@PathVariable Long id) {
        managerService.findManager(id);
    }
}
