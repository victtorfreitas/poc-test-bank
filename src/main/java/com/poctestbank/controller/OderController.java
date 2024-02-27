package com.poctestbank.controller;

import com.poctestbank.controller.dto.request.OrderRequest;
import com.poctestbank.controller.dto.response.OrderResponse;
import com.poctestbank.service.FindOrderService;
import com.poctestbank.service.ProcessOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oders")
@RequiredArgsConstructor
public class OderController {

    private final FindOrderService findOrderService;
    private final ProcessOrderService processOrderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAllByDestination(@RequestParam String destination) {
        return ResponseEntity.ok(findOrderService.getAllByDestination(destination));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderRequest orderRequest){
        processOrderService.insert(orderRequest);
    }
}
