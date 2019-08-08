function checkZone(){//检查起始位置,结束位置
	if($('zoneStop').val()<=$('zoneStart').val()){
		alert("终止位置必须大于起始位置");
		return false
	}
	return true;

}