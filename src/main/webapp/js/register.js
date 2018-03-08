function toRegister(){
    var name=document.getElementById("r_name").value;
    var password=document.getElementById("r_password").value;
    var confirmPass=document.getElementById("r_confirmPass").value;
    var bankcard=document.getElementById("r_bankcardId").value;
    var mail=document.getElementById("r_mailbox").value;

    if(name==""){
        alert("用户名不能为空");
        return false;
    }
    if(password==""||confirmPass==""){
        alert("密码不能为空");
        return false;
    }
    if(password!=confirmPass){
        alert("两次密码不匹配，请重新输入！");
        return false;
    }
    if(mail==""){
        alert("请输入邮箱");
        return false;
    }
    return true;
}
