package com.ricgra.app.service;

import com.ricgra.app.model.exception.InvalidInputServiceException;
import com.ricgra.app.model.exception.NullInputServiceException;

import java.io.InputStream;

public interface UploadService {

    void uploadFile(InputStream inputFileStream) throws InvalidInputServiceException, NullInputServiceException;

}
