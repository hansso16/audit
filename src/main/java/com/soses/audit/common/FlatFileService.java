package com.soses.audit.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.soses.audit.entity.Customer;
import com.soses.audit.framework.property.FlatFileProperties;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class FlatFileService {

	private FlatFileProperties flatFileProperties;
	
	public FlatFileService(FlatFileProperties flatFileProperties) {
		super();
		this.flatFileProperties = flatFileProperties;
	}

	public String getCustomerPhotoImgString(String fileName) {
		
		if (StringUtil.isEmpty(fileName)) { return null;}
		
		String encodedString = null;
		String fullPath = flatFileProperties.getCustomerStorePath() + fileName;
		try {
			File imageFile = new File(fullPath);
			InputStream in = new FileInputStream(imageFile);
			encodedString = generateBase64ImgString(in);
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return encodedString;
	}

	private String generateBase64ImgString(InputStream in) {
		
		if (in == null) { return null;}
		String encodedString = null;
		try {
			encodedString = Base64.getEncoder().encodeToString(IOUtils.toByteArray(in));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return encodedString;
	}
	
	public static void checkDir(Path uploadPath) throws IOException {
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
	}
	
	public String uploadStorePhoto(MultipartFile file, Customer customer) throws IOException {
		File oFile = null;
		File nFile = null;
		String customerStoreImagePath = flatFileProperties.getCustomerStorePath();
        Path uploadPath = Paths.get(customerStoreImagePath);
        checkDir(uploadPath);
         
        String extention = FilenameUtils.getExtension(StringUtils.cleanPath(file.getOriginalFilename()));
        String fileName = customer.getCustomerId() + GlobalConstants.PERIOD + extention;
        try (InputStream inputStream = file.getInputStream()) {
//            Path filePath = uploadPath.resolve(fileName);
            oFile = new File(uploadPath + "\\" + customer.getStorePhoto());
            oFile.delete();
            nFile = new File(uploadPath + "\\" + fileName);
            Files.copy(inputStream, nFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + ioe.getMessage(), ioe);
        } finally {
        	oFile = null;
        	nFile = null;
        }
        
        return fileName;
	}
}
