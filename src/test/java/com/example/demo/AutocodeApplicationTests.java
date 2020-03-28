package com.example.demo;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.MysqlMapper;
import com.example.demo.service.AutoCode;
import com.example.demo.service.MysqlAutoService;
import com.example.demo.test.entity.*;
import com.example.demo.test.mapper.*;
import com.example.demo.test.service.TGoodsService;
import com.example.demo.test.service.TProductCategoryService;
import com.example.demo.test.service.TUnitService;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutocodeApplicationTests {

	@Autowired
	private MysqlAutoService mysqlAutoService;


	@Autowired
	private RedisTemplate<String,String> redisTemplate;

	@Autowired
	private JxcTGoodsMapper jxcTGoodsMapper;

	@Autowired
	private JxcTGoodstypeMapper jxcTGoodstypeMapper;

	@Autowired
	private JxcTGoodsunitMapper jxcTGoodsunitMapper;

	@Autowired
	private TProductCategoryService tProductCategoryService;

	@Autowired
	private TGoodsService tGoodsService;

	@Autowired
	private TUnitService tUnitService;

	@Autowired
	private AutoCode autoCode;

	@Autowired
	private JxcUserMapper userMapper;

	@Test
	public void contextLoads() throws IOException, TemplateException {

			mysqlAutoService.autoCode("user");

	}

	@Test
	public void  test01() {

		autoCode.autoCode("user");

	}

	// 初始化 进销存 数据 单位 分类 商品
	String unit = "jxc:unit";
	String type = "jxc:type";
	String goods = "jxc:goods";
	@Test
	public void  testImport() {

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

		String json =  redisTemplate.opsForValue().get(goods);


		List<JxcTGoods> jxcTGoodsunit = Arrays.asList(JacksonUtil.readValue(json, JxcTGoods[].class));
		// 导入 单位 分类 商品 数据
		jxcTGoodsunit.forEach(System.out::println);
	}

	/**
	 * 导入类型
	 */
	@Test
	public void testTypePath(){
		String json =  redisTemplate.opsForValue().get(type);
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

		});



	}

	/**
	 * 导入单位
	 */
	@Test
	public void testUnit(){
		tUnitService.remove(null);
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
		}

	}

	/**
	 * 导入商品信息
	 */
	@Test
	public void testGoods(){
		tGoodsService.remove(null);
		String jsonGoods =  redisTemplate.opsForValue().get(goods);
		List<JxcTGoods> jxcTGoods = Arrays.asList(JacksonUtil.readValue(jsonGoods, JxcTGoods[].class));
		for (int i = 0; i < jxcTGoods.size(); i++) {
			JxcTGoods jxcgoods = jxcTGoods.get(i);

			TGoods tGoods = new TGoods();
			tGoods.setId(Long.valueOf(jxcgoods.getId()));
			// 默认全部 标品
			tGoods.setCategoriesId(1);
			Integer typeId = jxcgoods.getTypeId();

			tGoods.setProductCategoryId(Long.valueOf(typeId));
			TProductCategory tProductCategory = tProductCategoryService.getById(typeId);
			tGoods.setProductCategory(tProductCategory.getName());
			Long pId = tProductCategory.getPId();
			if(pId != null){
				TProductCategory category = tProductCategoryService.getById(pId);
				tGoods.setProductCategoryTwoId(category.getId());
				tGoods.setProductCategoryTwo(category.getName());
			}

			tGoods.setBarcode("");
			tGoods.setCode(jxcgoods.getCode());
			tGoods.setName(jxcgoods.getName());
			tGoods.setStandard(jxcgoods.getModel());
			QueryWrapper<TUnit> tUnitQueryWrapper = new QueryWrapper<>();
			String unit = jxcgoods.getUnit();

			if(unit.equals("小包")){
				unit = "包";
			}
			if(unit.equals("大包")){
				unit = "包";
			}
			if(unit.equals("小盒")){
				unit = "盒";
			}
			if(unit.equals("1")){
				unit = "斤";
			}
			tUnitQueryWrapper.eq("name", unit);
			List<TUnit> tUnitList = tUnitService.list(tUnitQueryWrapper);
			if(!CollectionUtils.isEmpty(tUnitList))
			tGoods.setUnitId(tUnitList.get(0).getId());
			tGoods.setUnit(jxcgoods.getUnit());
			Float shelfLife = jxcgoods.getShelfLife();
			if(null != shelfLife){
				tGoods.setLife((int) Math.floor(jxcgoods.getShelfLife()));
			}

			tGoods.setWeight(new BigDecimal("0"));
			tGoods.setLength(new BigDecimal("0"));
			tGoods.setWidth(new BigDecimal("0"));
			tGoods.setHigh(new BigDecimal("0"));
			tGoods.setVolumes(new BigDecimal("0"));

			tGoods.setSafeQuantity((int) Math.floor(jxcgoods.getMinNum()));
			tGoods.setStorageTypeId(0);
			tGoods.setPicture("");
			tGoods.setComment("");

			tGoods.setCreatedUserId(0L);
			tGoods.setCreatedUser("admin");
			tGoods.setCreatedTime(new Date());
			tGoods.setLastModifiedTime(new Date());
			tGoods.setIsEnabled(false);
			tGoods.setVersion(0L);
			tGoods.setIsDelete(false);


			tGoodsService.save(tGoods);

		}

	}

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

	public JxcTGoodstype goodstype(JxcTGoodstype goodstype,List<JxcTGoodstype> jxcTGoodstypeList){
		for (int i = 0; i < jxcTGoodstypeList.size(); i++) {
			if(goodstype.getPId() == jxcTGoodstypeList.get(i).getId()){
				return jxcTGoodstypeList.get(i);
			}
		}
		return null;
	}


	@Test
	public void testUnix(){
		JxcUser jxcUser = new JxcUser();
		jxcUser.setName("aaa");
		userMapper.insert(jxcUser);
	}
}
