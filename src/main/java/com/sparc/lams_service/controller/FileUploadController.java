package com.sparc.lams_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sparc.lams_service.payload.Response;
import com.sparc.lams_service.service.FileStorageService;
@CrossOrigin(origins = "*",maxAge =3600 )
@RestController
public class FileUploadController {
	@Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file,@RequestParam String fname) {
        String fileName = fileStorageService.storeFile(file,fname);

//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//            .path("/uploads/")
//            .path(fileName)
//            .toUriString();
        
        Response response=new Response();
        response.setFilename(fileName);
        return response;
//        return new Response(fileName, fileDownloadUri);
        
        
        
    }

//    @PostMapping("/uploadMultipleFiles")
//    public List < Response > uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        
//		return Arrays.asList(files)
//            .stream()
//            .map(files - > uploadFile(files))
//            .collect(Collectors.toList());
//    }
}
