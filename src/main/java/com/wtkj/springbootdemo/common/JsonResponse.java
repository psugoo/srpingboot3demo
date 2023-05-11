package com.wtkj.springbootdemo.common;




import com.wtkj.springbootdemo.utils.Assert;

import java.io.Serializable;


/**
 * 接口返回JSON格式
 *
 * @param <T>
 */
public class JsonResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 返回code
	 */
	private JsonCodeEnum code;

	/**
	 * 消息
	 */
	private String msg;


	/**
	 * 数据
	 */
	private T data;


	/**
	 * 是否成功
	 * 	true:成功
	 * 	false:失败
	 */
	private boolean success = false;



	public JsonResponse() {
		super();
	}

	public JsonResponse(JsonCodeEnum code, String msg) {
		super();
		setCode(code);
		this.msg = msg;
	}



	public JsonResponse(JsonCodeEnum code) {
		super();
		setCode(code);
	}

	public JsonResponse(JsonCodeEnum code, T data, boolean success, String msg) {
		super();
		setCode(code);
		this.data = data;
		this.success = success;
		this.msg = msg;
	}

	public JsonResponse(JsonCodeEnum code, T data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	public JsonResponse<T> code(JsonCodeEnum code, String msg, T data) {
		return new JsonResponse<T>(code, data, msg);
	}

	public JsonResponse<?> code(JsonCodeEnum code, String msg) {
		return code(code, msg, null);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		if (Assert.isNullOrEmpty(msg)) {
			msg = getCode().getMessage();
		}
		this.msg = msg;
	}

	public JsonCodeEnum getCode() {
		return code;
	}

	public void setCode(JsonCodeEnum code) {
		this.code = code;
		setMsg(code.getMessage());
		if (JsonCodeEnum.isSuccess(code)) {
			setSuccess(true);
		} else {
			setSuccess(false);
		}
	}



	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	/**
	 * 成功消息
	 * @param message
	 * @return
	 */
	public static <E> JsonResponse<E> success(String message) {

		JsonResponse<E> result = new JsonResponse<E>();

		result.setCode(JsonCodeEnum.SUCCESS);
		result.setMsg(message);
		result.setData(null);
		result.setSuccess(true);

		return result;

	}


	/**
	 * 成功消息
	 * @param data
	 * @return
	 */
	public static <E> JsonResponse<E> success(E data) {

		JsonResponse<E> result = new JsonResponse<E>();

		result.setCode(JsonCodeEnum.SUCCESS);
		result.setMsg("ok");
		result.setData(data);
		result.setSuccess(true);

		return result;

	}


	/**
	 * 成功消息
	 * @param message
	 * @param data
	 * @return
	 */
	public static <E> JsonResponse<E> success(String message,E data) {

		JsonResponse<E> result = new JsonResponse<E>();

		result.setCode(JsonCodeEnum.SUCCESS);
		result.setMsg(message);
		result.setData(data);
		result.setSuccess(true);

		return result;

	}


	/**
	 * 成功消息
	 * @return
	 */
	public static <E> JsonResponse<E> success() {

		JsonResponse<E> result = new JsonResponse<E>();

		result.setCode(JsonCodeEnum.SUCCESS);
		result.setMsg("");
		result.setData(null);
		result.setSuccess(true);

		return result;

	}


	/**
	 * 失败消息
	 * @return
	 */
	public static <E> JsonResponse<E> fail() {

		JsonResponse<E> result = new JsonResponse<E>();

		result.setCode(JsonCodeEnum.FAIL);
		result.setMsg("fail");
		result.setData(null);
		result.setSuccess(false);

		return result;

	}


	/**
	 * 失败消息
	 * @return
	 */
	public static <E> JsonResponse<E> fail(String message) {

		JsonResponse<E> result = new JsonResponse<E>();

		result.setCode(JsonCodeEnum.FAIL);
		result.setMsg(message);
		result.setData(null);
		result.setSuccess(false);

		return result;

	}















}