
var oLoginSpan = document.getElementById('login')
var ostudent_RegisterSpan = document.getElementById('student-register')
var oteacher_RegisterSpan = document.getElementById('teacher-register')
var oPhoneLogin = document.getElementById('phonelogin')
var ostudent_Register = document.getElementById('student-register-area')
var oteacher_Register = document.getElementById('teacher-register-area')
var eyeArr = document.getElementsByClassName('eye')
var len = eyeArr.length
var login_ipt = document.getElementById('login_ipt')
var login_pwd = document.getElementById('login_pwd')
var err_login_ipt = document.getElementById('error_login_ipt')
var err_login_pwd = document.getElementById('error_login_pwd')
var key = true
//学生
var student_ipt = document.getElementById('student_tel')
var student_f_pwd = document.getElementById('student_f_pwd')
var student_s_pwd = document.getElementById('student_s_pwd')
var err_student_ipt = document.getElementById('error_student_ipt')
var err_student_f_pwd = document.getElementById('error_student_f_pwd')
var err_student_s_pwd = document.getElementById('error_student_s_pwd')
var studentFKey = false
var studentSKey = false
//教师
var teacher_ipt = document.getElementById('teacher_tel')
var teacher_f_pwd = document.getElementById('teacher_f_pwd')
var teacher_s_pwd = document.getElementById('teacher_s_pwd')
var err_teacher_ipt = document.getElementById('error_teacher_ipt')
var err_teacher_f_pwd = document.getElementById('error_teacher_f_pwd')
var err_teacher_s_pwd = document.getElementById('error_teacher_s_pwd')
var teacherFKey = false
var teacherSKey = false
function Click() {
    oLoginSpan.onclick = function () {
        ostudent_RegisterSpan.className = "student-register"
        oteacher_RegisterSpan.className = "teacher-register"
        oLoginSpan.className = "login active"
        ostudent_Register.className = "student-register-area hidden"
        oteacher_Register.className = "teacher-register-area hidden"
        oPhoneLogin.className = "phonelogin"
    }
    ostudent_RegisterSpan.onclick = function () {
        oLoginSpan.className = "login"
        oteacher_RegisterSpan.className = "teacher-register"
        ostudent_RegisterSpan.className = "student-register active"
        oPhoneLogin.className = "phonelogin hidden"
        oteacher_Register.className = "teacher-register-area hidden"
        ostudent_Register.className = "student-register-area"
        studentFKey = true
        teacherSKey = true
    }
    oteacher_RegisterSpan.onclick = function () {
        oLoginSpan.className = "login"
        ostudent_RegisterSpan.className = "student-register"
        oteacher_RegisterSpan.className = "teacher-register active"
        oPhoneLogin.className = "phonelogin hidden"
        ostudent_Register.className = "student-register-area hidden"
        oteacher_Register.className = "teacher-register-area"
        teacherFKey = true
    }
    for (var i = 0; i < len; i++) {
        (function (i) {
            eyeArr[i].addEventListener('click', function () {
                if (key) {
                    eyeArr[i].className = "iconfont icon-yanjing eye"
                    login_pwd.type = "text"
                    key = false
                    if (studentFKey) {
                        student_f_pwd.type = "text"
                        studentFKey = false
                    }
                    if (studentSKey) {
                        student_s_pwd.type = "text"
                        studentSKey = false
                    }
                    if (teacherFKey) {
                        teacher_f_pwd.type = "text"
                        teacherFKey = false
                    }
                    if (!teacherSKey) {
                        teacher_s_pwd.type = "text"
                        teacherSKey = true
                    }
                } else {
                    eyeArr[i].className = "iconfont icon-yanjing1 eye"
                    login_pwd.type = "password"
                    key = true
                    if (!studentFKey) {
                        student_f_pwd.type = "password"
                        studentFKey = true
                    }
                    if (!studentSKey) {
                        student_s_pwd.type = "password"
                        studentSKey = true
                    }
                    if (!teacherFKey) {
                        teacher_f_pwd.type = "password"
                        teacherFKey = true
                    }
                    if (teacherSKey) {
                        teacher_s_pwd.type = "password"
                        teacherSKey = false
                    }
                }
            })
        }(i))
    }
}
Click()
//登录
var useTel = ""
var usePwd = ""
function blurJudgeTel(event) {
    regTel()
}
function blurJudgePwd(event) {
    regPwd()
}
function regTel() {
    var reg = /\d{11,11}/
    var str = "" + login_ipt.value + ""
    if (str.match(reg)) {
        err_login_ipt.innerText = ""
        useTel = login_ipt.value
    } else {
        err_login_ipt.innerText = err_login_ipt.getAttribute("data-errortips")
    }
}
function regPwd() {
    if (!login_pwd.value) {
        err_login_pwd.innerText = err_login_pwd.getAttribute("data-errortips")
    } else {
        var reg = /[\s\S]{6,16}/
        var str = "" + login_pwd.value + ""
        if (str.match(reg)) {
            err_login_pwd.innerText = ""
            usePwd = login_pwd.value
        } else {
            err_login_pwd.innerText = err_login_pwd.getAttribute("data-errortips-num")
        }
    }
}
//学生注册
var studentPwdStr = ""
function blurJudgeStudentTel(event) {
    regStudentTel()
}
function blurJudgeStudentFPwd(event) {
    regStudentFPwd()
}
function blurJudgeStudentSPwd(event) {
    regStudentSPwd()
}
function regStudentTel() {
    var reg = /\d{11,11}/
    var str = "" + student_ipt.value + ""
    if (str.match(reg)) {
        err_student_ipt.innerText = ""
    } else {
        err_student_ipt.innerText = err_student_ipt.getAttribute("data-errortips")
    }
}
function regStudentFPwd() {
    if (!student_f_pwd.value) {
        err_student_f_pwd.innerText = err_student_f_pwd.getAttribute("data-errortips")
    } else {
        var reg = /[\s\S]{6,16}/
        var str = "" + student_f_pwd.value + ""
        if (str.match(reg)) {
            err_student_f_pwd.innerText = ""
        } else {
            err_student_f_pwd.innerText = err_student_f_pwd.getAttribute("data-errortips-num")
        }
        studentPwdStr = str
    }
}
function regStudentSPwd() {
    if (!student_s_pwd.value) {
        err_student_s_pwd.innerText = err_student_s_pwd.getAttribute("data-errortips")
    } else {
        var reg = /[\s\S]{6,16}/
        var str = "" + student_s_pwd.value + ""
        if (str.match(reg)) {
            err_student_s_pwd.innerText = ""
        } else if (str != studentPwdStr) {
            err_student_s_pwd.innerText = err_student_s_pwd.getAttribute("data-errortips-num1")
        }
    }
}
//教师注册
var studentPwdStr = ""
function blurJudgeTeacherTel(event) {
    regTeacherTel()
}
function blurJudgeTeacherFPwd(event) {
    regTeacherFPwd()
}
function blurJudgeTeacherSPwd(event) {
    regTeacherSPwd()
}
function regTeacherTel() {
    var reg = /\d{11,11}/
    var str = "" + teacher_ipt.value + ""
    if (str.match(reg)) {
        err_teacher_ipt.innerText = ""
    } else {
        err_teacher_ipt.innerText = err_teacher_ipt.getAttribute("data-errortips")
    }
}
function regTeacherFPwd() {
    if (!teacher_f_pwd.value) {
        err_teacher_f_pwd.innerText = err_teacher_f_pwd.getAttribute("data-errortips")
    } else {
        var reg = /[\s\S]{6,16}/
        var str = "" + teacher_f_pwd.value + ""
        if (str.match(reg)) {
            err_teacher_f_pwd.innerText = ""
        } else {
            err_teacher_f_pwd.innerText = err_teacher_f_pwd.getAttribute("data-errortips-num")
        }
        teacherPwdStr = str
    }
}
function regTeacherSPwd() {
    if (!teacher_s_pwd.value) {
        err_teacher_s_pwd.innerText = err_teacher_s_pwd.getAttribute("data-errortips")
    } else {
        var reg = /[\s\S]{6,16}/
        var str = "" + teacher_s_pwd.value + ""
        if (str.match(reg)) {
            err_teacher_s_pwd.innerText = ""
        } else if (str != teacherPwdStr) {
            err_teacher_s_pwd.innerText = err_teacher_s_pwd.getAttribute("data-errortips-num1")
        }
    }
}

function Judge() {
    var key = 0
    dataArr.forEach(function(ele,index){
        if( useTel == ele.mobile && usePwd == ele.pwd){
            key++
        }else if(useTel != ele.mobile || usePwd != ele.pwd){
            key += 2
        }
    })
    if(key%2 == 0){
        alert("登录失败")
    }else{
        setTimeout(function(){
         window.location.href = 'PersonalCenter.html'
        },1000)
       console.log("登录成功")
    }
}