var ouserName = document.getElementById("username")
var otelphone = document.getElementById('telphone')
var oemail = document.getElementById("email")
var oaddress = document.getElementById("address");

var o_erroruserName = document.getElementById("error_name")
var o_errortelphone = document.getElementById('error_contact')
var o_erroremail = document.getElementById("error_email")
var o_erroraddress = document.getElementById("error_address");

var userNameStr = ""
var userTel = ""
var userEmail = ""
var useAddress = ""
function JudgeUserName(){
    var reg = /[\s\S]{3,6}/
    if(!ouserName.value){
        o_erroruserName.innerText = ""
        o_erroruserName.innerText = o_erroruserName.getAttribute("data-errortips")
    }
    else if(ouserName.value.match(reg)){
        o_erroruserName.innerText = ""
        userNameStr = ouserName.value
    }else{
        o_erroruserName.innerText = o_erroruserName.getAttribute("data-errortips-num")
    }

}
function JudgeTel(){
    var reg = /[\s\S]{11,11}/
    if(!otelphone.value){
        o_errortelphone.innerText = ""
        o_errortelphone.innerText = o_errortelphone.getAttribute("data-errortips")
    }
    else if(otelphone.value.match(reg)){
        o_errortelphone.innerText = ""
        telphoneStr = otelphone.value
    }else{
        o_errortelphone.innerText = o_errortelphone.getAttribute("data-errortips-num")
    }

}
function JudgeEmail(){
    var reg = /[\s\S]{1,16}@[\s\S]{2,9}.\w{2,5}/
    if(!oemail.value){
        o_erroremail.innerText = ""
        o_erroremail.innerText = o_erroremail.getAttribute("data-errortips")
    }
    else if(oemail.value.match(reg)){
        o_erroremail.innerText = ""
        userEmailStr = oemail.value
    }else{
        o_erroremail.innerText = o_erroremail.getAttribute("data-errortips-num")
    }

}
function JudgeAddress(){
    var reg = /[\s\S]{5,10}/
    if(!oaddress.value){
        o_erroraddress.innerText = ""
        o_erroraddress.innerText = o_erroraddress.getAttribute("data-errortips")
    }
    else{
        o_erroraddress.innerText = ""
        userAddressStr = oaddress.value
    }

}