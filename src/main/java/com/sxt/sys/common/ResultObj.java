package com.sxt.sys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {
	
	public static final ResultObj  LOGIN_SUCCESS=new ResultObj(Constast.OK, "登陆成功");
	public static final ResultObj  LOGIN_ERROR_PASS=new ResultObj(Constast.ERROR, "登陆失败,用户名或密码不正确");
	public static final ResultObj  LOGIN_ERROR_CODE=new ResultObj(Constast.ERROR, "登陆失败,验证码不正确");
	
	public static final ResultObj  UPDATE_SUCCESS=new ResultObj(Constast.OK, "更新成功");
	public static final ResultObj  UPDATE_ERROR=new ResultObj(Constast.ERROR, "更新失败");
	
	public static final ResultObj  ADD_SUCCESS=new ResultObj(Constast.OK, "添加成功");
	public static final ResultObj  ADD_ERROR=new ResultObj(Constast.ERROR, "添加失败");
	
	public static final ResultObj  DELETE_SUCCESS=new ResultObj(Constast.OK, "删除成功");
	public static final ResultObj  DELETE_ERROR=new ResultObj(Constast.ERROR, "删除失败");
	
	public static final ResultObj  RESET_SUCCESS=new ResultObj(Constast.OK, "重置成功");
	public static final ResultObj  RESET_ERROR=new ResultObj(Constast.ERROR, "重置失败");
	
	public static final ResultObj  DISPATCH_SUCCESS=new ResultObj(Constast.OK, "分配成功");
	public static final ResultObj  DISPATCH_ERROR=new ResultObj(Constast.ERROR, "分配失败");
	
	public static final ResultObj  OPERATE_SUCCESS=new ResultObj(Constast.OK, "操作成功");
	public static final ResultObj  OPERATE_ERROR=new ResultObj(Constast.ERROR, "操作失败");

	public static final ResultObj  APPLY_SUCCESS=new ResultObj(Constast.OK, "申请成功");
	public static final ResultObj  APPLY_ERROR=new ResultObj(Constast.ERROR, "申请失败");
	public static final ResultObj  APPLY_UPDATESUCCESS=new ResultObj(Constast.OK, "修改申请成功");
	public static final ResultObj  APPLY_UPDATEERROR=new ResultObj(Constast.ERROR, "修改申请失败");

	public static final ResultObj  APPROVAL_SUCCESS=new ResultObj(Constast.OK, "审批成功");
	public static final ResultObj  APPROVAL_ERROR=new ResultObj(Constast.ERROR, "审批失败");
	public static final ResultObj  APPLY_APPROVAL=new ResultObj(Constast.ERROR, "请先申请再审批");
	public static final ResultObj  APPROVAL_ED=new ResultObj(Constast.ERROR, "已审批无法再次审批");

	public static final ResultObj  BUY_SUCCESS=new ResultObj(Constast.OK, "采购完成");
	public static final ResultObj  BUY_ING=new ResultObj(Constast.OK, "正在采购");
	public static final ResultObj  BUY_ERROR=new ResultObj(Constast.ERROR, "采购失败");
	public static final ResultObj  APPROVAL_BUY=new ResultObj(Constast.ERROR, "请先审批再采购");
	public static final ResultObj  BUY_ED=new ResultObj(Constast.ERROR, "再次采购需再次提交申请");

	public static final ResultObj  REQUEST_SUCCESS=new ResultObj(Constast.OK, "请求成功");
	public static final ResultObj  NEED_LOGIN=new ResultObj(Constast.OK, "用户未登录");
	private Integer code;
	private String msg;
	
	

}
