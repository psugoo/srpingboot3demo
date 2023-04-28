package com.wtkj.springbootdemo.utils;


import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;


public class FileUtils {


    /**
     * 判断文件是否存在
     *
     * @param path 文件路径
     * @return -1 不存在
     * @return 1 存在
     * @return
     */

    public static Integer fileIsExists(String path) {

        Integer a = 0;

        File file = new File(path);

        if (file.exists()) {
            a = 1;
        } else {
            a = -1;
        }

        return a;

    }


    public static String uploadMyFile(MultipartFile scene_pic, HttpServletRequest request) {

        String result = "";

        String originalFilename = scene_pic.getOriginalFilename(); // 原始名称

        if (Assert.notNull(scene_pic)) {

            String basePath = "/common/attachment/myResources/" + FileUtils.fileRename() + "." + originalFilename.split("[.]")[1];

            String filePathName = request.getSession().getServletContext()
                    .getRealPath(basePath);

            File file = new File(filePathName);
            if (!file.exists()) {
                file.mkdirs();
            }


            File newFile = new File(filePathName);

            // 将内存中的数据写入磁盘

            try {
                scene_pic.transferTo(newFile);

            } catch (Exception e) {
                // TODO: handle exception
            }

            result = basePath;

        }// 资源不为空

        return result;

    }

    public static String uploadMyInformation(MultipartFile scene_pic, HttpServletRequest request) {

        String result = "";

        String originalFilename = scene_pic.getOriginalFilename(); // 原始名称

        if (Assert.notNull(scene_pic)) {

            String basePath = "/common/attachment/information/" + FileUtils.fileRename() + "." + originalFilename.split("[.]")[1];

            String filePathName = request.getSession().getServletContext()
                    .getRealPath(basePath);

            File file = new File(filePathName);
            if (!file.exists()) {
                file.mkdirs();
            }


            File newFile = new File(filePathName);

            // 将内存中的数据写入磁盘

            try {
                scene_pic.transferTo(newFile);

            } catch (Exception e) {
                // TODO: handle exception
            }

            result = basePath;

        }// 资源不为空

        return result;

    }

    public static String uploadMyRulesRegulations(MultipartFile scene_pic, HttpServletRequest request) {

        String result = "";

        String originalFilename = scene_pic.getOriginalFilename(); // 原始名称

        if (Assert.notNull(scene_pic)) {

            String basePath = "/common/attachment/rulesregulations/" + FileUtils.fileRename() + "." + originalFilename.split("[.]")[1];

            String filePathName = request.getSession().getServletContext()
                    .getRealPath(basePath);

            File file = new File(filePathName);
            if (!file.exists()) {
                file.mkdirs();
            }


            File newFile = new File(filePathName);

            // 将内存中的数据写入磁盘

            try {
                scene_pic.transferTo(newFile);

            } catch (Exception e) {
                // TODO: handle exception
            }

            result = basePath;

        }// 资源不为空

        return result;

    }

    public static String uploadMyEmployeehandbook(MultipartFile scene_pic, HttpServletRequest request) {

        String result = "";

        String originalFilename = scene_pic.getOriginalFilename(); // 原始名称

        if (Assert.notNull(scene_pic)) {

            String basePath = "/common/attachment/employeehandbook/" + FileUtils.fileRename() + "." + originalFilename.split("[.]")[1];

            String filePathName = request.getSession().getServletContext()
                    .getRealPath(basePath);

            File file = new File(filePathName);
            if (!file.exists()) {
                file.mkdirs();
            }


            File newFile = new File(filePathName);

            // 将内存中的数据写入磁盘

            try {
                scene_pic.transferTo(newFile);

            } catch (Exception e) {
                // TODO: handle exception
            }

            result = basePath;

        }// 资源不为空

        return result;

    }

    public static String fileRename(){
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * 财务文件导入
     *
     * @param scene_pic
     * @param request
     * @return
     */
    public static String uploadMyFileForCaiWu(MultipartFile scene_pic, HttpServletRequest request) {

        String result = "";

        UUID uuid = UUID.randomUUID();

        String originalFilename = uuid + "&wantukeji&" + scene_pic.getOriginalFilename(); // 原始名称

        if (Assert.notNull(scene_pic)
                && Assert.notNullOrEmpty(originalFilename)) {

            String basePath = "/common/upload/caiwu/" + originalFilename;

            String filePathName = request.getSession().getServletContext()
                    .getRealPath(basePath);

            File file = new File(filePathName);
            if (!file.exists()) {
                file.mkdirs();
            }


            File newFile = new File(filePathName);

            // 将内存中的数据写入磁盘

            try {
                scene_pic.transferTo(newFile);

            } catch (Exception e) {
                // TODO: handle exception
            }

            result = basePath;

        }// 资源不为空

        return result;

    }

    /**
     * 员工入职合同导入
     * @param scene_pic
     * @param request
     * @return
     */
//	public static String uploadMyFileForAddPerson(MultipartFile scene_pic, HttpServletRequest request) {
//
//		String result = "";
//
//		UUID uuid = UUID.randomUUID();
//
//		String originalFilename = uuid + "&wantukeji&"+ scene_pic.getOriginalFilename(); // 原始名称
//
//		if (Assert.notNull(scene_pic)
//				&& Assert.notNullOrEmpty(originalFilename)) {
//
//			String basePath ="/common/upload/employeecontract/" + originalFilename;
//
//			String filePathName = request.getSession().getServletContext()
//					.getRealPath(basePath);
//
//			File file = new File(filePathName);
//			if(!file.exists()){
//				file.mkdirs();
//			}
//
//
//			File newFile = new File(filePathName);
//
//			// 将内存中的数据写入磁盘
//
//			try {
//				scene_pic.transferTo(newFile);
//
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//
//			result = basePath ;
//
//		}// 资源不为空
//
//		return result;
//
//	}

    /**
     * @param type  1:请假
     * @param id    用户工号
     * @param files 上传图片
     * @return
     */
    public static String[] saveImage(int type, int id, MultipartFile[] files, HttpServletRequest request) {
        String[] result = new String[files.length];

        String basePath = VacatonConf.VACATION_PATH;

        for (int i = 0; i < files.length; i++) {
            String originalFilename = files[i].getOriginalFilename(); // 原始名称


            String filePathName = request.getSession().getServletContext().getRealPath(basePath);


            // 新的图片名称
            String newFileName = type
                    + "_"
                    + id
                    + "_"
                    + RandomUtils.random_range(0000000, 9999999)
                    + "_"
                    + originalFilename.substring(originalFilename
                    .lastIndexOf("."));


            File newFile = new File(filePathName + "" + newFileName); // 新图片


            try {
                files[i].transferTo(newFile);

            } catch (Exception e) {
                e.printStackTrace();
            }

			result[i] = basePath + "" + newFileName;

        }


        return result;

    }

    /**
     * @param type  1:请假
     * @param id    用户工号
     * @param files 上传图片
     * @return
     */
    public static String[] saveImageForLizhi(int type, int id, MultipartFile[] files, HttpServletRequest request) {
        String[] result = new String[files.length];

        String basePath = VacatonConf.VACATION_PATH;

        for (int i = 0; i < files.length; i++) {
            String originalFilename = files[i].getOriginalFilename(); // 原始名称


            String filePathName = request.getSession().getServletContext().getRealPath(basePath);


            // 新的图片名称
            String newFileName =  originalFilename;


            File newFile = new File(filePathName + "" + newFileName); // 新图片


            try {
                files[i].transferTo(newFile);

            } catch (Exception e) {
                e.printStackTrace();
            }

            result[i] = basePath + "" + newFileName;

        }


        return result;

    }

    /**
     * 员工花名册上传pdf
     */
    public static String[] saveUserInfoFile(String userName, int userId, MultipartFile[] files, HttpServletRequest request) {
        String[] result = new String[files.length];

        String basePath = VacatonConf.VACATION_PATH;

        for (int i = 0; i < files.length; i++) {
            String originalFilename = files[i].getOriginalFilename(); // 原始名称


            String filePathName = request.getSession().getServletContext().getRealPath(basePath);


            // 新的图片名称
            String newFileName = userId
                    + "_"
                    + userName
                    + "_"
                    + originalFilename;


            File newFile = new File(filePathName + "" + newFileName); // 新图片


            try {
                files[i].transferTo(newFile);

            } catch (Exception e) {
                e.printStackTrace();
            }

            result[i] = basePath + "" + newFileName;

        }


        return result;

    }

    public static String integration(HttpServletRequest request, HSSFWorkbook wb, List<ResignedpersonnelselectexportVo> list, PersonnelMattersVo vo){

        String tempFilePath = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DatePattern.PURE_DATETIME_PATTERN));
        String tempPath = GlobalConfig.TEMP_PATH;

        // 在 /common/source/temp/PanoramaData/场景名称 目录下创建三个路径（/cartoon、/excel和/source）分别用于存放excel文档、资源文件、小人物动画
        String excelDirPath = tempPath + tempFilePath + "/excel";
        String sourceDirPath = tempPath + tempFilePath + "/files";


        String realityExcelDir = request.getSession().getServletContext().getRealPath(excelDirPath);
        String realitySourceDir = request.getSession().getServletContext().getRealPath(sourceDirPath);


        File batchExcelFile = new File(realityExcelDir);
        File batchSourceFile = new File(realitySourceDir);


        if(!batchExcelFile.exists()){
            batchExcelFile.mkdirs();
        }
        if(!batchSourceFile.exists()){
            batchSourceFile.mkdirs();
        }

        if(1 == vo.getUserBaseInfomationFlag()){
            //导出excel文件
            FileOutputStream excelOutput = null;

            try {
                //将EXCEL文件写入磁盘
                excelOutput =new FileOutputStream(realityExcelDir+"/员工花名册.xls");
                wb.write(excelOutput);

            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(Assert.notNull(excelOutput)){
                    try {
                        excelOutput.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if(1 == vo.getPdfDwonloadFlag()){
            //处理花名册附件 BEGIN
            ResignedpersonnelselectexportVo info = new ResignedpersonnelselectexportVo();
            String realityPdfPath = "";

            for(int i = 0;i < list.size();i ++){
                info = list.get(i);

                if(Assert.notNull(info.getFileAddresses()) && 0 < info.getFileAddresses().size()){
                    for (int j = 0; j < info.getFileAddresses().size(); j++) {
                        String pdfPath = info.getFileAddresses().get(j);
                        realityPdfPath = request.getSession().getServletContext().getRealPath(pdfPath);

                        File pdfFile = new File(realityPdfPath);

                        if(pdfFile.exists()){
                            try {
                                String[] split = info.getFileAddresses().get(j).split("/");
                                String filename = split[split.length -1];

                                File personalFilePath = new File(realitySourceDir + "/" + info.getUserId() + "_" + info.getRealName());
                                if(!personalFilePath.exists()){
                                    personalFilePath.mkdirs();
                                }

                                copyFile(realityPdfPath, personalFilePath + "/" + filename);  //将场景资源文件复制到临时目录下
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }

        }

        //处理二级场景资源文件 END

        String srcFile = request.getSession().getServletContext().getRealPath(tempPath + "/" + tempFilePath);
        String dest = request.getSession().getServletContext().getRealPath(tempPath + "/" + tempFilePath +".zip");//生成的压缩文件路径

        try {
            ZipUtils.zip(srcFile, dest, null);//将单个场景进行加密压缩
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            delAllFile(new File(srcFile));
        }

        return dest;
    }

    public static void copyDir(String sourcePath, String newPath) throws IOException {
        File file = new File(sourcePath);
        String[] filePath = file.list();

        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();
        }

        for (int i = 0; i < filePath.length; i++) {
            if ((new File(sourcePath + file.separator + filePath[i])).isDirectory()) {
                copyDir(sourcePath  + file.separator  + filePath[i],newPath  + file.separator + filePath[i]);
            }

            if (new File(sourcePath  + file.separator + filePath[i]).isFile()) {
                copyFile(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }

        }
    }

    public static void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);;

        byte[] buffer=new byte[2097152];
        int readByte = 0;
        while((readByte = in.read(buffer)) != -1){
            out.write(buffer, 0, readByte);
        }

        in.close();
        out.close();
    }

    private static void delAllFile(File directory){
        if (!directory.isDirectory()){
            directory.delete();
        } else{
            File [] files = directory.listFiles();

            // 空文件夹
            if (files.length == 0){
                directory.delete();
                return;
            }

            // 删除子文件夹和子文件
            for (File file : files){
                if (file.isDirectory()){
                    delAllFile(file);
                } else {
                    file.delete();
                }
            }

            // 删除文件夹本身
            directory.delete();
        }
    }

    public static String integration2(HttpServletRequest request, HSSFWorkbook wb, List<ResignedpersonnelselectexportVo> list, PersonnelMattersVo vo){

        String tempFilePath = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DatePattern.PURE_DATETIME_PATTERN));
        String tempPath = GlobalConfig.TEMP_PATH;

        // 在 /common/source/temp/PanoramaData/场景名称 目录下创建三个路径（/cartoon、/excel和/source）分别用于存放excel文档、资源文件、小人物动画
        String excelDirPath = tempPath + tempFilePath + "/excel";
        String sourceDirPath = tempPath + tempFilePath + "/files";


        String realityExcelDir = request.getSession().getServletContext().getRealPath(excelDirPath);
        String realitySourceDir = request.getSession().getServletContext().getRealPath(sourceDirPath);


        File batchExcelFile = new File(realityExcelDir);
        File batchSourceFile = new File(realitySourceDir);


        if(!batchExcelFile.exists()){
            batchExcelFile.mkdirs();
        }
        if(!batchSourceFile.exists()){
            batchSourceFile.mkdirs();
        }

        if(1 == vo.getUserBaseInfomationFlag()){
            //导出excel文件
            FileOutputStream excelOutput = null;

            try {
                //将EXCEL文件写入磁盘
                excelOutput =new FileOutputStream(realityExcelDir+"/员工花名册.xls");
                wb.write(excelOutput);

            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(Assert.notNull(excelOutput)){
                    try {
                        excelOutput.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if(1 == vo.getPdfDwonloadFlag()){
            //处理花名册附件 BEGIN
            ResignedpersonnelselectexportVo info = new ResignedpersonnelselectexportVo();
            String realityPdfPath = "";

            for(int i = 0;i < list.size();i ++){
                info = list.get(i);

                if(Assert.notNull(info.getFileAddresses()) && 0 < info.getFileAddresses().size()){
                    for (int j = 0; j < info.getFileAddresses().size(); j++) {
                        String pdfPath = info.getFileAddresses().get(j);
                        realityPdfPath = request.getSession().getServletContext().getRealPath(pdfPath);

                        File pdfFile = new File(realityPdfPath);

                        if(pdfFile.exists()){
                            try {
                                String[] split = info.getFileAddresses().get(j).split("/");
                                String filename = split[split.length -1];
                                copyFile(realityPdfPath, realitySourceDir + "/" + filename);  //将场景资源文件复制到临时目录下
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }

        }

        String srcFile = request.getSession().getServletContext().getRealPath(tempPath + "/" + tempFilePath);
        String dest = request.getSession().getServletContext().getRealPath(tempPath + "/" + tempFilePath +".zip");//生成的压缩文件路径

        try {
            ZipUtils.zip(srcFile, dest, null);//将单个场景进行加密压缩
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            delAllFile(new File(srcFile));
        }

        return dest;
    }

    public static String resignedpersonnelselectexportDownload(HttpServletRequest request, XSSFWorkbook wb, List<ResignedpersonnelselectexportVo> list, DemissionSelectVo vo) {
        String tempFilePath = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DatePattern.PURE_DATETIME_PATTERN));
        String tempPath = GlobalConfig.TEMP_PATH;

        // 在 /common/source/temp/PanoramaData/场景名称 目录下创建三个路径（/cartoon、/excel和/source）分别用于存放excel文档、资源文件、小人物动画
        String excelDirPath = tempPath + tempFilePath + "/excel";
        String sourceDirPath = tempPath + tempFilePath + "/files";


        String realityExcelDir = request.getSession().getServletContext().getRealPath(excelDirPath);
        String realitySourceDir = request.getSession().getServletContext().getRealPath(sourceDirPath);


        File batchExcelFile = new File(realityExcelDir);
        File batchSourceFile = new File(realitySourceDir);


        if(!batchExcelFile.exists()){
            batchExcelFile.mkdirs();
        }
        if(!batchSourceFile.exists()){
            batchSourceFile.mkdirs();
        }

        if(1 == vo.getUserBaseInfomationFlag()){
            //导出excel文件
            FileOutputStream excelOutput = null;

            try {
                //将EXCEL文件写入磁盘
                excelOutput =new FileOutputStream(realityExcelDir+"/离职员工花名册.xls");
                wb.write(excelOutput);

            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(Assert.notNull(excelOutput)){
                    try {
                        excelOutput.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if(1 == vo.getPdfDwonloadFlag()){
            //处理花名册附件 BEGIN
            ResignedpersonnelselectexportVo info = new ResignedpersonnelselectexportVo();
            String realityPdfPath = "";

            for(int i = 0;i < list.size();i ++){
                info = list.get(i);

                if(Assert.notNull(info.getFileAddresses()) && 0 < info.getFileAddresses().size()){
                    for (int j = 0; j < info.getFileAddresses().size(); j++) {
                        String pdfPath = info.getFileAddresses().get(j);
                        realityPdfPath = request.getSession().getServletContext().getRealPath(pdfPath);

                        File pdfFile = new File(realityPdfPath);

                        if(pdfFile.exists()){
                            try {
                                String[] split = info.getFileAddresses().get(j).split("/");
                                String filename = split[split.length -1];

                                File personalFilePath = new File(realitySourceDir + "/" + info.getUserId() + "_" + info.getRealName());
                                if(!personalFilePath.exists()){
                                    personalFilePath.mkdirs();
                                }

                                copyFile(realityPdfPath, personalFilePath + "/" + filename);  //将场景资源文件复制到临时目录下
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                if(Assert.notNull(info.getUserLizhiFujianList()) && 0 < info.getUserLizhiFujianList().size()){
                    for (int j = 0; j < info.getUserLizhiFujianList().size(); j++) {
                        String pdfPath = info.getUserLizhiFujianList().get(j);
                        realityPdfPath = request.getSession().getServletContext().getRealPath(pdfPath);

                        File pdfFile = new File(realityPdfPath);

                        if(pdfFile.exists()){
                            try {
                                String[] split = info.getUserLizhiFujianList().get(j).split("/");
                                String filename = split[split.length -1];

                                File personalFilePath = new File(realitySourceDir + "/lizhi_" + info.getUserId() + "_" + info.getRealName());
                                if(!personalFilePath.exists()){
                                    personalFilePath.mkdirs();
                                }

                                copyFile(realityPdfPath, personalFilePath + "/" + filename);  //将场景资源文件复制到临时目录下
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }

        }

        //处理二级场景资源文件 END

        String srcFile = request.getSession().getServletContext().getRealPath(tempPath + "/" + tempFilePath);
        String dest = request.getSession().getServletContext().getRealPath(tempPath + "/" + tempFilePath +".zip");//生成的压缩文件路径

        try {
            ZipUtils.zip(srcFile, dest, null);//将单个场景进行加密压缩
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            delAllFile(new File(srcFile));
        }

        return dest;
    }


    /**
     * 保险文件导入
     *
     * @param scene_pic
     * @param request
     * @return
     */
    public static String uploadMyFileForBaoxian(MultipartFile scene_pic, HttpServletRequest request) {

        String result = "";

        UUID uuid = UUID.randomUUID();

        String originalFilename = uuid + "-" + scene_pic.getOriginalFilename(); // 原始名称

        if (Assert.notNull(scene_pic)
                && Assert.notNullOrEmpty(originalFilename)) {

            String basePath = "/common/upload/baoxian/" + originalFilename;

            String filePathName = request.getSession().getServletContext()
                    .getRealPath(basePath);

            File file = new File(filePathName);
            if (!file.exists()) {
                file.mkdirs();
            }


            File newFile = new File(filePathName);

            // 将内存中的数据写入磁盘

            try {
                scene_pic.transferTo(newFile);

            } catch (Exception e) {
                // TODO: handle exception
            }

            result = basePath;

        }// 资源不为空

        return result;

    }
}
