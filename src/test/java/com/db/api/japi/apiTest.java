package com.db.api.japi;

import com.db.api.japi.entity.UploadFile;
import com.db.api.japi.service.PgsqlApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class apiTest {

    @Autowired
    PgsqlApiService pgsqlApiService;

    @Test
    public void getFileInFolderTest(){
        List<UploadFile> filesInFolder = pgsqlApiService.getFilesInFolder("370221b4bd4641e9add978497bf21899");
        for (UploadFile uploadFile : filesInFolder) {
            System.out.println("uploadFile = " + uploadFile);
        }

    }

    @Test
    public void getFileInTaskIdTest(){
        List<UploadFile> filesInTask = pgsqlApiService.getFilesInTask("fb8499c3f4fc410aabff7044d7881cac");
        for (UploadFile uploadFile : filesInTask) {
            System.out.println("uploadFile = " + uploadFile);
        }

    }

}
