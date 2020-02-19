package com.example.demo.ServiceInterfaceImp;

import com.example.demo.ServiceInterface.BlockInterfaceOperation;
import com.example.demo.XReposotry.BlockListRepo;
import com.example.demo.ZModel.BlockList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockInterfaceOperationImpl implements BlockInterfaceOperation {
    @Autowired
    private BlockListRepo blockListRepo;
    @Override
    public void addUserToBlockList(BlockList blockList) {
            blockListRepo.save(blockList);
    }
}
