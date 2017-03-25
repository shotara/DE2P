/**
 * 
 */




function validateEmail(email){
	var regex =  /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/; 
	
	if(regex.test(email)=== false){
		return false;
	}else{
		return true;
	}
}

function checkWhitespace(str){
	return str.replace(/(\s*)/g, "");
}

function protectXSS(data){
	
	data = data.replace(/</g,"&lt;").replace(/>/g,"&gt;");
	data = data.replace(/\\/g, "&#40;").replace(/\\/g, "&#41;");
	data = data.replace(/'/g, "&#39;");	
	data = data.replace(/"/g, "&#34;");	
	data = data.replace("eval\\((.*)\\)", "");
	data = data.replace("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
	data = data.replace(/script/g, "");
	data = data.replace(/javascript/g, "x-javascript");
	data = data.replace(/script/g, "x-script");
	data = data.replace(/iframe/g, "x-iframe");
	data = data.replace(/document/g, "x-document");
	data = data.replace(/vbscript/g, "x-vbscript");
	data = data.replace(/applet/g, "x-applet");
	data = data.replace(/embed/g, "x-embed");  // embed 태그를 사용하지 않을 경우만
	data = data.replace(/object/g, "x-object");    // object 태그를 사용하지 않을 경우만
	data = data.replace(/frame/g, "x-frame");
	data = data.replace(/grameset/g, "x-grameset");
	data = data.replace(/layer/g, "x-layer");
	data = data.replace(/bgsound/g, "x-bgsound");
	data = data.replace(/alert/g, "x-alert");
	data = data.replace(/onblur/g, "x-onblur");
	data = data.replace(/onchange/g, "x-onchange");
	data = data.replace(/onclick/g, "x-onclick");
	data = data.replace(/ondblclick/g, "x-ondblclick");
	data = data.replace(/enerror/g, "x-enerror");
	data = data.replace(/onfocus/g, "x-onfocus");
	data = data.replace(/onload/g, "x-onload");
	data = data.replace(/onmouse/g, "x-onmouse");
	data = data.replace(/onscroll/g, "x-onscroll");
	data = data.replace(/onsubmit/g, "x-onsubmit");
	data = data.replace(/onunload/g, "x-onunload");
	
	return data;
}