package net.bankapp.banking.controller;

import net.bankapp.banking.dto.BranchDto;
import net.bankapp.banking.service.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/branches")
public class BranchController {
    private BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    //Add Branch REST API
    @PostMapping
    public ResponseEntity<BranchDto> addBranch(@RequestBody BranchDto branchDto){
        return new ResponseEntity<>(branchService.createBranch(branchDto), HttpStatus.CREATED);
    }
}
