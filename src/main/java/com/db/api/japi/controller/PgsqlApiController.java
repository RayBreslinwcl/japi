package com.db.api.japi.controller;

import com.db.api.japi.entity.UploadFile;
import com.db.api.japi.service.PgsqlApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/japi")
public class PgsqlApiController {

    private Logger logger = LoggerFactory.getLogger(PgsqlApiController.class);

    @Autowired
    PgsqlApiService pgsqlApiService;


    /**
     * api-01：通过文件夹id获得下面所有文件和文件夹
     * @param id 父文件夹id
     * @return 返回所有文件和文件夹
     */
//    @RequestMapping(value = "/uploadfile/{id}")
//    @ResponseBody
//    public List<UploadFile> getFilesInFolder(@PathVariable("id") String id){
//        List<UploadFile> filesInFolder = pgsqlApiService.getFilesInFolder(id);
//        return filesInFolder;
//    }
    //@RequestParamMap
    @RequestMapping(value = "/uploadfile") //RequestParam ("username")
    @ResponseBody
    public List<UploadFile> getFilesInFolder( @RequestParam (name ="id") String id){

        if (logger.isTraceEnabled()){
            logger.trace("Function getFilesInFolder is called");
        }

        List<UploadFile> filesInFolder=new ArrayList<UploadFile>();

        try {
            filesInFolder = pgsqlApiService.getFilesInFolder(id);
        }catch (Exception e){
            logger.error(e.toString());
        }

        return filesInFolder;
    }

    /**
     * 1.1 依据task_id，获得对应文件夹。然后，获得该文件夹下的所有文件和文件夹
     * @param task_id
     * @return
     */
    @RequestMapping(value = "/uploadfile_task_id")
    @ResponseBody
    public List<UploadFile> getFilesInTask( @RequestParam (name ="task_id") String task_id){

        if (logger.isTraceEnabled()){
            logger.trace("Function getFilesInTask is called");
        }
        List<UploadFile> filesInTask=new ArrayList<UploadFile>();
        try {
            filesInTask = pgsqlApiService.getFilesInTask(task_id);
        }catch (Exception e){
            logger.error(e.toString());
        }

        return filesInTask;
    }

}
