package com.tenpo.demo.controller;

import com.tenpo.demo.entities.MathOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MathController {
    List<MathOperation> getMathAuditDetails();
    String sum(@RequestBody MathOperation sumDetails, @PathVariable String userId);
}
