package ru.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.model.Attachment;
import ru.example.model.Check;
import ru.example.model.CheckAction;
import ru.example.repository.CheckRepository;
import ru.example.service.*;
import ru.example.utils.DateTimeUtil;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckRepository checkRepository;

    @Autowired
    private CheckListService checkListService;

    @Autowired
    CheckActionService checkActionService;

    @Autowired
    CheckActionAttachmentService checkActionAttachmentService;

    @Autowired
    AttachmentService attachmentService;

    @Override
    public void addCheck(Check check) {
        checkRepository.save(check);
    }

    @Override
    public void deleteCheckById(int id) {
        checkRepository.deleteById(id);
    }

    @Override
    public List<Check> findAllChecks() {
        return checkRepository.findAll();
    }

    @Override
    public Check getLastCheck() {
        return checkRepository.findTopByOrderByIdCheckDesc();
    }

    @Override
    public List<Integer> findChecksByIdCheckList(Integer id) {
        return checkRepository.findChecksByIdCheckList(id);
    }

    @Override
    public Check findCheckById(Integer id) {
        return checkRepository.findCheckByIdCheck(id);
    }

    @Override
    public void deleteCheck(Check check) {
        checkRepository.delete(check);
    }

    @Override
    @Transactional
    public void changeCheck(Check check) {
        List<CheckAction> checkActionList = checkActionService.findByIdCheck(check.getIdCheck());
        List<CheckAction> checkActionListTemp = checkActionService.findByIdCheck(check.getIdCheck());
        System.out.println(checkActionList);

        Check targetCheck = new Check(check.getIdCheckList()
                , check.getStart()
                , check.getFinish()
                , check.getDeadline()
                , check.getIdEngineer());

        Timestamp start = targetCheck.getStart();
        Timestamp finish = targetCheck.getFinish();
        Timestamp deadline = targetCheck.getDeadline();
        targetCheck.setResponible(check.getIdEngineer());
        targetCheck.setName(checkListService.getNameById(check.getIdCheckList()));
        targetCheck.setStart(DateTimeUtil.convertDateTime(start.toLocalDateTime()));
        targetCheck.setFinish(DateTimeUtil.convertDateTime(finish.toLocalDateTime()));
        targetCheck.setDeadline(DateTimeUtil.convertDateTime(deadline.toLocalDateTime()));
        this.addCheck(targetCheck);

        List<CheckAction> checkActionListFinal = convertCkeckActionList(checkActionList,
                start.toLocalDateTime(),
                finish.toLocalDateTime(),
                targetCheck);


        workWithAttachments(checkActionListTemp, checkActionListFinal);
    }

    private void workWithAttachments(List<CheckAction> checkActionListTemp, List<CheckAction> checkActionListFinal) {
        if ((checkActionListTemp.size() == checkActionListFinal.size())) {

            for (int i = 0; i < checkActionListTemp.size(); i++) {
                List<Attachment> attachmentListSource;

                if (!checkActionListTemp.get(i).getAttachments().isEmpty()) {
                    attachmentListSource = new ArrayList<>(checkActionListTemp.get(i).getAttachments());
                    checkActionListFinal.get(i).setAttachments(attachmentListSource);
                }
            }
        }
    }

    private List<CheckAction> convertCkeckActionList(List<CheckAction> checkActionList,
                                                    LocalDateTime start,
                                                    LocalDateTime finish,
                                                    Check targetCheck) {

        List<CheckAction> checkActionListFinal = new ArrayList<>();
        checkActionList.forEach(item -> checkActionListFinal.add(new CheckAction(item.getId_Check_Item()
                , item.getId_Maintenance_Action()
                , item.getAction_Date()
                , item.getActed()
                , item.getId_Engineer()
                , item.getAction_Time()
                , item.getParameter()
                , item.getName()
                , item.getSort_Order()
                , item.getAction_Name()
                , item.getDescription()
                , item.getNeed_Photo()
                , item.getNeed_Parameter()
                , item.getItem_SortOrder()
                , item.getCheck())));
        int checkActionListSize = checkActionListFinal.size();
        long startTime = DateTimeUtil.getTimeInLongFromLocalDateTime(start);
        long finishTime = DateTimeUtil.getTimeInLongFromLocalDateTime(finish);
        long timeDifference = DateTimeUtil.getTimeDifference(finishTime, startTime);
        long step = DateTimeUtil.countTimeStep(timeDifference, checkActionListSize);
        List<Timestamp> timestampList = new ArrayList<>(checkActionListSize);
        for (long l = startTime + step; l <= finishTime; l += step) {
            timestampList.add(DateTimeUtil.convertLongToTimeStamp(l));
        }

        if (timestampList.size() == checkActionListSize) {
            for (int i = 0; i < checkActionListSize; i++) {
                checkActionListFinal.get(i).setId_Engineer(targetCheck.getIdEngineer());
                checkActionListFinal.get(i).setAction_Date(timestampList.get(i));

            }
            checkActionListFinal.forEach(item -> item.setCheck(targetCheck));
            targetCheck.setCheckActionList(checkActionListFinal);

            return checkActionListFinal;
        }
        return new ArrayList<>();
    }
}