package net.bankapp.banking.service.Impl;

import net.bankapp.banking.Mapper.BranchMapper;
import net.bankapp.banking.dto.BranchDto;
import net.bankapp.banking.entity.Branch;
import net.bankapp.banking.repository.BranchRepo;
import net.bankapp.banking.service.BranchService;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepo branchRepo;

    public BranchServiceImpl(BranchRepo branchRepo) {
        this.branchRepo = branchRepo;
    }

    @Override
    public BranchDto createBranch(BranchDto branchDto) {
        Branch branch= BranchMapper.mapToBranch(branchDto);
        Branch savedBranch= branchRepo.save(branch);
        return BranchMapper.mapToBranchDto(savedBranch);
    }
}
