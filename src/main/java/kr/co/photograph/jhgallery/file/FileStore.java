package kr.co.photograph.jhgallery.file;

import kr.co.photograph.jhgallery.domain.Flag;
import kr.co.photograph.jhgallery.domain.UploadPhoto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {

    @Value("${upload.photo.dir}")
    private String photoDir;

    public String getFullPath(String fileName) {
        return photoDir + fileName;
    }

    public List<UploadPhoto> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadPhoto> storeFileResult = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                storeFileResult.add(storeFile(multipartFile));
            }
        }
        return storeFileResult;
    }

    public UploadPhoto storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }
        String originalPhotoName = multipartFile.getOriginalFilename();
        String storePhotoName = createStorePhotoName(originalPhotoName);
        multipartFile.transferTo(new File(getFullPath(storePhotoName)));
        return new UploadPhoto(originalPhotoName, storePhotoName, getFullPath(storePhotoName), Flag.PUBLIC);
    }

    private String createStorePhotoName(String originalFilename) {
        String ext = extracted(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    private String extracted(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }
}
