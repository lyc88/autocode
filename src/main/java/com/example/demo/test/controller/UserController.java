package com.example.demo.test.controller;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deepoove.poi.XWPFTemplate;
import com.example.demo.bean.*;
import com.example.demo.test.entity.AntArea;
import com.example.demo.test.entity.AntCategory;
import com.example.demo.test.entity.AntQualificationType;
/*import com.example.demo.test.service.AntAreaService;
import com.example.demo.test.service.AntCategoryService;*/

import com.google.common.collect.Lists;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.User;
import com.example.demo.test.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
* 
* @author lyc
* @date 2020-07-01 17:19:03
*/
@Api(value = "",tags={"操作接口"})
@RestController
public class UserController{

    @Autowired
    private UserService userService;


    @RequestMapping("user/export")
    public void exportUser(HttpServletResponse httpServletResponse){
        List<User> list = userService.list();
        List<Map> rows = Lists.newArrayList();
        list.forEach(e->{
            Map row = new HashMap();
            row.put("姓名",e.getName());
            row.put("年龄",e.getAge());
            rows.add(row);
        });
        ExcelUtils.exportExcel(httpServletResponse,"用户列表",rows);
    }

   /* @Autowired
    private AntAreaService antAreaService;

    @RequestMapping("antArea/import")
    public void exportAntArea(MultipartFile file){
        antAreaService.remove(null);
        List<Map<String, Object>> mapList = ExcelUtils.importExcel(file);
        ArrayList<AntArea> antAreas = Lists.newArrayListWithCapacity(mapList.size());
        mapList.forEach(e->{
            AntArea antArea = new AntArea();
            String s = String.valueOf(e.get("地区标示符"));

            boolean aNull = Objects.equals(s, "null");
            antArea.setIdentification(aNull?"":s);
            antArea.setShortName(String.valueOf(e.get("中文简称")));
            antArea.setAreaCode(String.valueOf(e.get("地区码")));
            antArea.setShortPinyin(String.valueOf(e.get("拼音")));
            antArea.setFullPinyin(String.valueOf(e.get("地区全称中文名")));
            antArea.setFullName(String.valueOf(e.get("区域名称")));
            antArea.setParentCode(String.valueOf(e.get("上级区域编码")));
            antArea.setInitials(String.valueOf(e.get("地区全称拼音")));
            antArea.setAreaType(Integer.valueOf(String.valueOf(e.get("区域类型"))));
            antArea.setCreateBy("");
            antArea.setCreateTime(0L);
            antArea.setUpdateBy("");
            antArea.setUpdateTime(0L);
            antAreas.add(antArea);
        });
        antAreaService.saveBatch(antAreas);
    }

    @Autowired
    private AntCategoryService antCategoryService;

    @RequestMapping("antCategory/import")
    public void exportAntCategory(MultipartFile file){
        antCategoryService.remove(null);
        List<Map<String, Object>> mapList = ExcelUtils.importExcel(file);


        ArrayList<AntCategoryDTO> antCategoryDTOS = Lists.newArrayList();
        mapList.forEach(e->{
            String c1 = String.valueOf(e.get("一级门店类目"));
            String c2 = String.valueOf(e.get("二级门店类目"));
            String c3 = String.valueOf(e.get("三级门店类目"));
            String c1code = String.valueOf(e.get("一级门店编码"));
            String c2code = String.valueOf(e.get("二级门店编码"));
            String c3code = String.valueOf(e.get("三级门店编码"));

            String mmcCde = String.valueOf(e.get("MCC码"));

            String review = String.valueOf(e.get("是否审核"));

            String standard = String.valueOf(e.get("门店类目认证标准"));
            String group = String.valueOf(e.get("门店资质组名称"));

            String businessSide = String.valueOf(e.get("门店业务方"));

            AntCategoryDTO antCategoryDTO = new AntCategoryDTO();
            antCategoryDTO.setC1(c1);
            antCategoryDTO.setC2(c2);
            antCategoryDTO.setC3(c3);
            antCategoryDTO.setC1code(c1code);
            antCategoryDTO.setC2code(c2code);
            antCategoryDTO.setC3code(c3code);
            antCategoryDTO.setMmcCde(mmcCde);
            antCategoryDTO.setReview(review);
            antCategoryDTO.setStandard(standard);
            antCategoryDTO.setGroup(group);
            antCategoryDTO.setBusinessSide(businessSide);

            antCategoryDTOS.add(antCategoryDTO);

        });
        //antAreas.saveBatch(antCategories);

        Map<String, List<AntCategoryDTO>> c1Map = antCategoryDTOS.stream().collect(Collectors.groupingBy(e -> e.getC1()));
        ArrayList<AntCategory> antCategories = Lists.newArrayList();
        for (Map.Entry<String,List<AntCategoryDTO>> entry:c1Map.entrySet()){
            // 一级

            AntCategoryDTO antCategoryDTO = entry.getValue().get(0);
            AntCategory antCategory = new AntCategory();
            antCategory.setCategoryName(antCategoryDTO.getC1());
            antCategory.setCategoryCode(antCategoryDTO.getC1code());
            antCategory.setMmcCode(antCategoryDTO.getMmcCde());
            antCategory.setReview(Objects.equals("是",antCategoryDTO.getReview())?1:2);
            antCategory.setCategoryCertificationStandards(antCategoryDTO.getStandard());
            antCategory.setQualificationGroup(antCategoryDTO.getGroup());
            antCategory.setStoreBusiness(antCategoryDTO.getBusinessSide());
            antCategory.setParentCode("");
            antCategory.setCreateBy("");
            antCategory.setCreateTime(0L);
            antCategory.setUpdateBy("");
            antCategory.setUpdateTime(0L);

            antCategories.add(antCategory);
        }
        // 二级
        for (Map.Entry<String,List<AntCategoryDTO>> entry:c1Map.entrySet()){

            List<AntCategoryDTO> antCategoryDTOList = entry.getValue();

            antCategoryDTOList.forEach(e->{

                AntCategory antCategory = new AntCategory();

                antCategory.setCategoryName(e.getC2());
                antCategory.setCategoryCode(e.getC2code());
                antCategory.setMmcCode(e.getMmcCde());
                antCategory.setReview(Objects.equals("是",e.getReview())?1:2);
                antCategory.setCategoryCertificationStandards(e.getStandard());
                antCategory.setQualificationGroup(e.getGroup());
                antCategory.setStoreBusiness(e.getBusinessSide());
                antCategory.setParentCode(e.getC1code());
                antCategory.setCreateBy("");
                antCategory.setCreateTime(0L);
                antCategory.setUpdateBy("");
                antCategory.setUpdateTime(0L);

                antCategories.add(antCategory);
            });

        }

        Map<String, List<AntCategoryDTO>> c2Map = antCategoryDTOS.stream().collect(Collectors.groupingBy(e -> e.getC2()));

        for (Map.Entry<String,List<AntCategoryDTO>> entry:c2Map.entrySet()){

            List<AntCategoryDTO> antCategoryDTOList = entry.getValue();

            antCategoryDTOList.forEach(e->{

                AntCategory antCategory = new AntCategory();

                antCategory.setCategoryName(e.getC3());
                antCategory.setCategoryCode(e.getC3code());
                antCategory.setMmcCode(e.getMmcCde());
                antCategory.setReview(Objects.equals("是",e.getReview())?1:2);
                antCategory.setCategoryCertificationStandards(e.getStandard());
                antCategory.setQualificationGroup(e.getGroup());
                antCategory.setStoreBusiness(e.getBusinessSide());
                antCategory.setParentCode(e.getC2code());
                antCategory.setCreateBy("");
                antCategory.setCreateTime(0L);
                antCategory.setUpdateBy("");
                antCategory.setUpdateTime(0L);

                antCategories.add(antCategory);
            });

        }
        antCategoryService.saveBatch(antCategories);
       // System.out.println(antCategoryDTOS);
    }
*/
   /* @Autowired
    private AntQualificationTypeService antQualificationTypeService;

    @RequestMapping("antQualificationType/import")
    public void exportAntQualificationType(MultipartFile file){
        List<Map<String, Object>> mapList = ExcelUtils.importExcel(file);
        ArrayList<AntQualificationType> antQualificationTypes = Lists.newArrayListWithCapacity(mapList.size());

        mapList.forEach(e->{
            String name = String.valueOf(e.get("行业资质类型"));
            String code = String.valueOf(e.get("对应code"));
            AntQualificationType antQualificationType = new AntQualificationType();
            antQualificationType.setCertType(name);
            antQualificationType.setCertCode(code);
            antQualificationType.setCreateBy("");
            antQualificationType.setCreateTime(0L);
            antQualificationType.setUpdateBy("");
            antQualificationType.setUpdateTime(0L);
            antQualificationTypes.add(antQualificationType);
        });
        antQualificationTypeService.saveBatch(antQualificationTypes);
    }*/

    @RequestMapping("user/import")
    public Result importUser(MultipartFile file){
        List<Map<String, Object>> mapList = ExcelUtils.importExcel(file);
        List<User> userList =  Lists.newArrayList();
        mapList.forEach(e->{
            String name = String.valueOf(e.get("姓名"));
            Integer age = Integer.parseInt(String.valueOf(e.get("年龄")));
            User user = new User();
            user.setId(1);
            user.setAge(age);
            user.setName(name);
            userList.add(user);
        });
        userService.saveBatch(userList);
        return Result.ok();
    }


    @RequestMapping("user/exportTpl")
    public void exportUserTpl(HttpServletResponse httpServletResponse){
        List<String> hearder = Lists.newArrayList();
        hearder.add("用户名");
        hearder.add("年级");
        ExcelUtils.exportExcelTpl(httpServletResponse,"用户模板",hearder);
    }


    @RequestMapping("user/list")
    public Result list(HttpServletResponse response) throws Exception {

       XWPFTemplate template = XWPFTemplate.compile("D:\\test.docx").render(
                new HashMap<String, Object>(){{
                    put("title", "Hi, poi-tl Word模板引擎");
                }});
     /*   FileOutputStream out = new FileOutputStream("output.docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();*/

        //response.setContentType("application/msword");
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-disposition","attachment;filename=\""+"out_template.docx"+"\"");

        OutputStream out = response.getOutputStream();
        // 下面这行 加上会有乱码 字符流的原因
        //BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(out);
        template.close();
        out.flush();
        out.close();
        return Result.ok(userService.list());
    }


    @RequestMapping("user/save")
    public Result save(@Validated @RequestBody User user){
        return Result.ok(userService.save(user));
    }

    @RequestMapping("user/update")
    public Result<String> update(/*@Validated  User user*/){
        //return new Result<>(1,"s",null);
        return Result.ok();
    }

    @RequestMapping("user/get")
    public com.example.demo.bean.User get(/*@Validated  User user*/){
     return new com.example.demo.bean.User();
    }
}