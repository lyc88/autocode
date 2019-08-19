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
@Api(value = "用户",tags={"用户操作接口"})
@RestController
public class UserController{

    @Autowired
    private UserService userService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("user/page")
    public CommonResult<User> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = userService.page(page);
        List<User>  userList = result.getRecords();
        return  CommonResultResponse.ok(userList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("user/list")
    public CommonResult<User> list(){
        List<User> userList = userService.list(new QueryWrapper<User>());
        return  CommonResultResponse.ok(userList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("user/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = userService.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("user/findById")
    public CommonResult<User> findById(Integer id){
        User user = userService.getById(id);
        return CommonResultResponse.ok(user);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("user/add")
     public CommonResult<Boolean> add(User user){
        Boolean success = userService.save(user);
        return CommonResultResponse.ok(success);
     }
}
```