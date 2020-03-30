package com.springmvcstudy.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
//@RequestMapping("/fileUpload")
public class FileUploadController {

    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request){
        String path=request.getSession().getServletContext().getRealPath("file");
        File file=new File(path);
        String[] fileArrays=file.list();
        request.setAttribute("fileArrays",fileArrays);
        return "fileUpload";
    }

    /**
     * 单文件上传
     * @param singleFile
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "singleFileUpload",method = RequestMethod.POST)
    public String singleFileUpload(@RequestParam("singleFile")MultipartFile singleFile, HttpServletRequest request) throws Exception{
        //获取文件的大小来判断是否有文件上传
        if(singleFile.getSize()>0){
            //获取保存上传文件的 file 文件夹绝对路径
            String path=request.getSession().getServletContext().getRealPath("file");
            //获取上传文件名
            String fileName=singleFile.getOriginalFilename();
            File file=new File(path,fileName);
            singleFile.transferTo(file);
            //保存上传之后的文件路径
            request.setAttribute("filePath","file/"+fileName);

            File fileList=new File(path);
            String[] fileArrays=fileList.list();
            request.setAttribute("fileArrays",fileArrays);

            return "fileUpload";
        }
        return "err";
    }

    /**
     * 多文件上传
     * @param multiFile
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/multiFileUpload",method = RequestMethod.POST)
    public String multiFileUpload(@RequestParam("multiFile")MultipartFile[] multiFile,HttpServletRequest request) throws Exception{
        List<String> filePaths = new ArrayList<String>();
        for (MultipartFile temp : multiFile) {
            if (temp.getSize() > 0) {
                String path = request.getSession().getServletContext().getRealPath("file");
                String fileName = temp.getOriginalFilename();
                File file = new File(path, fileName);
                filePaths.add("file/"+fileName);
                temp.transferTo(file);
            }else{
                return "err";
            }
        }
        request.setAttribute("filePaths", filePaths);

        String path=request.getSession().getServletContext().getRealPath("file");
        File file=new File(path);
        String[] fileArrays=file.list();
        request.setAttribute("fileArrays",fileArrays);

        return "fileUpload";
    }

    /**
     * 文件下载
     * @param fileName
     * @param request
     * @param response
     */
    @RequestMapping("/download")
    public void download(@RequestParam("fileName")String fileName, HttpServletRequest request, HttpServletResponse response){
        if(fileName!=null){
            //获取 file 绝对路径
            String realPath = request.getServletContext().getRealPath("file/");
            File file = new File(realPath,fileName);
            OutputStream out = null;
            if(file.exists()){
                //设置下载完毕不打开文件
                response.setContentType("application/force-download");
                //设置文件名
                response.setHeader("Content-Disposition", "attachment;filename="+fileName);
                try {
                    out = response.getOutputStream();
                    out.write(FileUtils.readFileToByteArray(file));
                    out.flush();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }finally{
                    if(out != null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
