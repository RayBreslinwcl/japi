package com.db.api.japi.respository;

//import com.book.entity.BookshelfItem;
import com.db.api.japi.entity.UploadFile;
//import com.spring.backup.demo.Entity.UploadFileItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UploadFileRepository extends JpaRepository<UploadFile,String> {

    //获得所有文件数据

    /**
     * 1.获取当前id文件夹下面的所有：文件和文件夹
     * @param id
     * @return
     */
    @Query(value = "WITH RECURSIVE T  AS ( SELECT * FROM v_upload_file WHERE parent_id= :id UNION ALL SELECT  D.* FROM v_upload_file D JOIN T ON D.parent_id = T.id ) SELECT * FROM T ",nativeQuery = true)
    List<UploadFile> GetFilesInFolder(@Param("id") String id);


    /**
     * 2.依据task_id获得对应文件夹id（一个task_id对应一个id）
     * @param task_folder_id task_id的值
     * @return
     */
    @Query(value = "select * from  v_upload_file where task_folder_id = :task_folder_id",nativeQuery = true)
    UploadFile GetIdByTaskId(@Param("task_folder_id") String task_folder_id);



}

