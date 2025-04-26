package com.inventory.management.service.serviceimpl;

import com.inventory.management.service.WasteCollection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WasteCollectionImpl implements WasteCollection {
    @Override
    public String remove(String wastageCollection) {
return "ok";

    }
}
