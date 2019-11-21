package com.db.api.japi.service;

import com.db.api.japi.entity.UploadFile;
import com.db.api.japi.respository.UploadFileRepository;
//import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class PgsqlApiService {

    @Autowired
    UploadFileRepository uploadFileRepository;

    private Log log= LogFactory.getLog(PgsqlApiService.class);

    /**
     * 1.获取对应id文件夹下的所有：文件和文件夹
     * @param id 父文件夹id
     * @return 返回所有文件夹下面的文件和文件夹
     */
    public List<UploadFile> getFilesInFolder(String id){
        if (log.isTraceEnabled()){
            log.trace("Function getFilesInFolder(String id) is called");
        }

        List<UploadFile> uploadFiles=uploadFileRepository.GetFilesInFolder(id);
        return uploadFiles;
    }

    /**
     * 2.依据upload_file表中的task_id，获得对应文件夹下的所有文件和文件夹
     * @param task_id
     * @return
     */
    public List<UploadFile> getFilesInTask(String task_id){
        if (log.isTraceEnabled()){
            log.trace("Function getFilesInTask(String task_id) is called");
        }

        String id=uploadFileRepository.GetIdByTaskId(task_id).getId();
        List<UploadFile> uploadFiles=uploadFileRepository.GetFilesInFolder(id);
        return uploadFiles;
    }



}
