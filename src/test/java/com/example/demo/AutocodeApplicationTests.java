package com.example.demo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.bean.TableEntity;
import com.example.demo.bean.TryAgainException;
import com.example.demo.mapper.MysqlMapper;
import com.example.demo.service.AutoCode;
import com.example.demo.service.MysqlAutoService;

import com.example.demo.test.entity.SysUsers;
import com.example.demo.test.mapper.SysUsersMapper;
import com.example.demo.test.service.SysUsersService;
import com.example.demo.utils.JacksonUtil;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutocodeApplicationTests {

	@Autowired
	private MysqlAutoService mysqlAutoService;


	@Autowired
	private AutoCode autoCode;

	@Autowired
	private SysUsersMapper sysUsersMapper;

	@Autowired
	private  MysqlMapper mysqlMapper;

	@Autowired
	private SysUsersService sysUsersService;
	@Test
	public void contextLoads() throws IOException, TemplateException {

		mysqlAutoService.autoCode("user");

	}

	@Test
	public void test01() {

		//autoCode.autoCode("sys_users");
		TableEntity tableEntity = mysqlMapper.queryTable("sys_users");

		TableEntity table = mysqlMapper.queryTable("sys_users","aa");

		System.out.println(tableEntity);

		System.out.println(table);
	}


	@Test
	public void test03() throws InterruptedException {
		sysUsersService.test();
		/*int clientTotal = 20;
		// 同时并发执行的线程数
		int threadTotal = 20;
		int count = 0;
		ExecutorService executorService = Executors.newCachedThreadPool();
		//信号量，此处用于控制并发的线程数
		final Semaphore semaphore = new Semaphore(threadTotal);
		//闭锁，可实现计数器递减
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i = 0; i < clientTotal ; i++) {
			executorService.execute(() -> {
				try {
					//执行此方法用于获取执行许可，当总计未释放的许可数不超过200时，I
					//允许通行，否则线程阻塞等待，直到获取到许可。
					semaphore.acquire();
					sysUsersService.test();
					//释放许可
					semaphore.release();
				} catch (Exception e) {
					//log.error("exception", e);
					e.printStackTrace();

				}
				//闭锁减一
				countDownLatch.countDown();
			});
		}

		countDownLatch.await();//线程阻塞，直到闭锁值为0时，阻塞才释放，继续往下执行
		executorService.shutdown();*/

	}
	// 初始化 进销存 数据 单位 分类 商品
	String unit = "jxc:unit";
	String type = "jxc:type";
	String goods = "jxc:goods";

	@Test
	public void testImport() {

		/*redisTemplate.delete(unit);
		redisTemplate.delete(type);
		redisTemplate.delete(goods);
		List<JxcTGoodsunit> jxcTGoodsunits = jxcTGoodsunitMapper.selectList(null);
		List<JxcTGoodstype> jxcTGoodstypes = jxcTGoodstypeMapper.selectList(null);
		List<JxcTGoods> jxcTGoods = jxcTGoodsMapper.selectList(null);


		String unitJson = JacksonUtil.toJSon(jxcTGoodsunits);
		String typeJson = JacksonUtil.toJSon(jxcTGoodstypes);
		String goodsJson = JacksonUtil.toJSon(jxcTGoods);


		redisTemplate.opsForValue().set(unit, unitJson);
		redisTemplate.opsForValue().set(type, typeJson);
		redisTemplate.opsForValue().set(goods, goodsJson);
*/




		/*List<JxcTGoods> jxcTGoodsunit = Arrays.asList(JacksonUtil.readValue(json, JxcTGoods[].class));
		// 导入 单位 分类 商品 数据
		jxcTGoodsunit.forEach(System.out::println);*/
	}

	/**
	 * 导入类型
	 */
	@Test
	public void testTypePath() {
	/*	String json =  redisTemplate.opsForValue().get(type);
		List<JxcTGoodstype> jxcTGoodstypeList = Arrays.asList(JacksonUtil.readValue(json, JxcTGoodstype[].class));
		//List<JxcTGoodstype> collect = jxcTGoodstypeList.stream().filter(e -> e.getState() == 1).collect(Collectors.toList());
		//无须 递归遍历
		tProductCategoryService.remove(null);
		jxcTGoodstypeList.forEach(item->{
			String path = getPath(item, jxcTGoodstypeList).replaceFirst(",", "")+","+item.getId();
			if(path.startsWith(",")){
				path = path.replaceFirst(",", "");
			}
			System.out.println(item.getId()+"=="+item.getName()+" "+path);

			TProductCategory tProductCategory = new TProductCategory();
			tProductCategory.setId(Long.valueOf(item.getId()));
			tProductCategory.setCode("");
			tProductCategory.setName(item.getName());
			tProductCategory.setCreatedTime(new Date());
			tProductCategory.setLastModifiedTime(new Date());
			tProductCategory.setVersion(0L);
			tProductCategory.setIsDelete(false);
			tProductCategory.setPId(Long.valueOf(item.getPId()));
			int length = path.split(",").length;
			if(length==4){
				length = 3;
				String[] split = path.split(",");

				tProductCategory.setPId(Long.valueOf(split[1]));

				path = split[0]+","+split[1]+","+split[3];
			}
			tProductCategory.setGradeId(Long.valueOf(length-1));
			tProductCategory.setPath(path);
			tProductCategory.setCreatedUser("admin");
			tProductCategory.setCreatedUserId(0L);
			// 3级 拆二级
			if(!item.getName().equals("test"))
			tProductCategoryService.save(tProductCategory);

		});*/


	}

	/**
	 * 导入单位
	 */
	@Test
	public void testUnit() {
	/*	tUnitService.remove(null);
		String jsonUnit =  redisTemplate.opsForValue().get(unit);
		List<JxcTGoodsunit> jxcTGoodsunits = Arrays.asList(JacksonUtil.readValue(jsonUnit, JxcTGoodsunit[].class));
		for (int i = 0; i < jxcTGoodsunits.size(); i++) {
			JxcTGoodsunit jxcTGoodsunit = jxcTGoodsunits.get(i);
			TUnit unit = new TUnit();
			unit.setId(Long.valueOf(jxcTGoodsunit.getId()));
			unit.setCode("");
			unit.setName(jxcTGoodsunit.getName());
			unit.setCreatedTime(new Date());
			unit.setLastModifiedTime(new Date());
			unit.setVersion(1L);
			unit.setIsDelete(false);


			tUnitService.save(unit);
		}*/

	}

	/**
	 * 导入商品信息
	 */
	@Test
	public void testGoods() {

	}

/*
	public String getPath(JxcTGoodstype goodstype,List<JxcTGoodstype> jxcTGoodstypeList){
		String path = "";
		JxcTGoodstype goodstype1 = goodstype(goodstype, jxcTGoodstypeList);
		if(null == goodstype1){
				return "";
		}else {
			JxcTGoodstype goodstype2 = goodstype(goodstype, jxcTGoodstypeList);

			return  getPath(goodstype(goodstype,jxcTGoodstypeList),jxcTGoodstypeList)+","+goodstype2.getId();
		}


	}
*/

	/*public JxcTGoodstype goodstype(JxcTGoodstype goodstype,List<JxcTGoodstype> jxcTGoodstypeList){
		for (int i = 0; i < jxcTGoodstypeList.size(); i++) {
			if(goodstype.getPId() == jxcTGoodstypeList.get(i).getId()){
				return jxcTGoodstypeList.get(i);
			}
		}
		return null;
	}

*/
	/*@Test
	public void testUnix(){
		JxcUser jxcUser = new JxcUser();
		jxcUser.setName("aaa");
		userMapper.insert(jxcUser);
	}*/

	@Test
	public void test011() {
		int i = 10;
		int j = 10;

		System.out.println("i + j = " + i + j);
		//System.out.println("i - j = "+i-j);
		System.out.println("i * j = " + i * j);
		System.out.println("i / j = " + i / j);
	}

	@Test
	public void test012() {
		method01(null);
	}

	public static void method01(String s) {
		System.out.println("aaa");
	}

	public static void method01(Object s) {
		System.out.println("bb");
	}

	class A{
		void a(){
			System.out.println("aa");
		}
	}

	class B extends A{
		void b(){
			super.a();

			System.out.println("b");
		}
	}

	@Test
	public void test07(){
		B b = new B();
		b.b();

	}

	interface Person {
		void eat();
	}

	class LaoWang implements Person {

		@Override
		public void eat() {
			System.out.println("aa");
		}
	}

	class P implements InvocationHandler{
		Object target;

		public P(Object targat) {
			this.target = targat;
		}

		public Object getP(){
			Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

			return o;

		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


		 return method.invoke(target,args);


		}
	}
}


