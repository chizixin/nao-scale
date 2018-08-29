package com.nao.scale.baidu.ueditor.upload;

import com.nao.scale.baidu.ueditor.PathFormat;
import com.nao.scale.baidu.ueditor.define.AppInfo;
import com.nao.scale.baidu.ueditor.define.BaseState;
import com.nao.scale.baidu.ueditor.define.FileType;
import com.nao.scale.baidu.ueditor.define.State;
import com.nao.scale.utils.FtpUtil;
import com.nao.scale.utils.IDUtils;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BinaryUploader {
	
    public static final State save(HttpServletRequest request, Map<String, Object> conf) {
        if (!ServletFileUpload.isMultipartContent(request)) {
            return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
        }

        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("upfile");
        try {
        	
        	
        	State storageState = null;
        	//生成一个新的文件名
			//取原始文件名
			String oldName = file.getOriginalFilename();
			//生成新文件名
			//UUID.randomUUID();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			//图片上传
			
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile("192.168.10.147", 21, "ftpuser", "ftpuser", 
					"/home/ftpuser/www/images/", imagePath, newName, file .getInputStream());
            if(result) {
            	storageState = new BaseState(true,AppInfo.SUCCESS);
			}
            if (storageState.isSuccess()) { 
                storageState.putInfo("url", "http://192.168.10.147" + imagePath + "/" + newName);
                //storageState.putInfo("type", suffix);
               // storageState.putInfo("original", originFileName + suffix);
            }

            return storageState;
        } catch (IOException e) {
        }
        return new BaseState(false, AppInfo.IO_ERROR);
    }

    private static boolean validType(String type, String[] allowTypes) {
        List<String> list = Arrays.asList(allowTypes);

        return list.contains(type);
    }
}
