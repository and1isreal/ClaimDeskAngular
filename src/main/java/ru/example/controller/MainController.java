package ru.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.example.model.*;
import ru.example.repository.*;
import ru.example.service.*;
import ru.example.utils.DateTimeUtil;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@RestController
public class MainController {

    @Autowired
    private EngineerService engineerService;

    @Autowired
    private CheckListService checkListService;

    @Autowired
    private CheckActionService checkActionService;


    @Autowired
    private CheckService checkService;

    @Autowired
    private AttachmentService attachmentService;

    @GetMapping("/engineers")
    public List<Engineer> getEngineers() {
        return (List<Engineer>) engineerService.findAllEngineers();
    }

    @GetMapping("/checklists")
    public List<CheckList> getCheckLists() {
        return (List<CheckList>) checkListService.findAllCheckLists();
    }

    @GetMapping("/checks")
    public List<Check> getChecks() {
        return (List<Check>) checkService.findAllChecks();
    }

    @GetMapping("/checks/checkListId/{checkListId}")
    public List<Integer> getCheckListsById(@PathVariable("checkListId") int checkListId) {
        return checkService.findChecksByIdCheckList(checkListId);
    }

    @GetMapping("/checks/{checkId}")
    public Check getCheckById(@PathVariable("checkId") int checkId) {
        return checkService.findCheckById(checkId);
    }

    @GetMapping("/checkActions")
    public List<CheckAction> getCheckActions() {
        return (List<CheckAction>) checkActionService.findAllCheckActions();
    }

    @GetMapping("/checkActions/{checkId}")
    public List<CheckAction> getCheckActionsByCheckId(@PathVariable("checkId") int checkId) {
        return (List<CheckAction>) checkActionService.findByIdCheck(checkId);
    }

    @GetMapping("/attachments")
    public List<Attachment> getAttachments() {
        return (List<Attachment>) attachmentService.findAllAttachments();
    }

    @GetMapping("/attachments/{n}")
    public Attachment getAttachments(@PathVariable("n") int number) {
        return attachmentService.findById(number);
    }

//    @PostMapping("/deleteCheck")
//    public void delete(@RequestBody Check check) {
//        checkService.deleteCheck(check);
//    }
    @DeleteMapping("/deleteCheck/{checkId}")
    public void delete(@PathVariable("checkId") int checkId) {
        System.out.println("trying to delete Check by id");
    checkService.deleteCheckById(checkId);
}

    @PostMapping("/checks")
    public void addCheck(@RequestBody Check check) {
        checkService.changeCheck(check);
    }
}