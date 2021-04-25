package br.com.lucashenriquedev.companystruct.commons.uploads.service;

import br.com.lucashenriquedev.companystruct.config.global.CloudinaryProperties;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UploadFileService {

    private final Cloudinary cloudinary;

    @Autowired
    public UploadFileService(CloudinaryProperties properties) {
        this.cloudinary = new Cloudinary("cloudinary://"
                + properties.getApiKey() + ":"
                + properties.getApiSecret() + "@"
                + properties.getCloudName());
    }

    public Map<String, String> upload(MultipartFile file) throws IOException {
        return this.handleOnCloudinaryUpload(file);
    }

    private Map<String, String> handleOnCloudinaryUpload(MultipartFile file) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("folder", "company_structure/feed/images");
        Map response = cloudinary.uploader().upload(file.getBytes(), params);

        Map<String, String> map = null;
        if (response != null && response.containsKey("secure_url")) {
            map = new HashMap<>();
            map.put("url", (String) response.get("secure_url"));
        }

        return map;
    }

}
