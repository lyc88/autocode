# autocode
### 代码自动生成
------
* 基于mybtisPlus 通用mapper 自动生成 实体类,mapper,service,controller,xml,swagger 等 一套生成。
* 基本 单表 的crud 全部自动 完成，让程序员专注于业务及核心逻辑。
* 本项目基于springboot，freemarker 模板渲染 ，mybatisplus， 简单 快速，避免加班加点。
![模板文件](https://github.com/lyc88/autocode/blob/master/src/main/resources/static/template.png)
![接口文档](https://github.com/lyc88/autocode/blob/master/src/main/resources/static/swagger.png)
* 代码质量有待优化，毕竟半天写完。

改一下数据库连接,直接运行测试类就行 生成代码 在 test 目录下面 很容易就看到了。 例子：
```
@Api(tags={"用户表操作接口"})
@RestController
public class UmsUserController{

    @Autowired
    private UmsUserService umsUserService;

    /**
    *  用户表 分页查询
    */
    @ApiOperation("用户表分页列表")
    @GetMapping("api/v1/umsUser/page")
    public CommonResult<CommonPage<UmsUser>> pageUmsUser(UmsUserQueryParam umsUserQueryParam){
        CommonPage page = umsUserService.page(umsUserQueryParam);
        return  CommonResult.success(page);
    }



    /**
    *  id删除
    */
    @ApiOperation(value = "id删除")
    @PostMapping("api/v1/umsUserById/delete")
    public CommonResult delete(@Validated UmsUserDeleteParam  umsUserDeleteParam){
        Boolean success = umsUserService.delete(umsUserDeleteParam);
        return  CommonResult.success(success);
    }


    /**
    *  用户表更新
    */
    @ApiOperation(value = "用户表更新")
    @PostMapping("api/v1/umsUser/update")
    public CommonResult update(@Validated UmsUserUpdateParam  umsUserUpdateParam){
        Boolean success = umsUserService.update(umsUserUpdateParam);
        return  CommonResult.success(success);
    }

    /**
    *  用户表添加
    */
    @ApiOperation(value = "用户表添加")
    @PostMapping("api/v1/umsUser/add")
    public CommonResult add(@Validated UmsUserAddParam  umsUserAddParam){
        Boolean success = umsUserService.add(umsUserAddParam);
        return  CommonResult.success(success);
    }
}




@Service
public class UmsUserServiceImpl extends ServiceImpl<UmsUserMapper,UmsUser> implements  UmsUserService{

    @Override
    public CommonPage<UmsUser> page(UmsUserQueryParam umsUserQueryParam){
        Integer pageNum = umsUserQueryParam.getPageNum();
        Integer pageSize = umsUserQueryParam.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        LambdaQueryWrapper<UmsUser> lambda = new QueryWrapper<UmsUser>().lambda();
        queryCondition(lambda,umsUserQueryParam);
        List<UmsUser> umsUserList = list(lambda);
        CommonPage<UmsUser> umsUserCommonPage = CommonPage.restPage(umsUserList);
        return umsUserCommonPage;
    }

    private void queryCondition(LambdaQueryWrapper<UmsUser> lambda,UmsUserQueryParam umsUserQueryParam){

        lambda.orderByDesc(UmsUser::getUserId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean add(UmsUserAddParam umsUserAddParam){
        UmsUser umsUser = new UmsUser();
        BeanUtils.copyProperties(umsUserAddParam,umsUser);
        save(umsUser);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(UmsUserUpdateParam umsUserUpdateParam){
        UmsUser umsUser = new UmsUser();
        BeanUtils.copyProperties(umsUserUpdateParam,umsUser);
        updateById(umsUser);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UmsUserDeleteParam umsUserDeleteParam){
        removeById(umsUserDeleteParam.getUserId());
        return true;
    }
}
```