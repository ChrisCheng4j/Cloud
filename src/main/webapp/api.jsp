<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>TestCloud</title>
<script type="text/javascript" src="resources/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="resources/js/md5.js"></script>
<script type="text/javascript">
	var uid = '', token = '';
	
	function add(){
		var html = "<div>" + 
				   "<table align='center'>" + 
				   "<tr><th>From&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><th>method:</th><td>post</td><th>action:</th><td><input type='text'/></td><td><a href='#' onclick='deleteform(this)'>-</a></td></tr>" +
				   "<tr><th>Param&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><th>name:</th><td><input class='name' type='text' onkeyup='chname(this)'/></td><th>value:</th><td><input type='text' onkeyup='chvalue(this)'/></td><td></td></tr>" + 
				   "<tr><th></th><td></td><td></td><td></td><th><button type='button' onclick='submitform(this)' >submit</button></th><td><a href='#' onclick='addparam(this)'>+</a></td></tr>" + 
				   "</table>" + 
				   "<form><input type='hidden' /></form>" + 
				   "</div>"
		$('.button').before(html);
	}
	
	function deleteform(obj){
		var o = $(obj);
		o.parents('div').remove();
	}
	
	function addparam(obj){
		var o = $(obj);
		o.parents('tr').before("<tr><th></th><th>name:</th><td><input class='name' type='text' onkeyup='chname(this)'/></td><th>value:</th><td><input type='text' onkeyup='chvalue(this)'/></td><td><a href='#' onclick='deleteparam(this)'>-</a></td></tr>");
		o.parents('table').next('form').append("<input type='hidden' />");
	}
	
	function deleteparam(obj){
		var o = $(obj);
		var t = o.parents('tr').prevAll('tr').length - 1;
		o.parents('table').next('form').children().eq(t).remove();
		o.parents('tr').remove();
	}
	
	function chmethod(obj){
		var o = $(obj);
		o.parents('table').next('form').attr('method',o.val());
	}
	
	function chaction(obj){
		var o = $(obj);
		o.parents('table').next('form').attr('action',o.val());
	}
	
	function chname(obj){
		var o = $(obj);
		var t = o.parents('tr').prevAll('tr').length - 1;
		o.parents('table').next('form').children().eq(t).attr('name',o.val());
		var i = o.parents('tr').find('input').eq(1);
		if(o.val() == 'uid' && uid != ''){
			i.val(uid);
			chvalue(i);
		}
		if(o.val() == 'token' && token != ''){
			i.val(token);
			chvalue(i);
		}
	}
	
	function chvalue(obj){
		var o = $(obj);
		var t = o.parents('tr').prevAll('tr').length - 1;
		o.parents('table').next('form').children().eq(t).val(o.val());
	}
	
	function submitform(obj){
		var o = $(obj);
		var t = o.parents('table').children().first().find('input').val();
		if(t == ''){
			return;
		}
		$.post(t, o.parents('table').next('form').serializeArray(), function(data) {
			$('.info').prepend('<p>' + data + '</p>');
		},'text')
	}
	
	function clearinfo(){
		$('.info').empty();
	}
	
	function md5En(obj){
		var o = $(obj);
		var en = o.val();
		if(en == ''){
			o.next('input').val('');
		}else{
			o.next('input').val(hex_md5(en));
		}
	}
	
	function login(obj){
		var o = $(obj);
		var usr = o.prev('input').prev('input').val();
		var pwd = o.prev('input').val();
		if(usr == '' || pwd == '')
			return;
		$.post('us/login', {'usr':usr,'pwd':pwd,'device':'0'}, function(data) {
			if(data.S == 'OK'){
				$('#loginuid').val(data.R.uid);
				$('#logintoken').val(data.R.token);
				uid = data.R.uid;
				token = data.R.token;
			}else{
				alert('密码或用户名错误!');
			}
		})
	}
	
	
	function upload(){
		var width = $(window).width();
		var hight = $(window).height();
		var uploadwindow = window.open("", "upload" + new Date().getTime(),"height=300, width=500,left=" + (width - 500)/2 + ",top=" + (hight - 300)/2 + ",toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no,status=no");
		uploadwindow.document.write('<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml">');
		uploadwindow.document.write('<head><style>');
		uploadwindow.document.write('body{text-align: center;font-size: 12;padding-top: 50px;}');
		uploadwindow.document.write('input[type=text]{padding: 0px;margin: 0px;width: 250px;}');
		uploadwindow.document.write('input[type=file]{width:250px;}');
		uploadwindow.document.write('input[type=submit]{padding: 0px;margin: 0px;width:90px;}');
		uploadwindow.document.write('th{font-weight: normal;font-size: 12;text-align: right;}');
		uploadwindow.document.write('td{font-size: 12;text-align: left;padding-right: 10px;}');
		uploadwindow.document.write('</head></style>');
		uploadwindow.document.write('<body><div><form action=" mediaupload.do" enctype="multipart/form-data" method="post"><table  align="center">');
		uploadwindow.document.write('<tr><th>uid:</th><td><input type="text" name="uid" value="' + uid + '"/></td></tr>');
		uploadwindow.document.write('<tr><th>token:</th><td><input type="text" name="token" value="' + token + '"/></td></tr>');
		uploadwindow.document.write('<tr><th>hash:</th><td><input type="text" name="hash" /></td></tr>');
		uploadwindow.document.write('<tr><th>aid:</th><td><input type="text" name="aid" /></td></tr>');
		uploadwindow.document.write('<tr><th>tag:</th><td><input type="text" name="tag" value="picture" /></td></tr>');
		uploadwindow.document.write('<tr><th>path:</th><td><input type="text" name="path"  value="/" /></td></tr>');
		uploadwindow.document.write('<tr><th>direction:</th><td><input type="text" name="direction" value="0" /></td></tr>');
		uploadwindow.document.write('<tr><th>file:</th><td><input name="media" type="file" /></td></tr>');
		uploadwindow.document.write('<tr><th colspan="2"><input type="submit"  value="upload" /></th></tr>');
		uploadwindow.document.write('</table></form></div></body></html>');
	}
	
	function apilist(){
		var listwindow = window.open("", "list" + new Date().getTime());
		listwindow.document.write('<div>us/login:{usr,pwd,device}</div>');
		listwindow.document.write('<div>us/reg:{em,nickname,pwd}</div>');
		listwindow.document.write('<div>us/regWithVerify:{em,nickname,pwd,time,veriCode}</div>');
		listwindow.document.write('<div>us/info:{uid,token}</div>');
		listwindow.document.write('<div>us/uppwd:{uid,token,oldpwd,newpwd}</div>');
		listwindow.document.write('<div>us/getpwd:{em}</div>');
		listwindow.document.write('<div>us/getpwd1:{usr,code,pwd}</div>');
		listwindow.document.write('<div>album/list:{uid,token,status,time}  status和time可为空</div>');
		listwindow.document.write('<div>album/add:{uid,token,name,describe,type,access}  type和access可为空</div>');
		listwindow.document.write('<div>album/delete:{uid,token,aid}</div>');
		listwindow.document.write('<div>album/edit:{uid,token,aid,name,describe,type,status,access}  name,describe,type,status和access可为空</div>');
		listwindow.document.write('<div>album/detail:{uid,token,aid}</div>');
		listwindow.document.write('<div>media/list:{uid,token,aid,status,time}  status和time可为空</div>');
		listwindow.document.write('<div>media/upload:{uid,token,hash,aid,direction,path,tag,offset,media}  MultipartRequest</div>');
		listwindow.document.write('<div>media/delete:{uid,token,mid}</div>');
		listwindow.document.write('<div>media/edit:{uid,token,mid,name,tag,path,status}  name,tag,path和status可为空</div>');
		listwindow.document.write('<div>media/lastUpdate:{uid,token,aid}  aid可为空</div>');
		listwindow.document.write('<div>share/AMlist:{suid,token}</div> 查询分享给我的所以相册和相片');
		listwindow.document.write('<div>share/list:{uid,token,aid,mid}  aid和mid可为空</div>');
		listwindow.document.write('<div>share/add:{uid,token,aid,mid,suid}  aid和mid可为空</div>');
		listwindow.document.write('<div>share/delete:{uid,token,aid,mid,uid}  aid,mid和uid可为空</div>');
		listwindow.document.write('<div>share/url:{uid,token,aid,mid,isThumb,expires}  mid,isThumb和expires可为空</div>');
		listwindow.document.write('<div>share/access:{sign,uid,token}  uid和token可为空</div>');
	}
	
</script>
<style>
	body{text-align: center;font-size: 12;}
	.button{margin: 15px 20% 0 20%;text-align: right;min-width: 600px;}
	.info{margin: 5px 20% 0 20%;padding-top:10px;border-top: 1px solid gray; text-align: left;min-width: 600px;}
	input[type=text]{padding: 0px;margin: 0px;width: 250px;}
	input.name{width: 80px;}
	select{margin: 0px;width: 80px;}
	span{margin: 0px 10px 0px 30px}
	th{font-weight: normal;font-size: 12;text-align: right;}
	td{font-size: 12;text-align: left;padding-right: 10px;}
	button{width:90px;}
	a{text-decoration: none;margin: 0px 5px 0px 10px;color: maroon;}
	table{border: 1px solid gray; margin-top: 10px;}
	.info p{border-bottom: 1px solid gray;}
</style>
</head>
<body>
	<div>
		<table align='center'>
			<tr><th></th><td><input type="text" onkeyup="md5En(this)"/>&nbsp;&nbsp;md5&nbsp;&nbsp;to&nbsp;&nbsp;<input type="text" readonly="readonly"/></td></tr>
			<tr><th>email:</th><td><input type="text" />&nbsp;&nbsp;password:<input type="text" /><button type='button' onclick='login(this)' >&nbsp;login</button></td></tr>
			<tr><th>uid:</th><td><input class='name' type="text" id="loginuid" readonly="readonly" />&nbsp;&nbsp;token:<input type="text" id="logintoken" readonly="readonly" /></td></tr>
		</table>
	</div>
	<div>
	<table align='center'>
	<tr><th>From&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><th>method:</th><td>post</td><th>action:</th><td><input type='text'/></td><td></td></tr>
	<tr><th>Param&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><th>name:</th><td><input class='name' type='text' onkeyup='chname(this)'/></td><th>value:</th><td><input type='text' onkeyup='chvalue(this)'/></td><td></td></tr>
	<tr><th></th><td></td><td></td><td></td><th><button type='button' onclick='submitform(this)' >submit</button></th><td><a href='#' onclick='addparam(this)'>+</a></td></tr>
	</table>
	<form><input type='hidden' /></form>
	</div>
	<div class="button"><a href="JAVASCRIPT:apilist()">[API list]</a><button type="button" onclick="add()">add API</button><button type="button" onclick="upload()">upload API</button><button type="button" onclick="clearinfo()">clear info</button></div>
	<div class='info'></div>
</body>
</html>