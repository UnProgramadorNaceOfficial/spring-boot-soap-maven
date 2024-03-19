package com.soap.controller;

import com.soap.client.SoapClient;
import com.soap.wsdl.AddResponse;
import com.soap.wsdl.DivideResponse;
import com.soap.wsdl.MultiplyResponse;
import com.soap.wsdl.SubtractResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SoapController {

    @Autowired
    private SoapClient soapClient;

    @PostMapping("/sumar")
    public ResponseEntity<?> add(@RequestParam int numberA, @RequestParam int numberB) {

        AddResponse addResponse = soapClient.getAddResponse(numberA, numberB);

        Map<String, Integer> response = new HashMap<>();
        response.put("resultado", addResponse.getAddResult());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/restar")
    public ResponseEntity<?> subtract(@RequestParam int numberA, @RequestParam int numberB) {
        SubtractResponse subtractResponse = soapClient.getSubtractResponse(numberA, numberB);

        Map<String, Integer> response = new HashMap<>();
        response.put("resultado", subtractResponse.getSubtractResult());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/multiplicar")
    public ResponseEntity<?> multiply(@RequestParam int numberA, @RequestParam int numberB) {

        MultiplyResponse multiplyResponse = soapClient.getMultiplyResponse(numberA, numberB);

        Map<String, Integer> response = new HashMap<>();
        response.put("resultado", multiplyResponse.getMultiplyResult());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/dividir")
    public ResponseEntity<?> divide(@RequestParam int numberA, @RequestParam int numberB) {
        DivideResponse divideResponse = soapClient.getDivideResponse(numberA, numberB);

        Map<String, Integer> response = new HashMap<>();
        response.put("resultado", divideResponse.getDivideResult());

        return ResponseEntity.ok().body(response);
    }
}
