package net.bankapp.banking.service;

import net.bankapp.banking.dto.BranchDto;
import net.bankapp.banking.entity.Branch;

public interface BranchService {
    BranchDto createBranch(BranchDto branchDto);
}
