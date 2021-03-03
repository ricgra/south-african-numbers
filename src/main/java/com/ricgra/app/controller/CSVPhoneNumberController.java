package com.ricgra.app.controller;

import com.ricgra.app.model.exception.CSVWriteServiceException;
import com.ricgra.app.model.exception.InvalidInputServiceException;
import com.ricgra.app.model.exception.NullInputServiceException;
import com.ricgra.app.service.DownloadService;
import com.ricgra.app.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("rest/phone-number/csv")
@Api("CSV file controller")
public class CSVPhoneNumberController {

    @Autowired
    UploadService uploadService;

    @Autowired
    DownloadService downloadService;

    @PostMapping
    @ApiOperation("Upload a csv file")
    public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file)
            throws NullInputServiceException, InvalidInputServiceException {
        if(file == null) {
            return ResponseEntity.badRequest().build();
        }

        try(InputStream fileStream = file.getInputStream()) {
            uploadService.uploadFile(fileStream);

            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            throw new InvalidInputServiceException(e.getMessage());
        }
    }

    @GetMapping
    @ApiOperation("Download all records as CSV file")
    public void download(HttpServletResponse response) throws CSVWriteServiceException {
        String filename = "export.csv";

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
        response.setContentType("text/csv");

        try {
            downloadService.downloadAsCSV(response.getWriter());
        } catch (IOException e) {
            throw new CSVWriteServiceException(e.getMessage());
        }
    }

}
