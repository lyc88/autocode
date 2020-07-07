package com.example.demo.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回对象
 */
public class Result extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public Result() {
		put("status", 200);
		put("message", "ok");
	}

	public static Result error() {
		return error(ApiResultEnum.ERROR);
	}

	public static Result error(String msg) {
		return error(ApiResultEnum.ERROR.getStatus(), msg);
	}

	public static Result error(int status, String msg) {
		Result r = new Result();
		r.put("status", status);
		r.put("message", msg);
		return r;
	}

	public static Result error(ApiResultEnum resultEnum) {
		Result r = new Result();
		r.put("status", resultEnum.getStatus());
		r.put("message", resultEnum.getMessage());
		return r;
	}

	public static Result ok() {
		return new Result();
	}

	public static Result ok(Map<String, Object> map) {
		Result r = new Result();
		r.putAll(map);
		return r;
	}

	public static <T> Result ok(T data) {
		Result r = new Result();
		r.put("data",data);
		return r;
	}

	@Override
	public Result put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}