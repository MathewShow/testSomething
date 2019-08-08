<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.easyvary.form.util.ConvertHelper"%>
<%@page import="com.easyvary.common.util.HibernateUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.hibernate.transform.Transformers"%>
<%@page import="engine.GlobalConstants"%>
<%@page import="java.sql.*"%>
<%
	long otdr_id = ConvertHelper.toLongX(request, "otdr_id", 0);
	Connection conn = null;
    Statement  st   = null;
	ResultSet  rs   = null;
	String sql = "";

	sql = "select count(case when cmc.actived=0 then 1  else null end) as activedCount,"
		+"count(case when cmc.scan=0 then 1  else null end) as scanCount "
		+" from LINK t,cycle_meas_config cmc "
		+" where cmc.link_id(+) = t.link_id and t.otdr_id="+otdr_id;

	HashMap map = new HashMap<String,Object>();
	map = (HashMap)HibernateUtil.getSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).uniqueResult();
	int activedCount = Integer.parseInt(map.get("ACTIVEDCOUNT").toString());
	int scanCount = Integer.parseInt(map.get("SCANCOUNT").toString());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="../../js/jquery/jquery.js"></script>
<script src="../../js/ui/util.js" charset="UTF-8"></script>
<script src="../../js/util/UIHelper.js" charset="UTF-8"></script>
<script src="../../js/chart/echarts.js"></script>
<script src="js/LinkList.js"></script>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	.line{
		width: 100%;
		padding-top: 100px;
	}
	.linkName{
		padding-left: 5px;
		font-size: 13px;
		font-family: Arial;
		width: 15%;
		cursor: pointer;
	}
	.length{
		padding-left: 5px;
		font-size: 13px;
		font-family: Arial;
		width: 5%;
		text-align: left;
	}
	.measTd{
		width: 76%;
	}
	.referenceMeasDiv{
		height: 30px;
		width: 28%;
		float:left;
	}
	.callingMeasDiv{
		height: 30px;
		width: 560px;
		float:left;
	}
	.cycleMeasDiv{
		height: 30px;
		width: 560px;
		float:left;
		display: none;
	}
	.referenceMeasButtom{
		margin-left: 2px;
		margin-right: 4px;
		width: 45px;
		float: left;
	}
	.callingMeasButtom{
		margin-left: 2px;
		width: 45px;
		float: left;
	}
	.cycleMeasButtom{
		margin-left: 2px;
		width: 45px;
		float: left;
		display: none;
	}
	#cycleMeasConfigList{
		width: 140px;
		margin-left: 10%;
	}
	#MeasAlarmThresholdList{
		width: 110px;
		margin-left: 20px;
	}
	#callingMeasList{
		width: 65px;
		margin-left: 25%;
		border-right: 0.5px solid #808080;
	}
	#cycleMeasList{
		width: 65px;
		border-left: 0.5px solid #808080;
		margin-left: 0;
	}
	.imgButton{
		cursor: pointer;
	}
	.divBtn{
		margin-top: 2px;
		text-align: center;
		height: 28px;
		line-height: 28px;
		float: left;
		display: inline-block;
		background-color: white;
		border: 1px solid #808080;
		color: #395260;
		cursor: pointer;
		font-size: 13px;
	}
	.measButton{
		margin-bottom: 2.5px;
	}
	.arrow-left{
		margin-right: 4px;
		margin-top: 5px;
	}
	.arrow-right{
		margin-right: 3px;
	}
</style>

</head>
<body>
<input type="hidden" id="otdr_id" value="<%=otdr_id%>">
<div id="main" style="height: 100%;width: 100%;">
<div id="buttomList" style="width: 100%;height: 38px;line-height: 38px;">
	<div id="cycleMeasConfigList" class="divBtn" onclick="setCycleMeasConfigList(<%=otdr_id%>)">
		<span><%=activedCount%><img src="../../images/otdr/cycle_actived.png" width="14px">周期</span>
		&nbsp;&nbsp;<span><%=scanCount%><img src="../../images/otdr/scan_actived.png" width="14px">扫描</span>
	</div>
	<div id="MeasAlarmThresholdList" class="divBtn" onclick="setMeasAlarmThresholdList(<%=otdr_id%>)">
		<img src="../../images/otdr/menjin.png" width="14px">
		设置告警门限
	</div>
	<div id="callingMeasList" class="divBtn">点名测试</div>
	<div id="cycleMeasList" class="divBtn">周期测试</div>
</div>
<!-- <div id="cutline" style="height: 2px;background-color: #fff;"></div> -->
<table style="height: 100%;width: 100%;">
<% 
	try
	{
		int i=0;
		long id;
        String name = "";
        String cycle_actived = "../../images/otdr/cycle_actived.png"; //激活周期图标
        String cycle_die = "../../images/otdr/cycle_die.png";  //未激活周期图标
        String scan_actived = "../../images/otdr/scan_actived.png"; //激活扫描图标
        String scan_die = "../../images/otdr/scan_die.png"; //未激活扫描图标
        String measCycleImg = "";
        String scanCycleImg = "";
        String measCycle = "";
        String scanCycle = "";
        double length;
        int actived=0;
        int scan=0;
        sql="select t.link_id as id, t.link_name as name, t.link_length as length,"
        			+" cmc.actived as actived, cmc.scan as scan, "
        			+" cmc.meas_cycle as meas_cycle, cmc.scan_cycle as scan_cycle, "
        			+" (case cmc.meas_cycle_unit when 0 then '分钟' when 1 then '小时' when 2 then '天' when 3 then '星期' when 4 then '月' end) as meas_cycle_unit "
        			+" from LINK t,cycle_meas_config cmc "
        			+" where t.otdr_id="+otdr_id
        			+" and cmc.link_id(+) = t.link_id"
        			+" order by t.otdr_toggle_index";
        conn = HibernateUtil.getSession().connection();
		st   = conn.createStatement();
        rs = st.executeQuery(sql);
        while ( rs.next() )
        {
        	id=rs.getLong("ID");
			name=rs.getString("NAME");
			if(name.indexOf("R")>0){	//截取名称，去掉结尾的R*
				name = name.substring(0, name.indexOf("R"));
			}
			length=rs.getDouble("LENGTH");
			actived=rs.getInt("ACTIVED");
			scan=rs.getInt("SCAN");
			measCycleImg = (actived==0?cycle_actived:cycle_die);
			scanCycleImg = (scan==0?scan_actived:scan_die);
			measCycle = (actived==0?"测试周期："+rs.getInt("MEAS_CYCLE")+rs.getString("MEAS_CYCLE_UNIT")+"":"无测试周期");
			scanCycle = (scan==0?"扫描周期："+rs.getInt("SCAN_CYCLE")+"分钟":"无扫描周期");
			out.println("<tr class='line'>"
			               +"<td class='linkName' onclick='showLinkDetail("+id+")'>"+name+"</td>"  //链路名称格
			               +"<td class='length'>"  //存放周期、扫描图标的表格
			               		+"<img class='imgButton' src='"+measCycleImg+"' title='"+measCycle+"' width='14px' style='margin-right: 2px;' onclick='cycleMeasConfig("+id+")'>&nbsp;"
			               		+"<img class='imgButton' src='"+scanCycleImg+"' title='"+scanCycle+"' width='14px' style='margin-right: 2px;' onclick='cycleMeasConfig("+id+")'>&nbsp;"
			               		+"<img class='imgButton' title='设置门限' src='../../images/otdr/menjin.png' width='14px' onclick='alarmThreshold("+id+")'>"
			               +"</td>"
			               +"<td class='measTd'>"  //存放散点图相关DIV的表格
				               +"<div id='referenceMeasList"+i+"' class='referenceMeasDiv'></div>" //参考测试散点图DIV
				               +"<div class='referenceMeasButtom'>"		//参考测试按钮列表
				               		+"<img class='imgButton arrow-left' src='../../images/otdr/arrow-left.png' width='10px' height='20px' divId='referenceMeasList"+i+"' actived='false'>"
				               		+"<img class='imgButton arrow-right' src='../../images/otdr/arrow-right.png' width='10px' height='20px' divId='referenceMeasList"+i+"' actived='false'>"
				               		+"<img class='imgButton measButton' src='../../images/otdr/plusBtn.png' width='15px' onclick='showMeasList("+id+",1)'>"
			               	   +"</div>"
				               +"<div id='callingMeasList"+i+"' class='callingMeasDiv'></div>"  //点名测试散点图DIV
				               +"<div class='callingMeasButtom'>"	//点名测试按钮列表
				               		+"<img class='imgButton arrow-left' src='../../images/otdr/arrow-left.png' width='10px' height='20px' divId='callingMeasList"+i+"' actived='false'>"
				               		+"<img class='imgButton arrow-right' src='../../images/otdr/arrow-right.png' width='10px' height='20px' divId='callingMeasList"+i+"' actived='false'>"
				               		+"<img class='imgButton measButton' src='../../images/otdr/plusBtn.png' style='width:15px;' onclick='showMeasList("+id+",2)'>"
			               	   +"</div>"
				               +"<div id='cycleMeasList"+i+"' class='cycleMeasDiv'></div>"  //周期测试散点图DIV
				               +"<div class='cycleMeasButtom'>"	//周期测试按钮列表
				               		+"<img class='imgButton arrow-left' src='../../images/otdr/arrow-left.png' width='10px' height='20px' divId='cycleMeasList"+i+"' actived='false'>"
				               		+"<img class='imgButton arrow-right' src='../../images/otdr/arrow-right.png' width='10px' height='20px' divId='cycleMeasList"+i+"' actived='false'>"
				               		+"<img class='imgButton measButton' src='../../images/otdr/plusBtn.png' style='width:15px;' onclick='showMeasList("+id+",3)'>"
			               		+"</div>"
				               +"<div style='clear:both;'></div>"
			               +"</td>"
		               +"</tr>");	
			i++;
        }
		rs.close();
	}
	catch(Exception e)
	{
		throw(e);
	}
	finally
	{
		if (rs != null) rs.close();
		HibernateUtil.closeSession();
	}
%>
	 <!-- <tr class='line'>
		<td class='selectBox'></td>
		<td class='linkName'>Lk_福州一厂F36-日溪(晋安区本地汇聚)R10</td>
		<td class="length"><img src="../../images/otdr/menjin.png" width="16px"></td>
		<td class='measTd'><div id='ReferenceMeasList' class='measDiv1'></div></td>
		<td class='measTd'><div id='CallingMeasList' class='measDiv2'></div></td>
		<td class='measTd'><div id='CycleMeasList' class='measDiv3'></div></td>
	</tr> -->
</table>
</div>
</body>
</html>