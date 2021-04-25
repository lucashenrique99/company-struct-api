package br.com.lucashenriquedev.companystruct.commons.uploads.controller;

import br.com.lucashenriquedev.companystruct.commons.uploads.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/uploads")
public class UploadController {

    @Autowired
    private UploadFileService uploadFileService;

    @PostMapping
    public ResponseEntity<Object> handleOnFileUpload(
            @RequestParam(required = false) MultipartFile file,
            @RequestParam(required = false) MultipartFile upload) {
        try {
            MultipartFile validFile = null;
            if (file != null) {
                validFile = file;
            } else if (upload != null) {
                validFile = upload;
            }

            if (validFile == null) {
                throw new IllegalArgumentException("Missing file to upload");
            }

            return ResponseEntity.ok(uploadFileService.upload(validFile));

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
