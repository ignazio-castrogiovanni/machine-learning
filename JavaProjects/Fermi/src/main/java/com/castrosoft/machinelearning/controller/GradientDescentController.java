package com.castrosoft.machinelearning.controller;

import com.castrosoft.machinelearning.service.GradientDescentService;
import com.castrosoft.machinelearning.vo.GradientDescentOutputVO;
import com.castrosoft.machinelearning.vo.GradientDescentTwoVariablesInputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ignazio Castrogiovanni on 29/7/17.
 */
@RestController
@RequestMapping("api/gradientdescent")
public class GradientDescentController {
    @Autowired
    private GradientDescentService gradientDescentService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/twovariables", method = RequestMethod.POST)
    public ResponseEntity<?> computeGradientTwoVariables(
            @RequestBody GradientDescentTwoVariablesInputVO gradientDescentParameters) {

        GradientDescentOutputVO outputVO = gradientDescentService.computeGradientDescentTwoVariables(gradientDescentParameters);
        return new ResponseEntity<>(outputVO, HttpStatus.OK);
    }
}
