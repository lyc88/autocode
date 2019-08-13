# autocode
代码自动生成
基于mybtisPlus 通用mapper 自动生成 实体类,mapper,service,controller 等，基本 单表 的crud 全部自动 完成，让程序员专注于业务及核心逻辑。
本项目基于springboot，freemarker 模板渲染 ，mybatisplus， 简单 快速，避免加班加点。
![模板文件](https://github.com/lyc88/autocode/blob/master/src/main/resources/static/QQ%E6%88%AA%E5%9B%BE20190813181305.png)
代码质量有待优化，毕竟半天写完。
改一下数据库连接,直接运行测试类就行 生成代码 在 test 目录下面 很容易就看到了。 例子：
```
/**
* 用户名
*
* @author lyc
* @date 2019-08-13 17:36:37
*/
@RestController
public class UserController{

    @Autowired
    private UserService userService;

    /**
    * 列表
    */
    @RequestMapping("user/list")
    public CommonResult<User> list(){
        List<User> users = userService.list(new QueryWrapper<User>());
        return new CommonResultResponse<List<User>>().ok(users);
    }

    /**
    *  id删除
    */
    @RequestMapping("user/delete")
    public CommonResult<User> delete(Integer id){
        Boolean success = userService.removeById(id);
        return new CommonResultResponse<Boolean>().ok(success);
    }

    /**
    *  id查询
    */
    @RequestMapping("user/findById")
    public CommonResult<User> findById(Integer id){
        User user = userService.getById(id);
        return new CommonResultResponse<User>().ok(user);
    }

     /**
      *  新增
      */
     @RequestMapping("user/add")
     public CommonResult<User> add(User user){
        Boolean success = userService.save(user);
        return new CommonResultResponse<Boolean>().ok(success);
     }
}
```