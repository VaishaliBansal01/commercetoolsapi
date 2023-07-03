package com.demo.CT.importapi;

import com.commercetools.importapi.models.importcontainers.ImportContainer;
import com.commercetools.importapi.models.importrequests.ImportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportController {
    @Autowired
    ImportService importService;
    @PostMapping("/import-container")
    public ImportContainer createImportContainer(@RequestBody ImportDto importDto)
    {
       return importService.createImportContainer(importDto);
    }
    @PostMapping("/price-import/{key}")
    public ImportResponse createPriceImportRequest(@PathVariable String key, @RequestBody ImportDto importDto)
    {
        return importService.createPriceImportRequest(key,importDto);
    }
}
