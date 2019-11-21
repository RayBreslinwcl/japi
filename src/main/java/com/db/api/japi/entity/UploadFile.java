package com.db.api.japi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "v_upload_file")
public class UploadFile {
    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long id;
    private String id;

    @Column(name = "target_path",nullable = false)
    private String target_path;
    @Column(name = "name")
    private String name;
    @Column(name = "parent_id")
    private String parent_id;
    @Column(name = "tag")
    private String tag;

    //文件大小
    @Column(name="file_size")
    private Long fileSize;

    @Column(name="file_type")
    private String fileType;

    //文件夹类型 0:文件 1:普通文件夹
    @Column(name="file_folder")
    private String fileFolder;

    //绝对源路径
    @Column(name="source_path")
    private String sourcePath;


    @Column(name="upload_task_id")
    private String uploadTaskId;

    //任务目录id
    @Column(name="task_folder_id")
    private String taskFolderId;

    //是否转码（1：是）
    @Column(name="transcode")
    private String transcode;

    @Column(name="media_id")
    private String mediaId;

    @Column(name="group_id")
    private String groupId;


    @Column(name="create_date")
    private String createDate;

    @Column(name="create_user")
    private String createUser;

    @Override
    public String toString() {
        return "UploadFile{" +
                "id='" + id + '\'' +
                ", target_path='" + target_path + '\'' +
                ", name='" + name + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", tag='" + tag + '\'' +
                ", fileSize=" + fileSize +
                ", fileType='" + fileType + '\'' +
                ", fileFolder='" + fileFolder + '\'' +
                ", sourcePath='" + sourcePath + '\'' +
                ", uploadTaskId='" + uploadTaskId + '\'' +
                ", taskFolderId='" + taskFolderId + '\'' +
                ", transcode='" + transcode + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", createDate='" + createDate + '\'' +
                ", createUser='" + createUser + '\'' +
                '}';
    }

    //    public  String  ToString()
//    {
//        return bookName + "-" + describe;
//    }

}
