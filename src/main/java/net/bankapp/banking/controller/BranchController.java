package net.bankapp.banking.controller;

import net.bankapp.banking.Error.CustomException;
import net.bankapp.banking.dto.Branch.BranchDataDto;
import net.bankapp.banking.dto.Branch.BranchDto;
import net.bankapp.banking.service.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {
    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    //Add Branch REST API
    @PostMapping
    public ResponseEntity<BranchDataDto> addBranch(@RequestBody BranchDto branchDto){
        return new ResponseEntity<>(branchService.createBranch(branchDto),HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BranchDataDto> getBranchById(@PathVariable Integer id){
        return new ResponseEntity<>(branchService.getBranchById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BranchDataDto>> getAllBranches() {
        return new ResponseEntity<>(branchService.getAllBranches(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BranchDto> updateBranch(@RequestBody BranchDataDto branch) {
        return new ResponseEntity<>(branchService.updateBranch(branch),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Integer id) {
        branchService.deleteBranch(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
