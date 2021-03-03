package com.ricgra.app.service;

import com.ricgra.app.model.PhoneNumber;
import com.ricgra.app.model.exception.CSVWriteServiceException;

import java.io.PrintWriter;
import java.util.List;

public interface DownloadService {

    void downloadAsCSV(PrintWriter writer) throws CSVWriteServiceException;

    List<PhoneNumber> download();

}
