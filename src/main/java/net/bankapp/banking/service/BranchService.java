package net.bankapp.banking.service;

import net.bankapp.banking.Error.CustomException;
import net.bankapp.banking.dto.Branch.BranchDataDto;
import net.bankapp.banking.dto.Branch.BranchDto;
import net.bankapp.banking.entity.Branch;

import java.util.List;


public interface BranchService {

    BranchDataDto createBranch(BranchDto branchDto);

    public BranchDataDto getBranchById(Integer id) throws CustomException;

    public List<BranchDataDto> getAllBranches();

    public BranchDto updateBranch(BranchDataDto branch) throws CustomException;

    public void deleteBranch(Integer id) throws CustomException;
}