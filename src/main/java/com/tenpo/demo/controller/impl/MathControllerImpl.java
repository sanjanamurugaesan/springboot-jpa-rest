package com.tenpo.demo.controller.impl;

import com.tenpo.demo.controller.MathController;
import com.tenpo.demo.util.Constants;
import com.tenpo.demo.dao.impl.MathOperationDaoImpl;
import com.tenpo.demo.entities.MathOperation;
import com.tenpo.demo.entities.User;
import com.tenpo.demo.repo.MathRepository;
import com.tenpo.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin({"*"})
public class MathControllerImpl implements MathController {

    @Autowired
    private MathOperationDaoImpl sumDao;

    @Autowired
    private MathRepository auditRepo;

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/getAuditDetails")
    @Override
    public List<MathOperation> getMathAuditDetails(){
        return auditRepo.findAll();
    }

    @RequestMapping("/sum/{userId}")
    @Override
    public String sum(@RequestBody MathOperation sumDetails, @PathVariable String userId){
        Optional<User> user = userRepo.findByUserId(userId);
        if(user.isPresent()){
            if(Constants.Y.equalsIgnoreCase(user.get().getIsLoggedIn())){
                BigDecimal result = sumDetails.getInput1().add(sumDetails.getInput2());
                sumDetails.setSum(result);
                sumDetails.setUser(user.get());
                sumDetails.getUser().setUserId(userId);
                try {
                    String status = sumDao.persist(sumDetails);
                    if(Constants.SUCCESS.equalsIgnoreCase(status)){
                        System.out.println("Saved data successfully");
                    } else {
                        return Constants.ERROR;
                    }
                } catch (Exception e){
                        return Constants.ERROR;
                }
                return "The sum of " + sumDetails.getInput1() + " and " + sumDetails.getInput2() + " is = " + result;
            } else {
                return Constants.LOGIN_ADVICE;
            }
        } else {
            return Constants.USER_NOT_EXISTS;
        }
    }
}
